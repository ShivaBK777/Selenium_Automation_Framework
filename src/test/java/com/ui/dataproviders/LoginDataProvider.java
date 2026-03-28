package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojos.TestData;
import com.ui.pojos.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelFileReaderUtility;
import com.utility.Excelreader;

import tools.jackson.databind.ObjectMapper;

public class LoginDataProvider {
 
	@DataProvider(name="LoginTestDataProvider")  // Using Gson to read Json...one more approach to read Json..see last 
	public Iterator<Object[]> loginDataProvider() {
		Gson gsonobj=new Gson();
		File fileobj=new File(System.getProperty("user.dir")+"\\testData\\loginData.json");
		
		FileReader filereaderobj = null;
		try {
			 filereaderobj=new FileReader(fileobj);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		TestData readdata=gsonobj.fromJson(filereaderobj,TestData.class);
		
		// upto 32 line, reads file with help of gson
		
		//from below line,retreive data 
		
		List<Object[]> dataToReturn=new ArrayList<Object[]>();
		for(User user:readdata.getData()) {
			dataToReturn.add(new Object[] {user});
		}
		
		return dataToReturn.iterator();
	}
	
	
	@DataProvider(name="LoginTestCSVDataProvider")
	public Iterator<User> loginCSVDataProvider() {
		return CSVReaderUtility.readCSV();
	}
	
/*	@DataProvider(name="LoginTestExcelDataProvider")
	public Iterator<Row> loginExcelDataProvider() {
		return ExcelFileReaderUtility.ExcelReader("loginData.xlsx");
	}
	*/
	
	@DataProvider(name = "LoginTestExcelDataProvider")
	public Iterator<Object[]> loginExcelDataProvider() {
	    return Excelreader.excelFileReader("loginData.xlsx");
	}

	@DataProvider(name="JSONDataProvider")  // Using Jackson...to read Json
	public Object[][] readJsonData() {
		ObjectMapper mapper=new ObjectMapper();
		File file=new File(System.getProperty("user.dir"), "testData/loginData.json");
		
		TestData data=mapper.readValue(file, TestData.class);
		
		int row_size=data.getData().size();
		
		Object[][] userdata = new Object[row_size][1];

        for (int i = 0; i < row_size; i++) {
        	userdata[i][0] = data.getData().get(i);
        }

        return userdata;
	}
}
