package com.testcases;

/*taking screen shorts- add the screen shot code- src/test/resources-create the folder and name it-select copy qualified code- and paste-add throws
 *  it in between FileUtils.copyFile(source,new File(("here-remove the project name and add /which page you are printing add .png") exicute it-refresh the project 
 *  ex:(("src/test/resources/ScreenShot/Orangehrmlogin.png")))- remove the ""in between code
 */

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeSnap_screenshot {

	public static void main(String[] args) throws IOException {
WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		//Taking screen shots
	       TakesScreenshot ts =(TakesScreenshot)driver;
	       File source = ts.getScreenshotAs(OutputType.FILE);
	       FileUtils.copyFile(source,new File(("src/test/resources/ScreenShot/Orangehrmlogin.png")));


	}

}
