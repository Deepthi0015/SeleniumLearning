package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class C2ta_Login {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://c2ta.co.in/login/");
		driver.findElement(By.id("username")).sendKeys("deepthi0015@gmail.com");
		driver.findElement(By.id("password")).sendKeys("$Deepthi0015");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

}
