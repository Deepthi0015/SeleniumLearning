package com.TestNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class C2ta_TestNg {
	
	WebDriver driver;
	
	@BeforeTest
	public void launch(){
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://c2ta.co.in/login/");
		
	}
	@Test
	public void login() {
		
		driver.findElement(By.id("username")).sendKeys("deepthi0015@gmail.com");
		driver.findElement(By.id("password")).sendKeys("$Deepthi0015");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
	
	@AfterTest
	public void teardown() { //teardown means close
		
		driver.close();
	}
	

}
