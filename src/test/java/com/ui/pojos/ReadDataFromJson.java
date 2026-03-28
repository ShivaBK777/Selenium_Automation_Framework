package com.ui.pojos;

import java.io.File;

import tools.jackson.databind.ObjectMapper;

public class ReadDataFromJson {

	public static void main(String[] args) {
		// Read from JSON
		
		ObjectMapper mapper=new ObjectMapper();
		File file = new File(System.getProperty("user.dir"), "testData/loginData.json");
		
	TestData	data=mapper.readValue(file,TestData.class); // Jackson Converts JSON to TestData java Object
		
    for( User u:data.getData() ) {
    	System.out.println(u.getEmail());
    	System.out.println(u.getPassword());
    }
	}

}
