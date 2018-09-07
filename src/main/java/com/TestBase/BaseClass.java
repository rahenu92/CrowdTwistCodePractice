package com.TestBase;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
//import java.util.TestUtil;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import com.Utill.TestUtil;




public class BaseClass {
	
public static WebDriver driver;
public static Properties prop;


				public  BaseClass(){
					
				
					try {
						 prop = new Properties();
//					//						
						FileInputStream ConfigLocation = new FileInputStream ("C:/Users/choudhuryr/workspace/CrowdTwistCodePractice/src"
								+ "/main/java/com/TestData/config.properties");		
					 prop = new Properties();
						prop.load(ConfigLocation);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					

	
				}			
				public static WebDriver intitialization() throws InterruptedException{
					
					String browserName = prop.getProperty("browser");
					
					
					
					if(browserName.equalsIgnoreCase("chrome")){
					System.out.println("Chrome browser started...");
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--start-maximized");
					options.addArguments("--disable-web-security");
					options.addArguments("--no-proxy-server");
					Map<String, Object> prefs = new HashMap<String, Object>();
					prefs.put("credentials_enable_service", false);
					prefs.put("profile.password_manager_enabled", false);
					options.setExperimentalOption("prefs", prefs);
					System.setProperty("webdriver.chrome.driver","C:/Users/choudhuryr/workspace/newdrivers/chromedriver.exe");
					driver = new ChromeDriver(options);
					Thread.sleep(3*1000);
					driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
					driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
					driver.get(prop.getProperty("url"));	
	//				return driver;

							
				}else if (browserName.equalsIgnoreCase("firefox")){
					System.out.println("FireFox browser started.......");
					System.setProperty("webdriver.chrome.driver","C:/Program Files/MozillaFirefox/geckodriver");
					driver = new FirefoxDriver();
					driver.manage().window().maximize();
					driver.manage().deleteAllCookies();
					driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
					driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
					driver.get(prop.getProperty("url"));
					
					}					
						
						
					
				
				
					return driver;
				}

	
}
