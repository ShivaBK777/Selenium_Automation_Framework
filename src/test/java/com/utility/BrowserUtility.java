package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import com.constants.Browser;

public abstract class BrowserUtility<TakeScreenshot> {

	public WebDriver getDriver() {
		return driver.get();
	}

	private static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver); 
	}
	
//	public BrowserUtility(String browsername) {
//		if(browsername.equalsIgnoreCase("Chrome")) {
//			driver.set(new ChromeDriver());
//		}
//		else if(browsername.equalsIgnoreCase("Edge")) {
//			driver.set(new EdgeDriver());
//		}
//		
//		else System.err.println("Invalid browser name");
//	}
	
	public BrowserUtility(Browser browsername) {
		if(browsername==Browser.CHROME) {
			driver.set(new ChromeDriver());
		}
		else if(browsername==Browser.EDGE) {
			driver.set(new EdgeDriver());
		}
	}
	
	public BrowserUtility(Browser browsername,boolean isHeadLessMode) {
		if(browsername==Browser.CHROME) {
			if(isHeadLessMode) {
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--headless=old"); // headless
			opt.addArguments("--window-size=1920,1080");
			driver.set(new ChromeDriver(opt));
			}
			else
				driver.set(new ChromeDriver());
		}
		else if(browsername==Browser.EDGE) {
			driver.set(new EdgeDriver());
		}
	}
		
	
	
	public void goToWebSite(String url) {
		driver.get().get(url);
	}
	
	public void maximizeWindow() {
		driver.get().manage().window().maximize();
	}
	
	public void click(By locator) {
		WebElement WebElement=driver.get().findElement(locator);  // finding happens here
	//	WebElement.click(); earlier this was there but pop-ups keep coming hence jsexecutor is used
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", WebElement);
	}
	
	public void enterText(By locator,String abc) {
		WebElement WebElement=driver.get().findElement(locator);
		WebElement.sendKeys(abc);
	}
	
	public String getText(By locator) {
		WebElement WebElement=driver.get().findElement(locator);
		return WebElement.getText();
	}
	
	public void  takescreenshot() {
		TakesScreenshot screenshot= (TakesScreenshot)driver.get();
		
		File sscaptured=screenshot.getScreenshotAs(OutputType.FILE);
		String destinationpath=System.getProperty("user.dir")+"//screenshot//"+ "screenshot1"+".png";
		File screenshotFilepath=new File(destinationpath);
		
		try {
			FileUtils.copyFile(sscaptured,screenshotFilepath);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
