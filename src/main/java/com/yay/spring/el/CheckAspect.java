package com.yay.spring.el;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 描述: XXX
 * @author yangyang26
 * @since 2017/1/12 17:09
 * @version 1.0
 */
@Aspect
@Component
public class CheckAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("@annotation(com.yay.spring.el.CheckBefore)")
    private void checkMethod() {
    }

    @After("checkMethod()")
    public void after(JoinPoint jp) throws Throwable {
        logger.info("==========================after=======================");
        logger.info(jp.getKind());
        logger.info(Arrays.toString(jp.getArgs()));
        logger.info(jp.getSignature().toLongString());
        logger.info(jp.getThis().getClass().getName());
        logger.info(jp.getTarget().getClass().getName());

    }


    @Around("checkMethod()")
    public Object process(ProceedingJoinPoint pjp) throws Throwable {

        MethodSignature signature = (MethodSignature) pjp.getSignature();
        System.out.println(Arrays.toString(signature.getParameterNames()));
        CheckBefore annotation = signature.getMethod().getAnnotation(CheckBefore.class);
        System.out.println(Arrays.toString(annotation.cProcess()));


        return pjp.proceed();

    }
}
