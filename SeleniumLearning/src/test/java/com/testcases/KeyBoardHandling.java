package com.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardHandling {
	WebDriver driver;
	
	@BeforeTest
	public void login() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.get("https://opensource-demo.orangehrmlive.com/");
	}
    @Test(priority=1)
    public void orange() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		Thread.sleep(4000);
		/* driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();*/
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys("admin123").perform();
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.ENTER).perform();
		
		System.out.println("loging in");
		}
	@Test(priority=2)
	public void listDisplay() {
		
		driver.navigate().to("https://www.redbus.in/");
		driver.findElement(By.id("src")).sendKeys("c");
		List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"search\"]/div/div[1]/div/ul/li"));
		
		for(WebElement mylist: list) {
			System.out.println(mylist.getText());
		}
	}
	@AfterTest
	public void tearDown() {
		
	}
}

