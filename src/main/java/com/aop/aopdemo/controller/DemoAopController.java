package com.aop.aopdemo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aop.aopdemo.service.DemoAOPService;
import com.aop.aopdemo.utils.User;

@RestController
public class DemoAopController {

	@Autowired
	DemoAOPService service;
	
	@GetMapping("/welcome/{id}")
	public ResponseEntity<?> Welcome(@PathVariable("id") String Id,HttpServletRequest  req) throws Exception {
		
		List<User> usr=service.getAllUsers();
		//throw new Exception("error");
		return new ResponseEntity<>(usr,HttpStatus.OK);
	}
}
