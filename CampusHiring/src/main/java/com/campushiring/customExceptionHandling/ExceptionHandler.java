package com.campushiring.customExceptionHandling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

	

	@org.springframework.web.bind.annotation.ExceptionHandler(ExceptionHandling.class)
	public ResponseEntity<Object> customMessage() {
		
		

		return new ResponseEntity<>(ExceptionHandling.getHttpCode());
	}
}
