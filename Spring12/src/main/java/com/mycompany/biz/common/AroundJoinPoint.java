package com.mycompany.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundJoinPoint {
	
	@Pointcut("execution(* com.mycompany.biz..*impl.*(..))")
	public void allPointCut() {}
	
	@Around("allPointCut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		
		String method = pjp.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		
		stopWatch.start();
		Object obj = pjp.proceed();
		stopWatch.stop();
		
		System.out.println(method+"()메소드수행에걸린시간 : "+stopWatch.getTotalTimeMillis()+"ms");
		return null;
	}
}
