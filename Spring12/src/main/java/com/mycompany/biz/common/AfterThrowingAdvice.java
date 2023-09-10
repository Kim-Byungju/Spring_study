package com.mycompany.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {

	@Pointcut("execution(* com.mycompany.biz..*impl.*(..))")
	public void allPointCut() {}
	
	@AfterThrowing(pointcut = "allPointCut()", throwing = "exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		
		String method = jp.getSignature().getName();
		System.out.println("[예외처리]"+method+"()메소드 수행중 예외메시지: "+exceptObj);
		
		if(exceptObj instanceof IllegalArgumentException) {
			System.out.println("부적합한 값이 입력되었습니다.");
			
		} else if (exceptObj instanceof NumberFormatException) {
			System.out.println("숫자형식의 값이 아닙니다.");
			
		}  else if (exceptObj instanceof Exception) {
			System.out.println("문제발생");
		}
	}
}
