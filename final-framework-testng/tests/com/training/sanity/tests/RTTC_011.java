package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_011 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@Test
	//1. enter valid credentials in Username textbox
	public void validLoginTest() {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		
		//screenShot.captureScreenShot("First");
		
		//1. enter valid credentials in Username textbox
		Actions action=new Actions(driver);
		WebElement posts=driver.findElement(By.xpath("//div[contains(text(),'Posts')]"));
		WebElement tags=driver.findElement(By.xpath("//a[@href='edit-tags.php?taxonomy=post_tag']"));
		action.moveToElement(posts).moveToElement(tags).click().build().perform();
		screenShot.captureScreenShot();
		
//		//2. Enter Valid Credentials in Name textbox		
//				driver.findElement(By.xpath("//Input[@id='input-username']")).sendKeys("admin");
//				
//		//3. Enter Valid Credentials in password textbox		
//				driver.findElement(By.xpath("//Input[@id='input-password']")).sendKeys("admin@123");
//		
//				
//				
//		//4. click on Login button
//				driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
//				screenShot.captureScreenShot();
//				
				
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		//Thread.sleep(1000);
		//driver.quit();
	}
}
