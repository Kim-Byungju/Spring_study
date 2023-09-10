package com.mycompamy.biz.injection;

import org.springframework.stereotype.Component;


public class AppleSpeaker implements SpeakerInter {
	
	int num;
	
	public AppleSpeaker() {
	
	}
	@Override
	public void volumeUp() {
		System.out.println("애플스피커 볼륨을 높인다.");
	}
	@Override
	public void volumeDown() {
		System.out.println("애플스피커 볼륨을 낮춘다.");
	}
}
