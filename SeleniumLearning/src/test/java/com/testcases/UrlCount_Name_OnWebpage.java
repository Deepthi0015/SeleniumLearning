package com.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UrlCount_Name_OnWebpage {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	driver.get("https://www.google.com/");
	WebElement w = driver.findElement(By.name("q"));
	w.sendKeys("testing");
	w.submit();
	
	String Current_url= driver.getCurrentUrl();
	System.out.println(Current_url);
	
	List<WebElement> link = driver.findElements(By.tagName("a"));
	System.out.println(link.size());
	
	for(WebElement ele: link )
		System.out.println(ele.getAttribute("href"));
	
	}

}
