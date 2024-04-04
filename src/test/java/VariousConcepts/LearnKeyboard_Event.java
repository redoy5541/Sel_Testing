package VariousConcepts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.FileChooserUI;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnKeyboard_Event {
	
 WebDriver driver;
	 
	 By USER_NAME_FIELD = By.xpath("//*[@id=\"user_name\"]");
	 By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
	 By SIGN_IN_BUTTON_FIELD = By.xpath("//*[@id=\"login_submit\"]");
	
	 @Before
	 public void init() {
		 
		
		 System.setProperty("webdriver.chrome.driver","/Users/mehediredoy/newworkspace/Selenium_Testing/drivers/chromedriver");
		 driver = new ChromeDriver();
		 driver.manage().deleteAllCookies();
		 driver.get("https://www.codefios.com/ebilling/login");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 
 }
	 
	 @Test
	 public void LoginTest() {
		 
		 
		 
		 
		 driver.findElement(USER_NAME_FIELD).sendKeys("demo@codefios.com");
		 driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		 
		 Actions action = new Actions(driver);
		 action.sendKeys(Keys.ENTER).build().perform();
		 
		 takeScreenshot(driver);
		 
		 
	 }
	 
	 public void takeScreenshot(WebDriver driver) {
		 
		 TakesScreenshot ts = (TakesScreenshot)driver;
		 File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		 
		 //  FileUtils.copyFile(sourceFile, new File(System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png"));
		 
	     try {
			FileUtils.copyFile(sourceFile, new File(System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		 
		 
		 
	 }
	
	
	
	
	
	
	

}
