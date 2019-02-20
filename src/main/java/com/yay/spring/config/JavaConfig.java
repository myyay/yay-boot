package com.yay.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2016/12/28 13:54
 */
@Configuration
public class JavaConfig {

    @Bean
    public FuncService funcService() {
        return new FuncService();
    }


    /*@Bean
    public UseFuncService useFuncService() {
        UseFuncService useFuncService = new UseFuncService();
        Field funcService = ReflectionUtils.findField(useFuncService.getClass(), "funcService");
        if (null != funcService) {
            ReflectionUtils.makeAccessible(funcService);
            ReflectionUtils.setField(funcService, useFuncService, funcService());
        }
        return useFuncService;
    }*/


    @Bean
    public UseFuncService useFuncService(FuncService funcService) {
        UseFuncService useFuncService = new UseFuncService();
        Field field = ReflectionUtils.findField(useFuncService.getClass(), "funcService");
        if (null != field) {
            ReflectionUtils.makeAccessible(field);
            ReflectionUtils.setField(field, useFuncService, funcService);
        }
        return useFuncService;
    }

}
