package com.mycompany.biz.injection;

import java.util.Map;

public class CollectionBean3 {
	
	private Map<String, String> addressList;
	
	public void setAddress(Map<String, String> addressList) {
		this.addressList = addressList;
	}
	public Map<String,String> getAddress(){
		return addressList;
	}
}
