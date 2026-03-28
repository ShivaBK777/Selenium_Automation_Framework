package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class Myaccount extends BrowserUtility {

	public Myaccount(WebDriver driver) {
		super(driver);
		
	}

	private static final By UserNameLocator=By.xpath("//i[contains(@class,'fa fa-user')]/following-sibling::b");
	
	public String getUserName() {
		return getText(UserNameLocator);
	}
	
}
