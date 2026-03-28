package com.ui.tests;

import org.testng.annotations.Test;

import com.ui.pojos.User;

public class ReadJSONdataTest  {
// using Jackson dependency..same can be read with Gson also
	@Test(dataProvider = "JSONDataProvider",dataProviderClass = com.ui.dataproviders.LoginDataProvider.class)
	public void readJson(User user) {
		 System.out.println("Email: " + user.getEmail());
	        System.out.println("Password: " + user.getPassword());
	}
}
