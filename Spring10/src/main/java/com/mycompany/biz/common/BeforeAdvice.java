package com.mycompany.biz.common;

public class BeforeAdvice {
	
	public void beforeLog() {
		System.out.println("[사전처리]비즈니스 로직수행 전 동작");
	}
}
