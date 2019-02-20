package com.yay.spring.combination;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/11/9 15:47
 */
public class CombineMain {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CombineConfig.class);
        DemoService bean = context.getBean(DemoService.class);
        bean.outputResult();


    }

}
