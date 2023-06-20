package study;

public class SamsungTV implements TV {
	
	@Override
	public void powerOn() {
		System.out.println("삼성tv로전원을켠다");
	}
	@Override
	public void powerOff() {
		System.out.println("삼성tv로 전원을 끈다");
	}
	@Override
	public void volumeUp() {
		System.out.println("삼성tv로 소리를 올린다.");
	}
	@Override
	public void volumeDown() {
		System.out.println("삼성tv로 소리를 줄인다.");
	}
	
}
