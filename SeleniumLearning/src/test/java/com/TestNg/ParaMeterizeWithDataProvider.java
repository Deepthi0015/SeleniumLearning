package com.TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParaMeterizeWithDataProvider {
	
//start
	
    WebDriver driver;
	
	@Test(dataProvider="facebooklogin")
	public void loginTofacebook(String username,String password) throws Exception {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();       
	driver.get("http://www.facebook.com");
	driver.manage().window().maximize();
	driver.findElement(By.id("email")).sendKeys(username);
	driver.findElement(By.id("pass")).sendKeys(password);
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='loginbutton']")).click();
	
	}
	@AfterMethod
	public void tearDown() {
	driver.quit();
	}

	@DataProvider(name="facebooklogin")
	public Object[][] passData() {

	Object[][] data=new Object[3][2];
	 		//username
			data[0][0]="frank";
			//password
			data[0][1]="demo1";

			data[1][0]="joshi";
			data[1][1]="demo123";

			data[2][0]="rajan";
			data[2][1]="demo1234";

			return data;
	
	//end
	
	}

}
