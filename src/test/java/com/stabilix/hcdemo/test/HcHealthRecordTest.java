package com.stabilix.hcdemo.test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.stabilix.hcdemo.commoncode;
import com.stabilix.hcdemo.hcDataProvider;
import com.stabilix.hcdemo.pageobjects.HcHealthRecord;
import com.stabilix.hcdemo.pageobjects.HcHomepage;
import com.stabilix.hcdemo.pageobjects.login;

public class HcHealthRecordTest extends commoncode {
	
	login loginPage;
	HcHomepage hchomepage1;
	HcHealthRecord HchealthRecord1;
	
	 @BeforeClass  
	 @Parameters({"Webbrowser","url"})
	  public void startBrowser(@Optional("test")  String Webbrowser, String url)
	   {
		  //getDriver("firefox","https://nist.healthcompanion.com/HealthCompanion/phr/Home.action");
		 getDriver(Webbrowser,url);
		  loginPage= new login();
	   }
	
	@Test(priority=1, description="checking problem add", dataProvider="ValidLoginData", dataProviderClass=hcDataProvider.class)
	public void problemAddVerification(String uname, String pword) throws Throwable 
	{
		
		//System.out.println("The last value  "+s); 
		test=extent.createTest("Checking the Problem is added properly");
		loginPage.loginToHc(uname,pword);// Login to Health Companion
		 test.log(Status.INFO,"Trying Log into the application");
		loginPage.answeringSecurityQuestion("1", "1");
		 test.log(Status.INFO,"Answering the security question with correct answers");
	    Thread.sleep(5000);
	    hchomepage1= new HcHomepage();
	    HchealthRecord1= hchomepage1.clickon_viewOrEditPhr();
	    HchealthRecord1.addproblem();
	    
	  //  HchealthRecord HchealthRecord1= hchomepage1.clickon_viewOrEditPhr();
	   // HchealthRecord1.addproblem();
	    
	    WebElement prob=  HchealthRecord1.getproblemVerification();
		Assert.assertTrue(prob.isDisplayed());
		 test.log(Status.PASS,"Problem added verified");
		
		  
		
	}
	
	/*@Test( DependsOnMethod= "test")
	public void problemEditVerification()
	{
		
	}*/

}
