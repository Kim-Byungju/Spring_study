package study;

public class SamsungTV implements TV {
	
	private AcomMonitor monitor;
	private AppleSpeaker speaker;
	private int price;
	
	public SamsungTV() {}
	
	public SamsungTV(AppleSpeaker speaker, int price) {
		System.out.println("삼성TV에 의존객체주입");
		this.speaker=speaker;
		this.price=price;
	}
	
	public SamsungTV(AcomMonitor monitor, int price) {
		this.monitor=monitor;
		this.price=price;
		System.out.println("삼성TV에 A회사 모니터달기");
	}
	
	  public void setMonitor(AcomMonitor monitor) { 
		  this.monitor = monitor; 
		  }
	 
	  public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public void powerOn() {
		monitor.powerOn();
		System.out.println("가격은 "+price);
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
