package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReportsUtility;
import com.utility.loggerUtility;

public class testListner implements ITestListener{

	Logger logger=loggerUtility.getLogger(this.getClass());
	
	ExtentSparkReporter extentsparkreporterobj;  // create HTML reports
	ExtentReports extentReports;                 // to feed data to html
	ExtentTest extentTest;                       // store info abt test
	
	public void onStart(ITestContext context) {
	    logger.info("Test suite started");
	    extentsparkreporterobj=new ExtentSparkReporter(System.getProperty("user.dir")+"//Extentreport.html");
	    extentReports=new ExtentReports();
	    extentReports.attachReporter(extentsparkreporterobj);
	  }
	 public void onTestStart(ITestResult result) {
		    logger.info(result.getMethod().getMethodName());
		    logger.info(result.getMethod().getDescription());
		    logger.info(Arrays.toString(result.getMethod().getGroups())); //since groups store data in arrays format
		    extentTest=extentReports.createTest(result.getMethod().getMethodName());
		    
		   // ideal right way to use extentreports
		    //create separet utility class
		    // then add this below line 
		   // ExtentReportsUtility.setupSparkReporter("newextentreport.html");
		    // ExtentReportsUtility.createExtentTest(result.getMethod().getMethodName());
		    
		    
		    }
	 public void onTestSuccess(ITestResult result) {
		  logger.info(result.getMethod().getMethodName()+" "+"this method got passed");
		  extentTest.log(Status.PASS,result.getMethod().getMethodName()+" "+"this method got passed");
		  
		  //using utility
		  // ExtentReportsUtility.getTest().log(Status.PASS,result.getMethod().getMethodName()+" "+"this method got passed");
		  }
	 public void onTestFailure(ITestResult result) {
		 logger.info(result.getMethod().getMethodName()+" "+"this method got failed");
		 extentTest.log(Status.FAIL,result.getMethod().getMethodName()+" "+"this method got failed");
		 
		 Object testclass=result.getInstance();  // returns instance of current test 
		BrowserUtility  bref=  ((TestBase)testclass).getInstancee(); // type (up)casting testclass to access takescreenshot method from parent class
		  bref.takescreenshot();
		 
		 
		  }
	 public void onTestSkipped(ITestResult result) {
		 logger.info(result.getMethod().getMethodName()+" "+"this method got skipped");
		  }
	 
	 public void onFinish(ITestContext context) {
		    logger.info("Test suite completed");
		    extentReports.flush();
		    // using utility below, above line is normal usage without utility
		   //ExtentReportsUtility.flushReport();
		  }
}
