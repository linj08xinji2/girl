package com.demo.utils;

public enum ResultEnum {

	 UNKOWN_ERROR(-1,"未知异常"),
	 SUCCESS(0,"success"),
	 PRIMARY_SCHOOL(100,"上小学"),
	 MIDDLE_SCHOOL(101,"上初中")
	;
	private Integer code;
	
	private String message;

	private ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
}
