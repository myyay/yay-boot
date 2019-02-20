package com.yay.spring.el;

import org.springframework.stereotype.Component;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/1/12 17:20
 */
@Component
public class MyProcess {
    @CheckBefore(cProcess = {"myCheck.check(#request)"})
    public String process(MyRequest request) {
        return request.getName();
    }

}
