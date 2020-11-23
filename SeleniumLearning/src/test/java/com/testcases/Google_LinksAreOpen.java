package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

//opening a google page and searching for testing. Find out how many links are open on that page and printing a current page url 

public class Google_LinksAreOpen {

	public static void main(String[] args) {
    
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		
		//sending the keys to search box and clicking
		driver.findElement(By.name("q")).sendKeys("testing");
		driver.findElement(By.name("btnK")).click();
		
		//getting the current url and printing
		String title = driver.getCurrentUrl();
		System.out.println(title);
		
		//making the list of urls and printing the size
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		//printing the urls in console
		for(WebElement ele : links)
			System.out.println(ele.getAttribute("href"));
		
		
		

	}

}
