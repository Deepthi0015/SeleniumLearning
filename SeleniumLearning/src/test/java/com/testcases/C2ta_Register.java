package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class C2ta_Register {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://c2ta.co.in/register/");
		driver.findElement(By.id("reg_username")).sendKeys("Deepa");
		driver.findElement(By.id("reg_email")).sendKeys("mvda8500@gmail.com");
		driver.findElement(By.id("reg_password")).sendKeys("$Deepthi0015");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}
}
