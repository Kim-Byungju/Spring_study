package study;


public class LgTV implements TV {
	
	private BcomMonitor monitor;
	private SonySpeaker speaker;
	private int price;
	
	public LgTV() {
		System.out.println("기본생성자");
	}
	
	public LgTV(SonySpeaker speaker, int price) {
		this.speaker =speaker;
		this.price=price;
	}
	public LgTV(BcomMonitor monitor) {
		System.out.println("엘쥐TV에 B회사 모니터달기");
		this.monitor=monitor;
		
	}
	public void setMonitor(BcomMonitor monitor) {
		this.monitor = monitor;
	}
	
	@Override
	public void powerOn() {
		monitor.powerOn();
		System.out.println("가격은"+price);
		
	}
	@Override
	public void powerOff() {
		monitor.powerOff();
		
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
