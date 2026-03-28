package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojos.User;

public class Excelreader {
	
	public static Iterator<Object[]> excelFileReader(String fileName) {

	    List<Object[]> data = new ArrayList<>();

	    File file = new File(System.getProperty("user.dir") + "/testData/" + fileName);

	    try (XSSFWorkbook workbook = new XSSFWorkbook(file)) {

	        XSSFSheet sheet = workbook.getSheet("Sheet1");

	        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	            Row row = sheet.getRow(i);

	            User user = new User(
	                row.getCell(0).getStringCellValue(),
	                row.getCell(1).getStringCellValue()
	            );

	            data.add(new Object[]{ user });
	        }
	    } catch (IOException | InvalidFormatException e) {
	        throw new RuntimeException(e);
	    }

	    return data.iterator();
	}


}
