package com.yay.spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2016/12/28 14:32
 */
@Configuration
@ComponentScan("com.yay.spring.aop")
@EnableAspectJAutoProxy
public class AopConfig {

}
