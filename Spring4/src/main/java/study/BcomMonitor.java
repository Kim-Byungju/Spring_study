package study;

public class BcomMonitor implements Monitor{

	public BcomMonitor() {
		System.out.println("B회사 모니터 객체생성");
	}
	
	@Override
	public void powerOn() {
		System.out.println("B회사 모니터 전원을 켭니다.");
		
	}

	@Override
	public void powerOff() {
		System.out.println("B회사 모니터 전원을 끕니다.");
		
	}

}
