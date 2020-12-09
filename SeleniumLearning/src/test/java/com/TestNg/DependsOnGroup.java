package com.TestNg;

// we are grouping the test

import org.testng.annotations.Test;

public class DependsOnGroup {
	
	@Test(groups= {"Smoke Testing","Regression Testing"})
	  public void tc001() {
		  System.out.println("Test case 1");
	  }
	  
	  @Test(groups= {"Smoke Testing","Sanity Testing"})
	  public void tc002() {
		  System.out.println("Test case 2");
	  }
	  @Test(groups= {"Functional Testing","Retesting"})
	  public void tc003() {
		  System.out.println("Test case 3");
	  }

}
