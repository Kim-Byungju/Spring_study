package com.mycompany.biz.injection;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {
	
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

		System.out.println("----------List출력--------");
		CollectionBean bean = (CollectionBean)factory.getBean("collectionBean");
		//활용
		for(String address : bean.getAddress()) {
			System.out.println(address);
		}
		
		System.out.println("----------Set출력--------");
		CollectionBean2 bean2 = (CollectionBean2)factory.getBean("collectionSetBean");
		//iterator() 출력
		Iterator iter = bean2.getAddress().iterator();
		while(iter.hasNext()) {
			
			System.out.println(iter.next()+"");
		}
		
		System.out.println("---------Map출력----------");
		CollectionBean3 bean3 = (CollectionBean3)factory.getBean("collectionMapBean");
		//키 >> 값
		for(String key: bean3.getAddress().keySet()) {
			String value = (String)bean3.getAddress().get(key);
			
			System.out.println(key+":"+value);
		}
		System.out.println("--------Properties출력----------");
		CollectionBean4 bean4 = (CollectionBean4)factory.getBean("collectionPropertiesBean");
		Properties addressList = bean4.getAddress();

		System.out.println(addressList.get("고길동"));
		System.out.println(addressList.get("이은희"));

		factory.close();
	}
}
