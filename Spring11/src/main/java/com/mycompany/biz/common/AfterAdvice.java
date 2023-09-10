package com.mycompany.biz.common;

public class AfterAdvice {
	
	public void finallyLog() {
		System.out.println("[사후처리] 비즈니스 로직수행후 동작");
	}
}
