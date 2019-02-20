package com.yay.spring.config;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2016/12/28 13:52
 */
public class UseFuncService {

    private FuncService funcService;

    public String sayHello(String name) {
        return funcService.sayHello(name);
    }
}
