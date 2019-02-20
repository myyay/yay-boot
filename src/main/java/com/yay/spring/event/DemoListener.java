package com.yay.spring.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2016/12/28 15:13
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onApplicationEvent(DemoEvent event) {
        String msg = event.getMsg();
        System.out.println(event.getSource().getClass().getName() + " 发来消息:" + msg);
        logger.info(event.getSource().getClass().getName() + " 发来消息:" + msg);
    }
}
