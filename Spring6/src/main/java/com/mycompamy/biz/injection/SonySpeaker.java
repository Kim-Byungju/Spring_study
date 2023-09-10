package com.mycompamy.biz.injection;

import org.springframework.stereotype.Component;


public class SonySpeaker implements SpeakerInter{
	
	public SonySpeaker() {
		
	}
	@Override
	public void volumeUp() {
		System.out.println("소니스피커의 볼륨을 올린다.");
	}
	@Override
	public void volumeDown() {
		System.out.println("소니스피커의 볼륨을 내린다.");
	}
	
}
