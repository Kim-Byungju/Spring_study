package com.mycompamy.biz.injection;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("lgTV")
public class LgTV implements TV {
	
	//@Resource(name="sony") //오토와이어,퀄리파이어 어노테이션 한번에 처리
	@Autowired
	private SpeakerInter speaker;
	private int price;
	
	public LgTV() {
		System.out.println("기본생성자");
	}
	
	public void setSpeaker(SpeakerInter speaker) {
		this.speaker = speaker;
	}
	
	@Override
	public void powerOn() {
		System.out.println("엘지TV를 켠다.");
		System.out.println("가격은"+price);
		
	}
	@Override
	public void powerOff() {
		System.out.println("엘지TV를 끈다");
		
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
