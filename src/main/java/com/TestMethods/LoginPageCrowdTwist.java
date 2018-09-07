package com.TestMethods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.BaseClass;

public class LoginPageCrowdTwist extends BaseClass {
	
	ReusableMethods reuse = new ReusableMethods();
	CrowdTwistNewUserRegistraionPage FromregistrationPage = new CrowdTwistNewUserRegistraionPage();
	
	@FindBy (id="SubmitLogin")
		public WebElement SignInButton;
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//************************************************************************************************
	public LoginPageCrowdTwist(){
		PageFactory.initElements(driver, this);
	}	

	public void LoginExistingUser(String Email, String password){
		FromregistrationPage.UserEmail.clear();
		FromregistrationPage.UserEmail.sendKeys(Email);
		FromregistrationPage.YourPersonalInformationPassword.clear();
		FromregistrationPage.YourPersonalInformationPassword.sendKeys(password);
		SignInButton.click();
	
		
	}
	

}
