package com.yay.bean;

import com.yay.bean.bean.Test1;
import com.yay.bean.bean.Test2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/11/6 10:56
 */
@Configuration
@ComponentScan
//@PropertySource("classpath:application.yml")
@PropertySource(value = "classpath:ee.properties",encoding = "UTF-8")
public class PropertiesConfig {

    @Value("${user.id}")
    private Integer id;

    @Value("${com.yay.name}")
    private String yayName;
    @Value("${com.cc.name}")
    private String ccName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYayName() {
        return yayName;
    }

    public void setYayName(String yayName) {
        this.yayName = yayName;
    }

    public String getCcName() {
        return ccName;
    }

    public void setCcName(String ccName) {
        this.ccName = ccName;
    }

    @Bean("bean1")
    public Test1 bean1() {

        System.out.println("设置bean1..................");
        Test1 test1 = new Test1();
        test1.setName("T1");
        return test1;

    }

    @Bean("bean2")
    public Test2 bean2() {

        Test1 test1 = bean1();
        System.out.println(test1.getName());

        System.out.println("设置bean2");
        Test2 test2 = new Test2();
        test2.setName("T2");
        return test2;

    }


    @Bean("bean3")
    public Test2 bean3() {

        Test1 test1 = bean1();
        System.out.println(test1.getName());

        System.out.println("设置bean3");
        Test2 test2 = new Test2();
        test2.setName("T3");
        return test2;

    }






}
