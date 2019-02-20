package com.yay.spring.async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/11/8 18:50
 */
public class ExceptionHandler implements AsyncUncaughtExceptionHandler {
    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        System.out.println("发现异常");
        System.out.println(ex.toString());
        System.out.println(method.getName());
        System.out.println(Arrays.toString(params));
    }
}
