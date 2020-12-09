package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileBin {
	public class ClickAndHold {
		WebDriver driver;
		@Test
		public void login() throws InterruptedException {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://filebin.net/");
			driver.findElement(By.xpath("//*[@id=\"fileField\"]")).sendKeys("C:\\Users\\lokesh.malepati\\Desktop\\Uploading_Files.txt");

}
	}
}
