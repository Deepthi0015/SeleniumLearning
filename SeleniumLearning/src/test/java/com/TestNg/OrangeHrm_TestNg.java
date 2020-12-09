package com.TestNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrm_TestNg {
	
	WebDriver driver; 
	
	@BeforeTest
	public void launchapp() {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		}
	
	@Test(description ="login to Orange HRM", priority =1)
	public void loginapp() {
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
	}
	
	@Test(description ="Admin Search", priority =2)
	public void adminPage() {
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		
		
		
	}
	
	@AfterTest
	public void closeApp() {
		
		driver.close();
		
	}

}
