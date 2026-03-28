package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojos.User;

public class CSVReaderUtility {
	
	public static Iterator<User> readCSV() {
	File Fileobj=new File(System.getProperty("user.dir")+"\\testData\\loginData.csv");
	
	FileReader csvfilereader = null;
	try {
		 csvfilereader=new FileReader(Fileobj);
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
	
	
	CSVReader csvreaderobj=new CSVReader(csvfilereader);
	String[] line = null;
	List<User> userlist = null; 
	User user;
	
	try {
		//reading csv manually
		csvreaderobj.readNext(); // Row 1..just reads row 2, doesnt store
		// data=csvreaderobj.readNext(); // Row 2..reads next row that is 2nd and stores
	//	System.out.println(Arrays.toString(data));  //prints 
		
		// reading from csv using loops
		userlist=new ArrayList<User>(); 
		                                 // declare outside try block
		while((line=csvreaderobj.readNext())!=null) {
			
			 user=new User(line[0],line[1]); // fetchin email&pass from data array where email is on 0 index and pass is on 1st index
			userlist.add(user); // users email& pass will get added to list
		}
		
		for (User userdata : userlist) {
			System.out.println(userdata);
		}
		
		
	} catch (CsvValidationException | IOException e) {
		
		e.printStackTrace();
	}
	
	
	return userlist.iterator();
	
	
	
	}
}
