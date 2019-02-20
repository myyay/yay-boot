package com.yay.spring.el;

import org.springframework.stereotype.Component;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/1/12 17:26
 */
@Component
public class MyCheck {

    public String check(MyRequest request) {
        System.out.println(request.getName());
        System.out.println("check end!");
        return "check success";
    }
}
