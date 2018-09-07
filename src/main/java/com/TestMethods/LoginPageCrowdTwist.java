package com.TestMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.BaseClass;

public class LoginPageCrowdTwist extends BaseClass {
	
	ReusableMethods reuse = new ReusableMethods();
	CrowdTwistNewUserRegistraionPage FromregistrationPage = new CrowdTwistNewUserRegistraionPage();
	
	@FindBy (id="SubmitLogin")
		public WebElement SignInButton;
	@FindBy (linkText="Forgot your password?")
		public WebElement ForgotPassword;
	public By PasswordRestSucessMessage = By.xpath("//div[@id='center_column']/div/p");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
	
	public void ForgetPassword(String YourEmail){
			
		ForgotPassword.click();
		String passwordresetpge= reuse.fluentWaitForElement(By.tagName("h1")).getText();
		System.out.println(passwordresetpge);
		FromregistrationPage.UserEmail.sendKeys(YourEmail);
		driver.findElement(By.xpath("//form[@id='form_forgotpassword']/fieldset/p/button")).click();
		System.out.println(driver.findElement(PasswordRestSucessMessage).getText());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
