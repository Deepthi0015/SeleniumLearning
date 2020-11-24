package com.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton_homework {

	public static void main(String[] args) throws IOException {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://c2ta.co.in/login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("username")).sendKeys("deepthi0015@gmail.com");
		driver.findElement(By.id("password")).sendKeys("$Deepthi0015");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-995\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"post-1398\"]/div/div[1]/a/img")).click();		
		
		driver.findElement(By.xpath("//*[@id=\"section-form-input-type-learning-37\"]/ul/li[1]/a/span")).click();
		driver.findElement(By.xpath("(//input[@name='radioButton'])[2]")).click();
		
		 TakesScreenshot ts =(TakesScreenshot)driver;
	       File source = ts.getScreenshotAs(OutputType.FILE);
	       FileUtils.copyFile(source,new File(("src/test/resources/RadioButton/RadioButton.png")));
		
		
		
		
		
		
		
		
		

	}

}
