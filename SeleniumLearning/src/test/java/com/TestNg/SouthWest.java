package com.TestNg;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SouthWest {
	
	WebDriver driver;
	@BeforeTest
	public void login() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.southwest.com/");
		
	}
	@Test
	public void destination() throws InterruptedException {
	WebElement from = driver.findElement(By.id("LandingAirBookingSearchForm_originationAirportCode"));
	from.sendKeys(Keys.CONTROL+"A");
	from.sendKeys(Keys.DELETE);
	from.sendKeys("AUS");
	driver.findElement(By.xpath("//button[@class='actionable actionable_button swa-g-selected actionable_vertical-menu button']")).click();
	driver.findElement(By.id("LandingAirBookingSearchForm_destinationAirportCode")).sendKeys("DEN");
	driver.findElement(By.xpath("//*[@id=\"LandingAirBookingSearchForm_destinationAirportCode\"]")).click();
	
	Thread.sleep(2000);
	driver.findElement(By.id("LandingAirBookingSearchForm_departureDate")).click();
	driver.findElement(By.id("calendar-112-2020-12-03")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("LandingAirBookingSearchForm_returnDate")).click();
	driver.findElement(By.id("calendar-115-2021-01-11")).click();
	
	driver.findElement(By.id("LandingAirBookingSearchForm_submit-button")).click();
	Thread.sleep(4000);
	}
	
	@Test
	public void screenShot() throws IOException, InterruptedException {
		
		Thread.sleep(2000);
		
		TakesScreenshot ts =(TakesScreenshot)driver;
	       File source = ts.getScreenshotAs(OutputType.FILE);
	       FileUtils.copyFile(source,new File("src/test/resources/ScreenShot/southwest1.png"));
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		
	}
}

