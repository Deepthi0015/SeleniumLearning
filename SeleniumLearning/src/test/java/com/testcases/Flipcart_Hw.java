package com.testcases;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipcart_Hw {

	WebDriver driver;
	WebElement firstElement;

	@Test(priority=1)
	public void launching() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority=2)
	public void sendingKeys() {
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[contains(text(),'✕')]")).click();
		WebElement list = driver.findElement(By.xpath("//input[@name='q']"));
		list.sendKeys("laptop"+Keys.ENTER); //keyboard handling
		//list.submit();

	}

	@Test(priority=3)
	public void selectingBrand() throws InterruptedException {
		/*Actions action = new Actions(driver);
	Thread.sleep(4000);
	WebElement processor = driver.findElement(By.xpath("(//input[@type='checkbox']/following-sibling::div)[3]"));
	Thread.sleep(7000);
	WebElement brand=driver.findElement(By.xpath("//div[contains(@title,'HP')]"));
	Thread.sleep(6000);
	//action.moveToElement(brand).moveToElement(processor).click().build().perform();
	WebDriverWait w = new WebDriverWait(driver,30);
	w.until(ExpectedConditions.elementToBeClickable(processor)).click();
	action.moveToElement(brand).moveToElement(processor).click().build().perform();*/

		driver.findElement(By.xpath("(//input[@type='checkbox']/following-sibling::div)[3]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//input[@type='checkbox']/following-sibling::div)[18]")).click();
		Thread.sleep(4000);
	}

	@Test(priority=4)
	public void gettingText() {
		List<WebElement> list = driver.findElements(By.xpath("//div[contains(@class,'_2pi5LC col-12-12')]"));
		
		WebElement firstElement = list.get(0);
		System.out.println(firstElement.findElement(By.xpath("//div[contains(@class,'col col-7-12')]")).getText());
		
		//firstElement.findElement(By.xpath("//a[contains(@class,'_1fQZEK')]")).click();
		
    }
	@Test(priority=5)
	public void clicking() {
		//firstElement.findElement(By.xpath("//a[contains(@class,'_1fQZEK')]")).click();
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")).click();

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it =windows.iterator();
		String parent = it.next();
		String child= it.next();
		driver.switchTo().window(child);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")).click();
	}
	@Test(priority=6)
	public void screenshot() throws IOException {

		TakesScreenshot ts =(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source,new File(("src/test/resources/ScreenShot/flipkart.png")));
	}




}
