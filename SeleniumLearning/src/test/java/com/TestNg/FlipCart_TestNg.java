package com.TestNg;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipCart_TestNg {
	
	WebDriver driver;
	
	@BeforeTest
	public void launchApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
	}
	
	@Test(priority=1)
	public void verifyTitle() {
		
		String expectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority=2)
	public void search() throws InterruptedException {
		WebElement ele =driver.findElement(By.name("q"));
		ele.sendKeys("apple laptops");
		Thread.sleep(2000);
		ele.submit();
		
	}
	@Test(priority=3)
	public void selectProduct() {
		//driver.findElement(By.xpath("//div[@class='_4rR01T']")).click();
		Actions action = new Actions(driver);
		action.click(driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]"))).build().perform();
	}
	@Test(priority=5)
	public void addToCart() {
		Set<String> window= driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")).click();
	}
	@Test(priority=6)
	public void assertProductName() throws InterruptedException {
		String actualProduct =driver.findElement(By.partialLinkText("Apple MacBook")).getText();
		Thread.sleep(2000);
		System.out.println(actualProduct);
		String expectedProduct = "Apple MacBook Air Core i5 5th Gen - (8 GB/128 GB SSD/Mac OS Sierr...";
		Thread.sleep(2000);
		Assert.assertEquals(actualProduct, expectedProduct);
	}
	@Test(priority=4)
	
	public void assertPrice() throws InterruptedException {
		Thread.sleep(3000);
		String actualPrice = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/div/div/a/div[3]/div[2]/div[1]/div/div[1]")).getText();
		Thread.sleep(3000);
		System.out.println(actualPrice);
		//double str =Double.valueOf(price.substring(1,price.length()));
		System.out.println(actualPrice);
		String expectedPrice = "₹69,990";
		Assert.assertEquals(actualPrice, expectedPrice);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
