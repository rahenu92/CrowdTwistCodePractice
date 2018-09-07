package com.TestMethods;

import org.apache.xerces.util.SynchronizedSymbolTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.TestBase.BaseClass;

public class CrowdTwistNewUserRegistraionPage extends BaseClass{
	
	
	ReusableMethods reuse = new ReusableMethods();
	
	
//*************************************
	
	@FindBy (id="email_create")
		public WebElement NewUserRegistrationEmail;
	
	@FindBy (id="SubmitCreate")
		public WebElement CreateAnAccountButton;
	
	public By WaitForPersonalInfoPage = By.xpath("//*[text()='Your personal information']");
	
	@FindBy (id="customer_firstname")
		public WebElement YourPersonalInformationFname;
	
	@FindBy (id="customer_lastname")
		public WebElement YourPersonalInformationLname;
	
	@FindBy (id="passwd")
		public WebElement YourPersonalInformationPassword;
	
	
// Your Address 	section
	@FindBy (id="firstname")
		public WebElement YourAddressFname;
	@FindBy (id="lastname")
		public WebElement YourAddressLname;
	@FindBy (id="address1")
		public WebElement YourAddressAdress1;
	@FindBy (id="address2")
		public WebElement YourAddressAdress2;
	@FindBy (id="city")
		public WebElement YourAddressCity;
	@FindBy (id="id_state")
		public WebElement YourAddressState;
	@FindBy (id="postcode")
		public WebElement YourAddressZipCode;
	@FindBy (id="phone_mobile")
		public WebElement YourAddressMobile;
	@FindBy (id="submitAccount")
		public WebElement YourAddressRegisterButton;
	
	@FindBy (id="email")
		public WebElement UserEmail;

	
	
		
	
	
	
	
	//************************************************************************************************
		public CrowdTwistNewUserRegistraionPage(){
			PageFactory.initElements(driver, this);
		}	
	
	
	
	public void NewUserRegistration(String Email, String F_name, String L_name, String password, 
									String address,	String CityName, String StateFullName, 	
									String zipcode, String MobileNum) 
									throws InterruptedException{
		NewUserRegistrationEmail.clear();
		NewUserRegistrationEmail.sendKeys(Email);
		CreateAnAccountButton.click();
		String YourPersonalPage = reuse.fluentWaitForElement(WaitForPersonalInfoPage).getText();
		System.out.println("your are on page:" +YourPersonalPage);
		YourPersonalInformationFname.clear();
		YourPersonalInformationFname.sendKeys(F_name);
		YourPersonalInformationLname.clear();
		YourPersonalInformationLname.sendKeys(L_name);
		UserEmail.clear();
		UserEmail.sendKeys(Email);
		Thread.sleep(5*1000);
		YourPersonalInformationPassword.clear();
		YourPersonalInformationPassword.sendKeys(password);
		Thread.sleep(2*1000);
		reuse.pageScrollDown();
		YourAddressAdress1.clear();
		YourAddressAdress1.sendKeys(address);
		YourAddressCity.clear();
		YourAddressCity.sendKeys(CityName);
		Select SelectState =new Select(YourAddressState);
		SelectState.selectByVisibleText(StateFullName);
		reuse.pageScrollDown();
		Thread.sleep(2*1000);
		YourAddressZipCode.sendKeys(zipcode);
		YourAddressMobile.sendKeys(MobileNum);
		Thread.sleep(3*1000);
		YourAddressRegisterButton.click();
		
		
	}
	
	
	
	

}
