package com.TestMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestBase.BaseClass;
import com.google.common.base.Function;




public class ReusableMethods extends BaseClass{
	
	
	
	

	public  WebElement fluentWaitForElement(final By by) {
		WebElement element = null;
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
					.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

			element = wait.until(new Function<WebDriver, WebElement>() {
//				@Override
				public WebElement apply(WebDriver driver) {
					return driver.findElement(by);
				}
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return element;

	}
	


	public void pageScrollDown () throws InterruptedException {
		
		JavascriptExecutor javascript = (JavascriptExecutor) driver;  
//	    javascript.executeScript("window.scrollTo(400, document.body.scrollHeight)", ""); 
		javascript.executeScript("window.scrollTo(0,700)"); 
	    Thread.sleep(2*1000);
	    
	}




}
