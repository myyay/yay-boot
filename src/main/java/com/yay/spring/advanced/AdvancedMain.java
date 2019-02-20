package com.yay.spring.advanced;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/11/8 18:14
 */
public class AdvancedMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AdvancedConfig.class);
        AwareService awareService = context.getBean(AwareService.class);
        awareService.outputResult();


    }
}
