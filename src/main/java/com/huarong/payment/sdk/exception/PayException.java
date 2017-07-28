package com.huarong.payment.sdk.exception;

import com.huarong.payment.sdk.enums.ResponseEnum;

public class PayException extends Exception{
	private static final long serialVersionUID = 3784706653367587782L;

	private String code;
	
	private String message;

	public PayException(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public PayException(ResponseEnum responseEnum) {
		super();
		this.code = responseEnum.getRespCode();
		this.message = responseEnum.getRespMsg();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "PayException [code=" + code + ", message=" + message + "]";
	}
	
}
