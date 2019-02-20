package com.yay.spring.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2016/12/28 14:08
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        UseFuncService useFuncService = context.getBean(UseFuncService.class);
        System.out.println(useFuncService.sayHello("java config"));
        context.close();
    }
}
