package VariousConcepts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LoginTestCRM {
	
	 WebDriver driver;
	 
	 By USER_NAME_FIELD = By.xpath("//*[@id=\"user_name\"]");
	 By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
	 By SIGN_IN_BUTTON_FIELD = By.xpath("//*[@id=\"login_submit\"]");
	 By DASHBOARD_HEADER_FIELD = By.xpath("/html/body/div[1]/header/nav/div[2]/ul[1]/li[2]/a");
	 By CUSTOMER_BUTTON = By.xpath("/html/body/div[1]/aside[1]/div/nav/ul[2]/li[2]/a");
	 By ADD_CUSTOMER = By.xpath("//*[@id=\"customers\"]/li[2]/a/span");
	 By FULLNAME = By.xpath("//*[@id=\"general_compnay\"]/div[1]/div/input");
	 By COUNTRY_DropDown = By.xpath("//select[@name='company_name']");
	 By RIGHT_CLICK =  By.xpath("//*[@id=\"general_compnay\"]/div[3]/div/input");
	 
	 @Before
	 public void init() {
		 
		
		 System.setProperty("webdriver.chrome.driver","/Users/mehediredoy/newworkspace/Selenium_Testing/drivers/chromedriver");
		 driver = new ChromeDriver();
		 driver.manage().deleteAllCookies();
		 driver.get("https://www.codefios.com/ebilling/login");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 
 }
	 
	 
	// @Test
	 public void LoginTest() {
		 
		 
		 
		 
		 driver.findElement(USER_NAME_FIELD).sendKeys("demo@codefios.com");
		 driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		 driver.findElement(SIGN_IN_BUTTON_FIELD).click();
		 
		 String  dashboard_header_text = driver.findElement(DASHBOARD_HEADER_FIELD).getText();
		 
		 //get title and dashboard
		 
		 System.out.println(dashboard_header_text);
		 System.out.println(driver.getTitle());
		 
		 
		 Assert.assertTrue("Dashboard page not found!!", driver.findElement(DASHBOARD_HEADER_FIELD).isDisplayed());
		 Assert.assertEquals("Dashboard page not found!!", "Codefios", dashboard_header_text);
		 Assert.assertEquals("Dashboard page not found!!", "Codefios", driver.getTitle());
		 
		 
	 }
	 
	 
	 @Test
	 public void addCustomer() throws InterruptedException {
		 
		 
		 LoginTest();
		 
		 driver.findElement(CUSTOMER_BUTTON).click();
		 driver.findElement(ADD_CUSTOMER).click();
		 driver.findElement(FULLNAME).sendKeys("Mehedi");
		 driver.findElement(COUNTRY_DropDown);
		 
		 
		 Thread.sleep(2000);
		 
		 
		 // --> drop down from the select bar
		 
		 Select sel = new Select(driver.findElement(COUNTRY_DropDown));
		 
		 sel.selectByVisibleText("Walgreen");
		 
		// --> to get all option
		 
          sel.getOptions();
          
          
          
       /*   // --> Popup message on cancel button
          
          driver.switchTo().alert().dismiss();
        
          // popup msg on OK button
          
          driver.switchTo().alert().accept();
          
          // popup msg some data to alert box
          
           driver.switchTo().alert().sendKeys("text");
          
         
         
          
          
       // popup msg alert msg
          
       1:   driver.switchTo().alert().getText();
       
       2:  String get_message = driver.switchTo().alert().getText();
                  
                  system.out.println(get_message);
          
                     */
          
          
          // --> Right click
		   WebElement right_click = driver.findElement(RIGHT_CLICK);
		   Actions actions = new Actions(driver);
		   actions.contextClick(right_click).perform();
          
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
	 
	 
	 @After
	 public void tearDown() {
		 
		 
		 
		 
		 
	 }

}
