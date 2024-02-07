package com.aop.aopdemo.config;

public class AccessDeniedException extends RuntimeException {

	public AccessDeniedException(String Message){
		super(Message);
	}
}
