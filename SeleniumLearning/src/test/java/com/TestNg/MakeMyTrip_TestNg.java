package com.TestNg;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip_TestNg {
	WebDriver driver;
	WebDriverWait wait;
	WebElement firstFlight;
	
	@BeforeTest
	public void openApp() {
	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	wait = new WebDriverWait(driver, 30);
	
	driver.get("https://www.makemytrip.com/?ccde=us");	
	}
	
	@Test(priority = 1)
	public void flightSerach() throws InterruptedException {
		//driver.findElement(By.linkText("Flights")).click();
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("webklipper-publisher-widget-container-notification-close-div")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[3]/div[2]")).click();
		Thread.sleep(1000);
		//driver.findElement(By.cssSelector("[className='chNavText darkGreyText']")).click();
		driver.findElement(By.id("fromCity")).sendKeys("Delhi");
		driver.findElement(By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-1\"]/div/div[1]/p[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("toCity")).sendKeys("Coimbatore");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-0\"]/div/div[1]/p[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@aria-label='Sat Dec 12 2020']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.linkText("Search")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/p/a")).click();
	}
	
	//we are checking the price drop down up or down
	@Test(priority = 2)
	public void printAscendingPrice () throws InterruptedException {
        Thread.sleep(10000);
		
		String arrow = driver.findElement(By.xpath("//div[contains(@class, 'price_sorter')]//span/span[2]")).getAttribute("class");
		System.out.println(arrow);
		if (!arrow.contains("down")) {
			driver.findElement(By.xpath("//*[@id=\"sorting-togglers\"]/div[5]/span/span[2]")).click();
			
		}
		List<WebElement> results= driver.findElements(By.xpath("//span[contains(@class , 'actual-price')]"));
		
		for (WebElement webElement : results) {
			System.out.println(webElement.getText());
		}
	}
		
		
	@Test(priority = 3)
	public void lowestScreenshot() throws InterruptedException, IOException {
		
		List<WebElement> lowestfare = driver.findElements(By.xpath("//div[contains(@class , 'fli-list one-way')]"));
		firstFlight = lowestfare.get(0);
		String flightCode = firstFlight.findElement(By.className("fli-code")).getText();
		String cheapestFare = firstFlight.findElement(By.className("actual-price")).getText();

		System.out.println("lowestfare :" +flightCode + ":" +cheapestFare);
		
		firstFlight.findElement(By.xpath("//span[text()='Flight Details']")).click();
	
		
		Thread.sleep(1000);
		TakesScreenshot ts =(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source,new File(("src/test/resources/ScreenShot/makemytrip.png")));
		
	}
		
		
		@Test(priority = 4)
		public void bookAndContinue() throws InterruptedException {
			Thread.sleep(1000);
			firstFlight.findElement(By.xpath("//button[text()='Book Now']")).click();
			
			Set<String> windows= driver.getWindowHandles();
			Iterator<String> iter = windows.iterator();
			String parent = iter.next();
			String child=iter.next();
			driver.switchTo().window(child);
			
			Thread.sleep(10000);
			driver.findElement(By.id("review-continue")).click();
		}
			
			
		@Test(priority = 5)	
		public void assertCity() {
			String actualDeptcity= driver.findElement(By.xpath("//p[@class='dept-city']")).findElement(By.className("LatoBold")).getText();
			String actaulArrivalcity= driver.findElement(By.xpath("//p[@class='arrival-city']")).findElement(By.className("LatoBold")).getText();
			
			String expDeptcity = "New Delhi";
			String expArrivalcity = "Coimbatore";
			
			Assert.assertEquals(actualDeptcity, expDeptcity, "Assertionerror1");
			Assert.assertEquals(actaulArrivalcity, expArrivalcity, "Assertionerror2");
			
			}
		
		
		@Test (priority = 6)
		public void teardown() {
			driver.close();
			driver.quit();
		}
			
			
		}


