package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsUtility {
	// created this method with ThreadLocal for Thread Safety during parallel execution
	// each test will hv their own threads,something like this...
	
	static ExtentReports extentreports;
	static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
	public static void setupSparkReporter(String reportname) {
		ExtentSparkReporter extentsparkreporter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\"+reportname);
		extentreports=new  ExtentReports();
		extentreports.attachReporter(extentsparkreporter);
	}
	
	public static void createExtentTest(String testName) {
		ExtentTest test=extentreports.createTest(testName);
		extentTest.set(test);
	}
  
	public static ExtentTest getTest()
	{
		return extentTest.get();
	}
	
	public static void flushReport() {
		extentreports.flush();
	}
}
