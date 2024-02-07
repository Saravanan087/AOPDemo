package com.aop.aopdemo.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Component
@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler(value=AccessDeniedException.class)
	public ResponseEntity<?> myexceptions(AccessDeniedException ex){
		
		
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.UNAUTHORIZED);
		
		
	}
}
