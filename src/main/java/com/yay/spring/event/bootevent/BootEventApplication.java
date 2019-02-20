package com.yay.spring.event.bootevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/11/16 17:24
 */
@SpringBootApplication
public class BootEventApplication {

    public static void main(String[] args) {
        //ConfigurableApplicationContext context = SpringApplication.run(BootEventApplication.class);
        SpringApplication app = new SpringApplication(BootEventApplication.class);
        app.addListeners(new MyApplicationStartedEventListener());
        app.addListeners(new MyApplicationEnvironmentPreparedEventListener());
        app.addListeners(new MyApplicationPreparedEventListener());
        app.run(args);

    }

}
