package com.stabilix.hcdemo.test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.stabilix.hcdemo.commoncode;
import com.stabilix.hcdemo.pageobjects.HcHomepage;

public class HcHomePageTest extends commoncode{
	
	
	HcHomepage page1;
	WebElement summary;
	WebElement ccda;
	WebElement ccdaclose;
	
	
	@BeforeMethod
	public void init() throws Throwable
	{
		page1=new HcHomepage();
		Thread.sleep(1000);
		summary= page1.gethealthsummary();
		ccda=page1.gethealthccda();
		
		
	}
	
	
	
  @Test(description="Testing summary and CCDA is ported from provider")
  public void summaryCcdVerification() throws Throwable
  {
	  
	  test= extent.createTest("Testing summary and CCDA is ported from provider");
	  Assert.assertTrue(summary.isDisplayed());
	  test.log(Status.PASS,"Summary is viewed");
	
	  Assert.assertTrue(ccda.isDisplayed());
	  test.log(Status.PASS,"CCDA is viewed");
	  
	    ccda.click();
	    Thread.sleep(1000);
	    ccdaclose= page1.getccdaclose();
	    if (ccdaclose.isDisplayed())
	    {
		ccdaclose.click();
	test.log(Status.INFO,"CCDA is closed");
	    }
	    
	    
  }
  
  @AfterClass
  public void closeBrowser()
  
  {    
	  //closeDriver();
  }
}
