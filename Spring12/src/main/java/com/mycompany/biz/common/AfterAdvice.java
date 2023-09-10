package com.mycompany.biz.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice {
	
	@Pointcut("execution(* com.mycompany.biz..*impl.*(..))")
	public void allPointCut() {}
	
	@After("allPointCut()")
	public void finallyLog() {
		System.out.println("[사후처리]-After 비즈니스 수행후 무조건 동작");
	}
}
