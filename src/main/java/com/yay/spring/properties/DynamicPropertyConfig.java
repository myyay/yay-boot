package com.yay.spring.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.AbstractEnvironment;

import javax.annotation.PostConstruct;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/11/17 13:45
 */
@Configuration
@ComponentScan
public class DynamicPropertyConfig {


    public static final String DYNAMIC_CONFIG_NAME = "dynamic_config";
    private final AbstractEnvironment environment;


    @Autowired
    public DynamicPropertyConfig(AbstractEnvironment environment) {
        this.environment = environment;
    }


    @PostConstruct
    public void init() {
        environment.getPropertySources().addFirst(new DynamicPropertySource(DYNAMIC_CONFIG_NAME));
    }

}
