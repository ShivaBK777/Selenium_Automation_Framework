package com.ui.tests;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import com.utility.BrowserUtility;

public class Signup {

	public static void main(String[] args) {
		
		WebDriver driver=new EdgeDriver();
		
		BrowserUtility obj=new BrowserUtility(driver); // cannot create obj,coz it is abstract
		obj.goToWebSite("https://automationexercise.com/");
		obj.maximizeWindow();
		
		By SignInLinkLocator=By.xpath("//a[@href='/login']"); //locating element
		 obj.click(SignInLinkLocator);
		
		By nameLocator=By.xpath("//input[@name='name']");
		WebElement nameWebElement=driver.findElement(nameLocator);
		nameWebElement.sendKeys("TestName01");
			
		By emailLocator=By.xpath("//input[@name='email' and @data-qa='signup-email']");
		WebElement emailWebElement=driver.findElement(emailLocator);
		emailWebElement.sendKeys("TestName01@gmail.com");

		By SignupLocator=By.xpath("//button[@type='submit' and @data-qa='signup-button']");
		obj.click(SignupLocator);
		
		By PasswordLocator=By.xpath("//input[@type='password']");
		obj.enterText(PasswordLocator,"Password");
		
		WebElement DaysWebElement=driver.findElement(By.id("days"));
		Select s=new Select(DaysWebElement);
		s.selectByIndex(1);
		
		driver.findElement(By.xpath("//input[@type='text' and @data-qa='first_name']")).sendKeys("TestFirstname01");
		driver.findElement(By.xpath("//input[@type='text' and @data-qa='last_name']")).sendKeys("TestLastname01");
		driver.findElement(By.xpath("//input[@type='text' and @data-qa='address']")).sendKeys("Addrresss");
		Select country=new Select(driver.findElement(By.id("country")));
		country.selectByValue("India");
		
		driver.findElement(By.xpath("//input[@type='text' and @data-qa='state']")).sendKeys("Karnataka");
		driver.findElement(By.xpath("//input[@type='text' and @data-qa='city']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//input[@type='text' and @data-qa='zipcode']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@type='text' and @data-qa='mobile_number']")).sendKeys("1234564789");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

}
