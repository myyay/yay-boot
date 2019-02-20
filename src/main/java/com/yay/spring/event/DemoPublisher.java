package com.yay.spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2016/12/28 15:32
 */
@Component
public class DemoPublisher {
    final
    ApplicationContext context;


    @Autowired
    public DemoPublisher(ApplicationContext context) {
        this.context = context;
    }

    public void publish(String msg) {
        context.publishEvent(new DemoEvent(this, msg));

    }
}
