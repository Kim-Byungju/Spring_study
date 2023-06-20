package study;


public class LgTV implements TV {
	
	private SpeakerInter speaker;
	private int price;
	
	public LgTV() {
		System.out.println("기본생성자");
	}
	
	/*
	 * public LgTV(SpeakerInter speaker, int price) { this.speaker =speaker;
	 * this.price=price; }
	 */
	
	public void setSpeaker(SpeakerInter speaker) {
		this.speaker = speaker;
	}
	
	@Override
	public void powerOn() {
		System.out.println("엘지TV를 켠다.");
		System.out.println("가격은"+price);
		
	}
	@Override
	public void powerOff() {
		System.out.println("엘지TV를 끈다");
		
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
