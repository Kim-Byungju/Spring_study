package com.mycompany.biz.injection;

import java.util.Properties;

public class CollectionBean4 {
	
	private Properties addressList;
	
	public void setAddress(Properties addressList) {
		this.addressList = addressList;
	}
	public Properties getAddress() {
		return addressList;
	}
	
}

