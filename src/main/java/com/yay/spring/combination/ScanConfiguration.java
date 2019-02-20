package com.yay.spring.combination;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/11/9 14:43
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
@ComponentScan
public @interface ScanConfiguration {

    String[] value() default {};


}
