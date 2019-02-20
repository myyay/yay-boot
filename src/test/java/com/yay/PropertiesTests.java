package com.yay;

import com.yay.bean.MyProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;

/**
 * 描述: 测试属性注入
 * @author yangyang26
 * @version 1.0
 * @since 2016/12/26 18:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PropertiesTests {

    @Autowired
    private MyProperties myProperties;


    @Test
    public void test() throws Exception {

        String name = myProperties.getName();

        System.out.println(name);
        try {
            System.out.println(new String(name.getBytes("GBK"), "UTF-8"));
            System.out.println(new String(name.getBytes("UTF-8"), "GBK"));
            System.out.println(new String(name.getBytes(), "GBK"));
            System.out.println(new String(name.getBytes("ISO-8859-1"), "UTF-8"));
            System.out.println(new String(name.getBytes("ISO-8859-1"), "GBK"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(myProperties.getName(), "乐破晓");
        Assert.assertEquals(myProperties.getTitle(), "题目");

        System.out.println(myProperties.getClass().getName());

    }
}
