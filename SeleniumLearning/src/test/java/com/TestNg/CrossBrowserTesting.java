package com.TestNg;

    import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;

	import io.github.bonigarcia.wdm.WebDriverManager;

    public class CrossBrowserTesting {
		WebDriver driver;
		
		@BeforeTest
		@Parameters("browserName")
			public void setup(String browserName) {
		
			if(browserName.equalsIgnoreCase("chrome")){
				WebDriverManager.chromedriver().setup();
				 driver = new ChromeDriver();
				
			}
		
			else if(browserName.equalsIgnoreCase("firefox")){
				WebDriverManager.firefoxdriver().setup();
				 driver = new FirefoxDriver();
				
			}
			
		}
		
		@Test
		public void facebook() {
		
			driver.get("https://www.facebook.com/");
			
			
		}
		
		@AfterTest
		public void tearDown() {
			driver.close();
		}

}
