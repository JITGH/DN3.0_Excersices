package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	 @Around("execution(* com.library.service.*.*(..))")
	    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
	        long startTime = System.currentTimeMillis();
	        System.out.println(joinPoint.getSignature() + " starts at " + startTime + "ms");
	        Object proceed = joinPoint.proceed();
	        long endTime = System.currentTimeMillis();
	        System.out.println(joinPoint.getSignature() + " ends at " + endTime + "ms");
	        long executionTime = endTime - startTime;

	        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
	        return proceed;
}
}
