package study;

public class AppleSpeaker {
	
	private AppleSpeaker speaker;
	
	public AppleSpeaker() {
		System.out.println("애플스피커객체생성");
	}
	public void volumeUp() {
		System.out.println("애플스피커 볼륨을 높인다.");
	}
	public void volumeDown() {
		System.out.println("애플스피커 볼륨을 낮춘다.");
	}
}
