package com.campushiring.customExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler(ExceptionHandling.class)

	public ResponseEntity<Object> customMessage(ExceptionHandling eh) {
		return new ResponseEntity<>(eh.getMessage(), HttpStatus.BAD_REQUEST);

	}

}
