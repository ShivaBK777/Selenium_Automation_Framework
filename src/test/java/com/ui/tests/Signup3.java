package com.ui.tests;
import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.constants.Browser.*;
import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.ui.pojos.User;
import com.utility.BrowserUtility;
import com.utility.loggerUtility;


@Listeners(com.ui.listeners.testListner.class)


public class Signup3 extends TestBase {

	/*Best practices
	 * 1-Test scripts needs to be small
	 * 2-if,while,for --no conditional statemetns
	 * 3-reduce use of local var
	 * 4.Atleast one assertion
	 */
	
//	HomePage homepage; 
//	
//	@BeforeMethod(description = "Load homepage")
//	public void setup(){
//		 homepage=new HomePage(EDGE); // direct calling of edge coz of static
//		
//	}
	// know diff bw beforemethod vds beforetest
	
	
	  @Test(description="Verfies login flow",groups= {"reg","e2e","sanity"},
			  dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestDataProvider")
	  
	  //public void loginTest() {
	   public void loginTest(User user) {
		
		String username=homepage.goToSigninPage()
    //    .doLoginwith("TestName01@gmail.com","Password").getUserName();
		 .doLoginwith(user.getEmail(),user.getPassword()).getUserName();
		Assert.assertEquals(username, "TestName01");
		// this still can be reduced to 1 line
		
	   }
		
	  
	  
	  @Test(description="Verfies login flow",groups= {"reg","e2e","sanity"},
			  dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestCSVDataProvider"
			  )
	   public void loginCSVTest(User user) {
		//  logger.info("Started login ");
		String username=homepage.goToSigninPage()
        .doLoginwith(user.getEmail(),user.getPassword()).getUserName();
		Assert.assertEquals(username, "TestName01");
		//logger.info("Login completed");
		
	   }	
		
	  //only this is not running above two works
	  @Test(description="Verfies login flow thru Excel reader",dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,
			  dataProvider="LoginTestExcelDataProvider",retryAnalyzer = com.ui.listeners.MyRetryAnalyser.class)
      public void ReadExcel(User user) {
		  
  		String username=homepage.goToSigninPage()
          .doLoginwith(user.getEmail(),user.getPassword()).getUserName();
  		Assert.assertEquals(username, "TestName01");
  		
  		
      }
	

}
