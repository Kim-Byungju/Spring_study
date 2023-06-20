package study;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {

	//BeanFactory factory = new BeanFactory();
	
	//Spring 컨테이너를 구동시킨다.  - applicationContext.xml을 읽어서 factory를 만든다.
	AbstractApplicationContext factory 
		= new GenericXmlApplicationContext("applicationContext.xml");
	
	TV tv = (TV)factory.getBean("samsung");
	
	tv.powerOn();
	tv.volumeUp();
	tv.volumeDown();
	tv.powerOff();
	 
	}

}
