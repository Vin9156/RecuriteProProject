package com.jbk.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginTimeAspect {
//	@Before("execution(* com.jbk.controller.*.*(..)")
//	public void StartTime() {
//		System.out.println("Start time="+LocalDateTime.now());
//		
//	}
//	@After("execution(* com.jbk.controller.*.*(..)")
//	public void EndTime() {
//		System.out.println("End Time ="+LocalDateTime.now());
//		
//	}
	
	Logger logger = LoggerFactory.getLogger(LoginTimeAspect.class);
	
	@Around("execution(* com.jbk.controller.*.*(..))")
	public Object trackExecution(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long StartTime = System.currentTimeMillis();
		Object obj=joinPoint.proceed();
		long EndTime=System.currentTimeMillis();
		
		System.out.println("manually"+(EndTime-StartTime));
		
		
		logger.info("Execution Time="+(EndTime-StartTime));
		return obj;
	}
	
	
}
