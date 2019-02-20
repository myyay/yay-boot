package com.yay.spring.el;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/1/12 17:20
 */
public class MyRequest {
    private String name;
    private int age;
    private boolean good;
    private EmSex sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGood() {
        return good;
    }

    public void setGood(boolean good) {
        this.good = good;
    }

    public EmSex getSex() {
        return sex;
    }

    public void setSex(EmSex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "MyRequest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", good=" + good +
                ", sex=" + sex +
                '}';
    }
}
