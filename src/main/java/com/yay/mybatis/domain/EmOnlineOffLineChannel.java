package com.yay.mybatis.domain;

public enum EmOnlineOffLineChannel {

	X("00","不区分"),offline("11", "线下"), online("10", "线上");

	private String code;
	private String desc;

	private EmOnlineOffLineChannel(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
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
}
