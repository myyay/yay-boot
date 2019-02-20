package com.yay.spring.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/1/12 17:00
 */
public class ElMain {
    public static void main(String[] args) throws Throwable {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElConfig.class);
        MyProcess process = context.getBean(MyProcess.class);

        String result = process.process(createRequest());

        System.out.println("result:" + result);

        context.close();

    }

    private static MyRequest createRequest() {
        MyRequest request = new MyRequest();
        request.setName("name");
        request.setAge(18);
        request.setGood(true);
        request.setSex(EmSex.F);
        return request;
    }
}
