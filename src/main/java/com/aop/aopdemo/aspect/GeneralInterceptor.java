package com.aop.aopdemo.aspect;

import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.aop.aopdemo.config.AccessDeniedException;
import com.aop.aopdemo.utils.User;

@Aspect
@Component
public class GeneralInterceptor {

	
	@Pointcut("execution(* com.aop.aopdemo.controller.*.*(..))")
	public void loggin() {
		
	}
	
	  @Before("loggin()") 
	  public void beforeloggedin(JoinPoint jp) {
		 
		  HttpServletRequest req=(HttpServletRequest) jp.getArgs()[1];
		  
		  req.getHeader("Authorization");
		  
		  System.out.println("Before Calling ================"+req.getRequestURI());
		  
		  if(req.getRequestURI().contains("/welcome") && req.getHeader("Authorization").isEmpty()) {
			  throw new AccessDeniedException("Un Autherized request");
		  }
	  
	  }
	  
	  
	 
	 @After("loggin()") public void Afterloggedin(JoinPoint jp) {
	  System.out.println("After Calling ================"+jp.getSignature());
	  }
	 
	
	@AfterReturning(value="execution(* com.aop.aopdemo.controller.*.*(..))", returning = "userList")
	public void Afterreturn(ResponseEntity<?> userList) {
		
		List<User> usr=(List<User>) userList.getBody();
		
		usr.stream().filter(n->n.getName().equalsIgnoreCase("saran")).collect(Collectors.toList())
		.forEach(u->{
			System.out.println(""+u.getAge()+"--"+u.getSalary()+"-"+u.getName());
		});
	}
	
	
	@AfterThrowing(value="execution(* com.aop.aopdemo.controller.*.*(..))", throwing = "error")
	public void Afterthrow(Exception error) {
		
		System.out.println("Error Calling ================"+error.getMessage());
	}
	
	
}
