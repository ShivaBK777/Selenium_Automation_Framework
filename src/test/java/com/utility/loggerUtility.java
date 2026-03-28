package com.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class loggerUtility {
	
	//Singleton desing pattern
	
	private loggerUtility(){
		//cannot create object 
	}
	
	public static Logger getLogger(Class<?> clazz) {
		Logger logger=null;
		if(logger==null) {
		logger=LogManager.getLogger(clazz);
		}
		
		return logger;
	}

}
