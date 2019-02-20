package com.yay.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2016/12/28 14:34
 */
public class AopMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        //DemoMethodService methodService = context.getBean(DemoMethodService.class);
        DemoAnoService anoService = context.getBean(DemoAnoService.class);

        //methodService.add();
        MyParam param = new MyParam();
        param.setPin("Pin");
        anoService.add(param);

        context.close();

    }
}
