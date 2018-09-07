package com.CorwdTwistTestCases;

import org.junit.experimental.theories.FromDataPoints;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.TestBase.BaseClass;
import com.TestMethods.CrowdTwistNewUserRegistraionPage;
import com.TestMethods.HomePageCrowdTwist;
import com.TestMethods.LoginPageCrowdTwist;
import com.TestMethods.ReusableMethods;

public class LogInTestCrowdTwist extends BaseClass{

	LoginPageCrowdTwist login;
	LoginPageCrowdTwist home;
	HomePageCrowdTwist FromHomePage = new HomePageCrowdTwist();
	ReusableMethods reuse = new ReusableMethods();
	SoftAssert softassert = new SoftAssert();
	
	
	
	//*******************	
		public LogInTestCrowdTwist(){
			super();
		}
	//************
		
		
		@BeforeMethod
		public void setUp() throws InterruptedException {
			intitialization();
			 login = new LoginPageCrowdTwist();
			 home= new LoginPageCrowdTwist();
		}
		
@Test			
	public void LoginTest(){
		
		login.LoginExistingUser(prop.getProperty("email"), prop.getProperty("pass"));
		String a= reuse.fluentWaitForElement(FromHomePage.UserInfoHeader).getText();
		System.out.println(a);
		softassert.assertNotEquals(reuse.fluentWaitForElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a/span")).getText(),
				prop.getProperty("YourInfoFname") + prop.getProperty("YourInfolname"));
		System.out.println("The User name is :"
				+driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a/span")).getText());
		softassert.assertAll();	
}





@AfterMethod
public void teardown() throws Exception{	
	driver.quit();
	System.out.println("Browser closed out.");
	System.out.println("__________________");

}
}
