package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyser implements IRetryAnalyzer {

	private static final int MAX_ATTEMPTS=3;
	private static int current_attempt=1;
	
	
	@Override
	public boolean retry(ITestResult result) {
      if(current_attempt<=MAX_ATTEMPTS) {
    	  current_attempt++;
    	  return true;  // will run 3 times before marking test as failed
      }

		return false;
	}

}
