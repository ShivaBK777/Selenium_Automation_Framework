package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojos.User;

public class ExcelFileReaderUtility {
	
public static Iterator<Row> ExcelReader(String filename) {
	
	File fileobj=new File(System.getProperty("user.dir")+"\\testData"+"\\"+filename);
	
	XSSFWorkbook xssfwkbk = null;
	try {
		 xssfwkbk=new XSSFWorkbook(fileobj);
	} catch (InvalidFormatException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	List<User> userlist=new ArrayList<User>();
	
	XSSFSheet sheet=xssfwkbk.getSheet("Sheet1");
	Iterator<Row> rowiterator=sheet.iterator();
	rowiterator.next(); //this reads first Row that is header which we dont want to pass to testdata
	
	
	while(rowiterator.hasNext()) {
		Row rowdata=rowiterator.next();
		
		Cell firstCell=rowdata.getCell(0);
		Cell secondCell=rowdata.getCell(1);
		User user=new User(firstCell.toString(),secondCell.toString());
		userlist.add(user);
		
		System.out.println(firstCell.toString());
		
	}
	
	return rowiterator;
	
	
	
	
}
}
