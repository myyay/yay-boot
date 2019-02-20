package com.yay.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.yay.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2018/7/5 14:39
 */
public class TestPool {

    private static final Logger logger = LoggerFactory.getLogger(TestPool.class);


    public static ThreadPoolExecutor createSavePool() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("save-pool-%d").build();
        int threadsCount = Runtime.getRuntime().availableProcessors();
        return new ThreadPoolExecutor(threadsCount, threadsCount,
                10L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(50), threadFactory, (r, executor) -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executor.execute(r);
        });
    }


    public static void overPool(ThreadPoolExecutor poolExecutor) {
        if (null == poolExecutor) {
            return;
        }

        if (!poolExecutor.isShutdown()) {
            poolExecutor.shutdown();
        }

        logger.info("关闭线程池,等待线程执行完成");
        try {
            while (!poolExecutor.awaitTermination(5, TimeUnit.SECONDS)) {
                logger.info("线程池中线程未执行完成");
                printPoolStatus(poolExecutor);
                Thread.sleep(1000);
            }
            logger.info("线程池中线程执行完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static void printPoolStatus(ThreadPoolExecutor poolExecutor) {
        String builder = DateUtils.formatDate(new Date(), DateUtils.FORMAT_DATETIME) + " 线程池状态: " +
                " CorePoolSize:" + poolExecutor.getCorePoolSize() +
                " TaskCount:" + poolExecutor.getTaskCount() +
                " MaximumPoolSize:" + poolExecutor.getMaximumPoolSize() +
                " CompletedTaskCount:" + poolExecutor.getCompletedTaskCount() +
                " ActiveCount:" + poolExecutor.getActiveCount() +
                " KeepAliveTime:" + poolExecutor.getKeepAliveTime(TimeUnit.SECONDS) +
                " PoolSize:" + poolExecutor.getPoolSize() +
                " LargestPoolSize:" + poolExecutor.getLargestPoolSize() +
                " QueueSize:" + poolExecutor.getQueue().size();
        logger.info("线程池状态:" + builder);
    }


}
