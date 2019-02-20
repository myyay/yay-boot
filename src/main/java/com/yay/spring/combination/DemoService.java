package com.yay.spring.combination;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/11/9 15:48
 */
@Service
public class DemoService {

    public void outputResult() {
        System.out.println("Just service");

        ThreadFactoryBuilder builder = new ThreadFactoryBuilder();
        builder.setNameFormat("demo-pool-%d");
        builder.build();

        ExecutorService executorService = new ThreadPoolExecutor(2, 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(2), builder.build(), new ThreadPoolExecutor.AbortPolicy());
        executorService.execute(() -> System.out.println("123"));

        executorService.shutdown();

    }

}
