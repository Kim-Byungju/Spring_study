package study;

public class SamsungTV implements TV {
	
	private SpeakerInter speaker;
	
	private int price;
	
	public SamsungTV() {}
	
	
	public SamsungTV(SpeakerInter speaker, int price) {
		 System.out.println("삼성TV에 의존객체주입"); 
		 this.speaker=speaker; 
		 this.price=price; 
	 }
	 
	
	public void setSpeaker(SpeakerInter speaker) {
		this.speaker = speaker;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public void powerOn() {
		System.out.println("삼성tv로전원을켠다");
		System.out.println("가격은 "+price);
	}
	@Override
	public void powerOff() {
		System.out.println("삼성tv로 전원을 끈다");
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
