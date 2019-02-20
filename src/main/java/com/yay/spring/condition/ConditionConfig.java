package com.yay.spring.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/11/9 13:54
 */
@Configuration
public class ConditionConfig {

    @Bean
    @Conditional(LinuxCondition.class)
    public LinuxListService linuxListService() {
        return new LinuxListService();
    }


    @Bean
    @Conditional(WindowsCondition.class)
    public WindowsListService windowsListService() {
        return new WindowsListService();

    }


}
