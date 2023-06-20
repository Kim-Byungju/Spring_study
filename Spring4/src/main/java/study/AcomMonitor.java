package study;

public class AcomMonitor implements Monitor {
	
	private AcomMonitor monitor;
	
	public AcomMonitor() {
		System.out.println("A회사 모니터 객체생성");
	}

	@Override
	public void powerOn() {
		System.out.println("A회사의 모니터전원을 켭니다.");
		
	}

	@Override
	public void powerOff() {
		System.out.println("A회사의 모니터전원을 끕니다.");
		
	}
	
}
