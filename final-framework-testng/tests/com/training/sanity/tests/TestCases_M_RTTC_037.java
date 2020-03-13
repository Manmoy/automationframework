package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestCases_M_RTTC_037 {

	@Test
	public void functionAdd() {
		System.out.println("Addition Function");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ManmoyMohanty\\Desktop\\UpSkill\\Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://retailm1.upskills.in/admin/");
		driver.findElement(By.id("input-username")).sendKeys("admin@123");
		
		driver.findElement(By.id("input-password")).sendKeys("admin@123");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		driver.findElement(By.xpath("//*[@id = 'menu-catalog']/a/i")).click();
		
		driver.findElement(By.xpath("//*[contains(text(), 'Categories')]")).click();
		
	}
	
	
		
	}