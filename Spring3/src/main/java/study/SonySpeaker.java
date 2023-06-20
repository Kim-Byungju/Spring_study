package study;

public class SonySpeaker implements SpeakerInter{
	
	private SonySpeaker speaker;
	
	public SonySpeaker() {
		System.out.println("소니스피커 객체생성");
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
