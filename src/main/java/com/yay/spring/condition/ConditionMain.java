package com.yay.spring.condition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/11/9 13:54
 */
public class ConditionMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);

        ListService bean = context.getBean(ListService.class);
        System.out.println(bean.getClass().getName());
        System.out.println(bean.showCmd());

    }
}
