package com.yay.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 描述: 配置
 * @author yangyang26
 * @version 1.0
 * @since 2016/12/26 18:30
 */
@Component
public class MyProperties {

    @Value("${com.cc.name}")
    private String name;
    @Value("${com.cc.title}")
    private String title;
    @Value("${spring.http.encoding.charset}")
    private String charset;


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }
}
