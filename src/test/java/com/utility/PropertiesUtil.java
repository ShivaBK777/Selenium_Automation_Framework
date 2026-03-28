package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;


public class PropertiesUtil {

	public static String readProperty(Env env,String property) {
		// read from config.properties
		
		
		File obj=new File(System.getProperty("user.dir")+"\\config\\QA.properties");
		
		FileReader filereadobj = null;
		
		try {
			 filereadobj=new FileReader(obj);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		Properties propobj=new Properties();
		try {
			propobj.load(filereadobj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String value=propobj.getProperty(property.toUpperCase());
	    return value;

	}

}
