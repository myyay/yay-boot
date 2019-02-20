package com.yay.spring.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/11/8 18:42
 */
@Service
public class AsyncTaskService {
    @Async
    public void executeAsyncTask(Integer i) {
        System.out.println("执行异步任务:" + i);

    }

    @Async
    public void executeAsyncTaskPlus(Integer i) {
        System.out.println("执行异步任务+1:" + (i + 1));
        throw new RuntimeException("天哪");
    }
}
