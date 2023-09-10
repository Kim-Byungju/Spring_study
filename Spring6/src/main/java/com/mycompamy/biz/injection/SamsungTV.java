package com.mycompamy.biz.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("samsungTV")
public class SamsungTV implements TV {
	
	@Autowired
	private SpeakerInter speaker;
	
	private int price;
	
	public SamsungTV() {}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public void powerOn() {
		System.out.println("삼성tv로전원을켠다");
		System.out.println("가격은 "+price);
	}
	@Override
	public void powerOff() {
		System.out.println("삼성tv로 전원을 끈다");
	}
	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}
	
}
