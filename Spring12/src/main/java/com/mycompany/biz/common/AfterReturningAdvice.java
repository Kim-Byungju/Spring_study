package com.mycompany.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.mycompany.biz.user.UserVO;

@Service
@Aspect
public class AfterReturningAdvice {
	
	@Pointcut("execution(* com.mycompany.biz..*impl.get*(..))")
	public void getPointCut() {}
	
	@AfterReturning(pointcut="PointcutCommon.getPointCut()",returning = "returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO)returnObj;
			
			if(user.getRole().equals("부하")) {
				System.out.println(user.getName()+" 로그인(test)");
			}
		}
		System.out.println("[사후처리]"+method+"()메소드 리턴값 : "+returnObj.toString());
	}
}
