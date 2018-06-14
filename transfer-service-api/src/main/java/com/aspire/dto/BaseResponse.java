package com.aspire.dto;

/**
 * This class is abstract response class. Default response attributes like
 * statusCode and messages will be enclosed in this object. This class will be
 * extend if response are of different type.
 * 
 * @author faizal.arafath
 *
 */
public class BaseResponse {

	private int statusCode;
	private String message;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
