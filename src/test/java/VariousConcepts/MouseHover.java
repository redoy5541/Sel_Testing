package VariousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	
	
	WebDriver driver;
	 
	
	
	 @Before
	 public void init() {
		 
		
		 System.setProperty("webdriver.chrome.driver","/Users/mehediredoy/newworkspace/Selenium_Testing/drivers/chromedriver");
		 driver = new ChromeDriver();
		 driver.manage().deleteAllCookies();
		 driver.get("https://www.dell.com/en-us");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 
}
	 
	 @Test
	 public void mouseHover() {
		 
		 
		 By Computer_Acc = By.xpath("//*[@id=\"unified-masthead-navigation\"]/nav/ul/li[3]/button");
		 By Monitors = By.xpath("//*[@id=\"unified-masthead-navigation\"]/nav/ul/li[3]/ul/li[5]/button");
		 By ViewAllMonitors = By.xpath("//*[@id=\"unified-masthead-navigation\"]/nav/ul/li[3]/ul/li[4]/ul/li[3]/a");
		 
		 Actions action = new Actions(driver);
		 action.moveToElement(driver.findElement(Computer_Acc)).build().perform();
		 action.moveToElement(driver.findElement(Monitors)).build().perform();
		 action.moveToElement(driver.findElement(ViewAllMonitors)).click();
				 
		
		 
	 }
	
	
	
	
	
	
	

}


