package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//visible text, html drop down is select-following methods
		
		driver.get("http://output.jsbin.com/osebed/2");
		WebElement fruits =driver.findElement(By.id("fruits"));
		
		Select obj = new Select(fruits);
		obj.selectByValue("banana");
		obj.selectByValue("orange");
		obj.selectByVisibleText("Grape");//<option value="orange">Orange</option>--selectByValue=grape,selectByVisibleText=Grape
		
		

	}

}
