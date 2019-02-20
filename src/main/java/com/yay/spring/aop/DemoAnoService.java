package com.yay.spring.aop;

import org.springframework.stereotype.Service;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2016/12/28 14:23
 */
@Service
public class DemoAnoService {

    @Action("拦截add")
    public void add(MyParam u) {
        System.out.println("add u:" + u);
    }

}
