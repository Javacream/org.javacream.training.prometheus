package org.javacream.util.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TracingAspect {

	//@Around("execution(* org.javacream..impl.*.*(..))")
	@Around("@annotation(org.javacream.util.aspect.Trace)")
	public Object trace(ProceedingJoinPoint pjp) throws Throwable {
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		String methodName = signature.getMethod().getName();
		System.out.println("Entering " + methodName);
		try {
			Object result = pjp.proceed();
			System.out.println("returning from " + methodName);
			return result;
		} catch (Throwable t) {
			System.out.println("returning from " + methodName);
			throw t;
		}
	}
}
