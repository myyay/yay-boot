package com.yay.spring.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/11/17 13:50
 */
@SpringBootApplication
public class DynamicPropertyMain {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(DynamicPropertyMain.class);

        for (int i = 0; i < 100; i++) {
            DynamicPropertyService bean = context.getBean(DynamicPropertyService.class);
            bean.print();

            System.out.println("我的print:" + context.getEnvironment().getPropertySources().get(DynamicPropertyConfig.DYNAMIC_CONFIG_NAME).getProperty("dynamicInfo"));
            Thread.sleep(200);
        }

    }
}
