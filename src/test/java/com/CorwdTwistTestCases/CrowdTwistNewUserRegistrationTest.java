package com.CorwdTwistTestCases;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import com.TestBase.BaseClass;
import com.TestMethods.CrowdTwistNewUserRegistraionPage;
import com.TestMethods.HomePageCrowdTwist;
import com.TestMethods.ReusableMethods;

public class CrowdTwistNewUserRegistrationTest extends BaseClass {
	
			CrowdTwistNewUserRegistraionPage newuser;
			SoftAssert softassert = new SoftAssert();
			ReusableMethods reuse = new ReusableMethods();
			HomePageCrowdTwist FromHomePage = new HomePageCrowdTwist();
	
//*******************	
	public CrowdTwistNewUserRegistrationTest(){
		super();
	}
//************
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		intitialization();
		 newuser = new CrowdTwistNewUserRegistraionPage();
	}
	
	
	
@Test()
	
	public void NewUserRegistrationTest() throws Exception{
	
//			String newEmail = "NewCustomer" + date1 + "@Test.com";
		newuser.NewUserRegistration(prop.getProperty("newuseremail"), prop.getProperty("YourInfoFname"), 
								prop.getProperty("YourInfoLname"),prop.getProperty("pass"), 
								prop.getProperty("adress"), prop.getProperty("City"), prop.getProperty("State"), 
								prop.getProperty("Zipcode"), prop.getProperty("mobile"));
		Thread.sleep(5*1000);					
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
