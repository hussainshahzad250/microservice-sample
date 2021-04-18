
package com.shahzad.exception;

import org.springframework.http.HttpStatus;

public class ObjectNotFoundException extends Exception {

	private static final long serialVersionUID = 460396670844622215L;

	private int code;

	private HttpStatus httpStatus;

	private Object responseObject;

	public ObjectNotFoundException(String exceptionMessage) {
		super(exceptionMessage);
	}

	public ObjectNotFoundException(String exceptionMessage, HttpStatus httpStatus) {
		super(exceptionMessage);
		this.code = httpStatus.value();
		this.httpStatus = httpStatus;
	}

	public ObjectNotFoundException(String exceptionMessage, Object responseObject, HttpStatus httpStatus) {
		super(exceptionMessage);
		this.code = httpStatus.value();
		this.httpStatus = httpStatus;
		this.responseObject = responseObject;
	}

	public int getCode() {
		return code;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Object getResponseObject() {
		return responseObject;
	}

}
