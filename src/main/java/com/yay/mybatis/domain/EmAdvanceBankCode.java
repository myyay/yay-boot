package com.yay.mybatis.domain;

public enum EmAdvanceBankCode {

    X("00", "不区分"),
    CMBC("10", "民生银行"),
    CIB("11", "兴业银行"),
    CEB("13", "光大银行"),
    PAB("14", "平安银行"),
    ;

    private String desc;

    private String code;

    private EmAdvanceBankCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static EmAdvanceBankCode getByCode(String code) {
        for (EmAdvanceBankCode emAdvanceBankCode : EmAdvanceBankCode.values()) {
            if (emAdvanceBankCode.getCode().equals(code))
                return emAdvanceBankCode;
        }
        return null;
    }

    public static EmAdvanceBankCode getByBusiCode(String busiCode) {
        if (null == busiCode || busiCode.length() < 6) {
            return null;
        }
        return getByCode(busiCode.substring(2, 4));

    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmName() {
        return name();
    }

}
