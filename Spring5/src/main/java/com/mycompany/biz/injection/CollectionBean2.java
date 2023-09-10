package com.mycompany.biz.injection;

import java.util.Set;

public class CollectionBean2 {
	
	private Set<String> addressList;
	
	public void setAddress(Set<String> addressList) {
		this.addressList=addressList;
	}
	
	public Set<String> getAddress(){
		return addressList;
	}
	
}
