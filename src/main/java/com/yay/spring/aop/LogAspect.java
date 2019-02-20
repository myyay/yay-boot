package com.yay.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2016/12/28 14:25
 */
@Aspect
@Component
public class LogAspect {
    @Pointcut("@annotation(com.yay.spring.aop.Action)")
    public void pointCut() {

    }


    @Before("execution(* com.yay.spring.aop.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("拦截方法名称:" + method.getName());

    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action annotation = method.getAnnotation(Action.class);
        System.out.println("拦截注解内容:" + annotation.value());

    }


    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        System.out.println("args:" + Arrays.toString(args));

        if (args != null && args.length > 0) {
            Object arg = args[0];
            Field accNo = ReflectionUtils.findField(arg.getClass(), "accNo");
            ReflectionUtils.makeAccessible(accNo);
            ReflectionUtils.setField(accNo,arg,"我的value");
        }
        return pjp.proceed();

    }


}
