package com.library.aspect;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class LoggingAspect {
	 private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	 	//adding the @before advice fired on all the methods of the Services
	    @Before("execution(* com.library.service.*.*(..))")
	    public void logBefore() {
	    	System.out.println("before");
	        logger.info("Method execution started");
	        
	    }

	    @After("execution(* com.library.service.*.*(..))")
	    public void logAfter() {
	    	 System.out.println("After");
	        logger.info("Method execution finished");
	       
	    }

}
