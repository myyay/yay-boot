package com.yay.pool;

import com.yay.utils.DateUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2018/7/5 14:42
 */
public class PoolMain {

    public static void main(String[] args) {
        final ThreadPoolExecutor savePool = TestPool.createSavePool();
        final List<String> list = new ArrayList<String>(1000);
        final StringBuilder builder = new StringBuilder();
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            builder.setLength(0);
            builder.append(DateUtils.formatDate(new Date(), DateUtils.FORMAT_DATETIME)).append(" 线程池状态: ")
                    .append(" getCorePoolSize:").append(savePool.getCorePoolSize())
                    .append(" getTaskCount:").append(savePool.getTaskCount())
                    .append(" getMaximumPoolSize:").append(savePool.getMaximumPoolSize())
                    .append(" getCompletedTaskCount:").append(savePool.getCompletedTaskCount())
                    .append(" getActiveCount:").append(savePool.getActiveCount())
                    .append(" getKeepAliveTime:").append(savePool.getKeepAliveTime(TimeUnit.SECONDS))
                    .append(" getPoolSize:").append(savePool.getPoolSize())
                    .append(" getLargestPoolSize:").append(savePool.getLargestPoolSize())
                    .append(" getQueueSize:").append(savePool.getQueue().size());
            list.add(builder.toString());

        }, 500L, 200L, TimeUnit.MILLISECONDS);

        for (int i = 0; i < 200; i++) {
            savePool.execute(new PoolThread("第" + i + "个"));
            System.out.println("增加内容: " + i);
        }

        TestPool.overPool(savePool);


        File file = new File("d:\\log.txt");

        try {
            FileUtils.writeLines(file,"UTF-8",list,false);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
