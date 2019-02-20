package com.yay.spring.event.bootevent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/11/16 18:02
 */
public class MyApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent>{
    private Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        ConfigurableApplicationContext cac = event.getApplicationContext();
        logger.info("MyApplicationPreparedEventListener");
    }
}
