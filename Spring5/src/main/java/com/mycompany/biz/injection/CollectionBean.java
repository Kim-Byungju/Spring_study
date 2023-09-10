package com.mycompany.biz.injection;

import java.util.List;

public class CollectionBean {
	
	private List<String> addressList;
	
	public void setAddress(List<String> addressList) {
		this.addressList=addressList;
	}
	
	public List<String> getAddress(){
		return addressList;
	}
}
