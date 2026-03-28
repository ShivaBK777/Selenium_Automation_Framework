package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojos.Config;
import com.ui.pojos.Environment;

public class JSONUitlity {

	public static String readJSON(Env env) {
		Gson gsonobj=new Gson();
		File fileobj=new File(System.getProperty("user.dir")+"\\config\\config.json");
		
		FileReader filereaderobj = null;
		try {
			 filereaderobj=new FileReader(fileobj);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		Config configgg=gsonobj.fromJson(filereaderobj, Config.class);
		Environment env1=configgg.getEnvironments().get("QA");
	
		return env1.getUrl();

	}

}
