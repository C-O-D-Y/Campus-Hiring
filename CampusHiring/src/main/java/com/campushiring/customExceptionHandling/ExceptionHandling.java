package com.campushiring.customExceptionHandling;

import org.springframework.http.HttpStatus;

public class ExceptionHandling extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2620903765802743995L;
	private static HttpStatus httpCode;

	public static HttpStatus getHttpCode() {

		return httpCode;
	}

	public static void setHttpCode(HttpStatus httpCode) {
		
		ExceptionHandling.httpCode = httpCode;
	}

	public ExceptionHandling(String message) {
		
		super(message);

	}
}
