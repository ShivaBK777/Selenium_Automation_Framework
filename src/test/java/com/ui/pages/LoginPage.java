package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class LoginPage extends BrowserUtility {

 
 static final	By emailLocator = By.xpath("//input[@name='email' and @data-qa='login-email']");
 static final By PasswordLocator = By.xpath("//input[@type='password' and @data-qa='login-password']");
 static final By LoginbuttonLocator=By.xpath("//button[@type='submit' and @data-qa='login-button']");

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	public Myaccount doLoginwith(String email, String abc) {  // Page shoul not have void -->it shld return 
     enterText(emailLocator,email);
     enterText(PasswordLocator, abc);
     click(LoginbuttonLocator);
     Myaccount myacc=new Myaccount(getDriver());
     return myacc;
     
	}

}
