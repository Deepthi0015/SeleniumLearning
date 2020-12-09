package com.TestNg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Sampletestcase {
	  @Test
	  public void tc001() {
		  System.out.println("Test case 1");
	  }
	  
	  @Test
	  public void tc002() {
		  System.out.println("Test case 2");
	  }
	  @Test
	  public void tc003() {
		  System.out.println("Test case 3");
	  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before method : login");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After method : close App");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println(" Before class :Prepare test data");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After class : clear test data");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before Test :Open db connection");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After Test : close db connection");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Before suite : smoke testing");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("After suite : Generating Report");
  }

}
