package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.constants.Env;
import com.utility.BrowserUtility;
import com.utility.PropertiesUtil;
  
public final class HomePage extends BrowserUtility {
	public HomePage(Browser browsername,boolean isHeadLessMode) {
		super(browsername,isHeadLessMode); 
		// if parent class has constructor it is job of child constructor to call
		goToWebSite(PropertiesUtil.readProperty(Env.QA,"URL"));  //using properties class
		maximizeWindow();
		//gotToWebSite(JSONUtility.readJSON(QA)); // using Gson Library
		//JSON way of reading url
	}

	private static final By SignInLinkLocator=By.xpath("//a[@href='/login']");
	
	public LoginPage goToSigninPage() {   // page functions cannot have void 
		click(SignInLinkLocator);
		LoginPage loginpage=new LoginPage(getDriver()); // to get same driver session
		return loginpage;
	}
	
	
	
}
