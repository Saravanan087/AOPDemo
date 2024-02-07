package com.aop.aopdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aop.aopdemo.utils.User;

@Service
public class DemoAOPService {

	
	public List<User> getAllUsers() {
				
		System.out.println("Calling Get Users::::::::::::::::::");
		List<User> list=new ArrayList<>();
		list.add(new User("Saran",33,50000));
		list.add(new User("Shanthini",33,60000));
		list.add(new User("Sai",4,10000));
		
		return list;
	}
	
}
