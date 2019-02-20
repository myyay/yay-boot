package com.yay.mybatis.domain;

/***
 * 垫资收款方
 * @author lidong5
 */
public enum EmAdvancePayeeCode {
	
	X("00","不区分"),CMBC("10", "民生银行"), CIB("11", "兴业银行"),JD("12","京东"),CEB("13","光大银行"),PAB("14", "平安银行");
	
	
	private EmAdvancePayeeCode(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	private String code;
	
	private String desc;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	public static EmAdvancePayeeCode getByCode(String code) {
		for (EmAdvancePayeeCode emAdvanceBankCode : EmAdvancePayeeCode.values()) {
			if (emAdvanceBankCode.getCode().equals(code))
				return emAdvanceBankCode;
		}
		return null;
	}
}
