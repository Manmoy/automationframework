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

public class RTTC_13 {

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
	// enter valid credentials in Username textbox
	public void validLoginTest() {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		
		//screenShot.captureScreenShot("First");
		
		//1. Enter Valid Credentials in Name textbox		
	//	driver.findElement(By.xpath("//Input[@id='input-username']")).sendKeys("admin");
		
       //2. Enter Valid Credentials in password textbox		
		//driver.findElement(By.xpath("//Input[@id='input-password']")).sendKeys("admin@123");

		
		
       //3. click on Login button
		//driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		// navigating to catalog and catagories link
		Actions action=new Actions(driver);
		WebElement Catalog=driver.findElement(By.xpath("//i[@class='fa fa-tags fw']"));
		WebElement Catagories=driver.findElement(By.xpath("(//a[text()='Categories'])[1]"));
		action.moveToElement(Catalog).moveToElement(Catagories).click().build().perform();
		screenShot.captureScreenShot();
		
		// Tc13 Starts here
		driver.findElement(By.xpath("(//ul[@class='pagination']//li//a)[1]")).click();
		 driver.findElement(By.xpath("//td[contains(text(),'INDIAN')]//preceding::input[@value='665']")).click();
		
		
				
				
				
				driver.findElement(By.xpath("//td[contains(text(),'INDIAN')]//following::a[1]")).click();;
		
		/*
		//td[contains(text(),'INDIAN')]//preceding::input[@value='665']
		//td[contains(text(),'INDIAN')]//following::a[1]
			
				*/
				
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		//Thread.sleep(1000);
		driver.quit();
	}
}
