package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//alert 3 types- accept, conformation box, conformation box and sending
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[1]/div[2]/button")).click();
		
		//how to go to alert and control-first switchto alert and either accept it or dismiss or sendKeys
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/button")).click();
		Thread.sleep(4000);
		driver.switchTo().alert().dismiss();
		
		driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[3]/div[2]/button")).click();
		Thread.sleep(4000);
		driver.switchTo().alert().sendKeys("Deepa");
		Thread.sleep(2000);
		String errormessage = driver.switchTo().alert().getText();
		System.out.println(errormessage);
		driver.switchTo().alert().accept();

	}

}
