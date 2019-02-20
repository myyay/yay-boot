package com.yay.spring.aop;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/2/13 14:31
 */
public class MyParam {
    private String pin;
    private String accNo;

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    @Override
    public String toString() {
        return "MyParam{" +
                "pin='" + pin + '\'' +
                ", accNo='" + accNo + '\'' +
                '}';
    }
}
