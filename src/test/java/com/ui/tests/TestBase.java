package com.ui.tests;

import static com.constants.Browser.EDGE;

import org.testng.annotations.BeforeMethod;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;

public class TestBase {
	
	HomePage homepage; 
	@BeforeMethod(description = "Load homepage")
	public void setup(){
		 homepage=new HomePage(EDGE,true); // direct calling of edge coz of static
		
	}
	
	public BrowserUtility getInstancee() {   // returning child obj that is homepage but return type is of Parent that is browserutilty
		return homepage;  
	}
}
