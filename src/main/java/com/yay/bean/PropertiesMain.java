package com.yay.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/11/6 10:56
 */
public class PropertiesMain {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PropertiesConfig.class);
        MyProperties myProperties = context.getBean(MyProperties.class);
        System.out.println(myProperties.getName());
        System.out.println(myProperties.getTitle());
        System.out.println(myProperties.getCharset());

        User user = context.getBean(User.class);
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getAge());


        System.out.println(myProperties.getClass().getName());

        PropertiesConfig bean = context.getBean(PropertiesConfig.class);
        System.out.println(bean.getCcName());
        System.out.println(bean.getId());
        System.out.println(bean.getYayName());

    }

}
