package org.javacream.util.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.javacream.util.metric.RequestCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CountRequestAspect {
	@Autowired RequestCounter requestCounter; 
	@Around("@annotation(org.javacream.util.aspect.CountRequest)")
	public Object trace(ProceedingJoinPoint pjp) throws Throwable {
		requestCounter.increment();
		return pjp.proceed();
	}
}
