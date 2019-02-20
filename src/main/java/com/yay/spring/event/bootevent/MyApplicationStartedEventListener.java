package com.yay.spring.event.bootevent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/11/16 17:18
 */
public class MyApplicationStartedEventListener implements ApplicationListener<ApplicationStartingEvent> {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        SpringApplication app = event.getSpringApplication();
        app.setBannerMode(Banner.Mode.OFF);
        logger.info("==MyApplicationStartedEventListener==");
        System.out.println("MyApplicationStartedEventListener");

    }
}
