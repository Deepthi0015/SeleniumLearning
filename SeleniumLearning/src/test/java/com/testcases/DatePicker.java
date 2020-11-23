package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) {
		
		

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.redbus.in/");
		WebElement des = driver.findElement(By.id("src"));
		des.click();
		des.sendKeys("Madras");
		//des.submit();
		WebElement arr = driver.findElement(By.id("dest"));
		arr.click();
		arr.sendKeys("New Delhi");
        driver.findElement(By.id("onward_cal")).click();
		driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[7]/td[4]")).click();
		WebElement sub =driver.findElement(By.id("search_btn"));
		sub.click();
		
		
		
		
		
		

	}

}
