package study;

public class SonySpeaker{
	
	private SonySpeaker speaker;
	
	public SonySpeaker() {
		System.out.println("소니스피커 객체생성");
	}
	public void volumeUp() {
		System.out.println("소니스피커의 볼륨을 올린다.");
	}
	public void volumeDown() {
		System.out.println("소니스피커의 볼륨을 내린다.");
	}
	
}
