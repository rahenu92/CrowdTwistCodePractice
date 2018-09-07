package com.TestMethods;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.BaseClass;

public class CartSummaryPage extends BaseClass{
	
	
	ReusableMethods reuse = new ReusableMethods();
	CrowdTwistNewUserRegistraionPage FromregistrationPage = new CrowdTwistNewUserRegistraionPage();
	HomePageCrowdTwist FromHomePage = new HomePageCrowdTwist();
	
//****************	
	
	
	
	
	
	
	
	public CartSummaryPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void ProcedCeckOut() throws InterruptedException{
			
			System.out.println(driver.findElement(By.id("total_price")).getText());
			reuse.pageScrollDown();
			reuse.fluentWaitForElement(FromHomePage.WaitForProceedcheckoutbutton).click();
			reuse.pageScrollDown();
			driver.findElement(By.xpath(".//button [@name='processAddress']")).click();
			try {
				Thread.sleep(2*1000);
			driver.findElement(By.id("cgv")).click();
			}catch(Exception e)
			{
			
			}
			driver.findElement(By.xpath(".//button [@name='processCarrier']")).click();
	}
	
	public void PayByWireAndConfirm(){
			reuse.fluentWaitForElement(By.cssSelector(".bankwire")).click();
			reuse.fluentWaitForElement(By.xpath(".//*[@id='cart_navigation']/button")).click();
//			driver.findElement(By.linkText("I confirm my order")).clear();
		
	}
	
	public void OrderverificationFromOrderPage(){
		driver.findElement(By.cssSelector(".button-exclusive.btn.btn-default")).click();
		
		System.out.println("The order COnfirmation Number is:"
				+driver.findElement(By.xpath(".//*[@id='order-list']/tbody/tr[1]/td[1]/a")).getText());
		
	}
			

}
