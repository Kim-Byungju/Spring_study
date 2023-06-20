package study;

public class LgTV implements TV {
	
	@Override
	public void powerOn() {
		System.out.println("엘지TV를 켠다.");
		
	}
	@Override
	public void powerOff() {
		System.out.println("엘지TV를 끈다");
		
	}
	@Override
	public void volumeUp() {
		System.out.println("엘지TV의 소리를 올린다");
		
	}
	@Override
	public void volumeDown() {
		System.out.println("엘지TV의 소리를 줄인다");
		
	}
}
