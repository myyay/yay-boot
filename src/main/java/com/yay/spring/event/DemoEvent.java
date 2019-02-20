package com.yay.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2016/12/28 15:03
 */
public class DemoEvent extends ApplicationEvent {

    private String msg;

    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
