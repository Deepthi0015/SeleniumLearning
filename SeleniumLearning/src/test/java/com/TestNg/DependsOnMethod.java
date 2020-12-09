package com.TestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethod {
	
	@Test
	  public void tc001() {
		  System.out.println("Test case 1");
	  }
	  
	  @Test(dependsOnMethods="tc001")
	  public void tc002() {
		  System.out.println("Test case 2");
		  Assert.assertEquals("abc", "xyz");
	  }
	  
	  @Test(dependsOnMethods="tc002",alwaysRun=true)
	  public void tc003() {
		  System.out.println("Test case 3");
	  }

}
