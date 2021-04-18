package com.shahzad.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends Exception {

	private static final long serialVersionUID = -282913843145658333L;

	private int code;

	private HttpStatus httpStatus;

	private Object responseObject;

	public BadRequestException(String exceptionMessage) {
		super(exceptionMessage);
	}

	public BadRequestException(String exceptionMessage, HttpStatus httpStatus) {
		super(exceptionMessage);
		this.code = httpStatus.value();
		this.httpStatus = httpStatus;
	}

	public BadRequestException(String exceptionMessage, Object responseObject, HttpStatus httpStatus) {
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

	public Object getResponseObject() {
		return responseObject;
	}

}
