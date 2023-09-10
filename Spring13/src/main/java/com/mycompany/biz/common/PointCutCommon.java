package com.mycompany.biz.common;

import org.aspectj.lang.annotation.Pointcut;

public class PointCutCommon {
	
	@Pointcut("execution(* com.mycompany.biz..*impl.*(..))")
	public void allPointCut() {}  //id
	
	@Pointcut("execution(* com.mycompany.biz..*impl.get*(..))")
	public void getPointCut() {}  //id
}
