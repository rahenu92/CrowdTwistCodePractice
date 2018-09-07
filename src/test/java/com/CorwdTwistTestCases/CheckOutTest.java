package com.CorwdTwistTestCases;

import javax.naming.spi.DirStateFactory.Result;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestBase.BaseClass;
import com.TestMethods.CartSummaryPage;
import com.TestMethods.CrowdTwistNewUserRegistraionPage;
import com.TestMethods.HomePageCrowdTwist;
import com.TestMethods.LoginPageCrowdTwist;
import com.TestMethods.ReusableMethods;

public class CheckOutTest extends BaseClass {
	
	
	LoginPageCrowdTwist login;
	CartSummaryPage CartSummaryPage;
	ReusableMethods reuse = new ReusableMethods();
	HomePageCrowdTwist FromHomePage;

	public CheckOutTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		intitialization();
		 login = new LoginPageCrowdTwist();
			FromHomePage= new HomePageCrowdTwist();
		 CartSummaryPage = new CartSummaryPage();
		 }
	
@Test (description="This test will purchase the first on the Home page")	
	public void PurchaseFirtDress() throws InterruptedException{
		
		login.LoginExistingUser(prop.getProperty("email"), prop.getProperty("pass"));
		FromHomePage.NavigateToDressCategory();
		FromHomePage.HoverToAddFirstIteamToCart();
		
		FromHomePage.ProceedCheckOutFromPopUp();
		CartSummaryPage.ProcedCeckOut();
		CartSummaryPage.PayByWireAndConfirm();
		CartSummaryPage.OrderverificationFromOrderPage();
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void teardown() throws Exception{	
		driver.quit();
		System.out.println("Browser closed out.");
		System.out.println("__________________");

	}
	
	
	
	
}
