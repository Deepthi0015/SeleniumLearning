package com.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locaters_OrangeHRM {

	public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin123");
		//driver.findElement(By.id("btnLogin")).click();
		//driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.partialLinkText("Forgot your")).click();
		
		//Taking screen shots
	       TakesScreenshot ts =(TakesScreenshot)driver;
	       File source = ts.getScreenshotAs(OutputType.FILE);
	       FileUtils.copyFile(source,new File(("src/test/resources/Password/Orangehrmpassword.png")));
		
	}

}
