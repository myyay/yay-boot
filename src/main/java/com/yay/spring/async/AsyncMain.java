package com.yay.spring.async;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/11/8 18:14
 */
public class AsyncMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);

        AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);

        for (int i = 0; i < 10; i++) {
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }

        context.close();

    }
}
