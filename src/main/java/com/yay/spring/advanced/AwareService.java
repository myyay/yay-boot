package com.yay.spring.advanced;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.MessageSource;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/11/8 18:14
 */
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {


    private String beanName;

    private ResourceLoader resourceLoader;

    private MessageSource messageSource;

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;

    }


    public void outputResult() {

        System.out.println("Bean的名称为:" + beanName);
        Resource resource = resourceLoader.getResource("classpath:ee.properties");

        Properties properties = new Properties();
        try {
            properties.load(new InputStreamReader(resource.getInputStream(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(properties.stringPropertyNames());


    }

}
