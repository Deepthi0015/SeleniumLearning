package com.TestNg;

import org.testng.annotations.Test;

public class PriorityTestNg {
	
	 @Test(priority=2)
	  public void tc001() {
		  System.out.println("Test case 1");
	  }
	  
	  @Test(priority=3)
	  public void tc002() {
		  System.out.println("Test case 2");
	  }
	  @Test(priority=1)
	  public void tc003() {
		  System.out.println("Test case 3");
	  }

}
