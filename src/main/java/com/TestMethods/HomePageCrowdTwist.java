package com.TestMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.BaseClass;


public class HomePageCrowdTwist extends BaseClass{
	
	
	
	ReusableMethods reuse = new ReusableMethods();
	CrowdTwistNewUserRegistraionPage FromregistrationPage = new CrowdTwistNewUserRegistraionPage();
	
	
//***********	
	@FindBy (linkText="DRESSES")
		WebElement DressesLink;
	@FindBy (linkText="Proceed to checkout")
	WebElement Proceedcheckoutbutton;
	By WaitForProceedcheckoutbutton = By.linkText("Proceed to checkout");
	
	
	
	public By UserInfoHeader=By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a/span");
//	@FindBy	(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a/span")
//	public WebElement UserInfoHeader;
		

	
	
	//************************************************************************************************
	public HomePageCrowdTwist(){
		PageFactory.initElements(driver, this);
	}

	
	
	public void SignOut(){
		
		driver.findElement(By.cssSelector(".logout")).click();
		
		
	}
	
	public void NavigateToDressCategory(){
		DressesLink.click();
	}
	
	public void HoverToAddFirstIteamToCart() throws InterruptedException{
		
		WebElement hoverondress = reuse.fluentWaitForElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img"));
		Actions hover = new Actions(driver);
		hover.moveToElement(hoverondress).build().perform();
		reuse.fluentWaitForElement(By.linkText("Add to cart")).click();
		
	}
	
	public void ProceedCheckOutFromPopUp(){

		reuse.fluentWaitForElement(WaitForProceedcheckoutbutton).click();
		
	}
	
	
	
	
}
