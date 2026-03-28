package com.ui.tests;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import static com.constants.Browser.*;
import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.utility.BrowserUtility;

public class Signup2 {

	public static void main(String[] args) {
		
		HomePage homepage=new HomePage(EDGE, false); // direct calling of edge coz of static
		String username=homepage.goToSigninPage()
        .doLoginwith("TestName01@gmail.com","Password").getUserName();
		System.out.println(username);
		
		
		
		

	}

}
