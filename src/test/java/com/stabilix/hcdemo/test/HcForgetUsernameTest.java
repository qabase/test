package com.stabilix.hcdemo.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.stabilix.hcdemo.commoncode;
import com.stabilix.hcdemo.pageobjects.HcForgetUsername;
import com.stabilix.hcdemo.pageobjects.login;

public class HcForgetUsernameTest extends commoncode {

	HcForgetUsername forgetusername;
	login loginPage;
	
	 @BeforeClass  
	 @Parameters({"Webbrowser","url"})
	  public void startBrowser(String Webbrowser, String url)
	   {
		  //getDriver("firefox","https://nist.healthcompanion.com/HealthCompanion/phr/Home.action");
		 getDriver(Webbrowser,url);
		  //loginPage= new login();
		 
	   }
	 
	 
	 @BeforeMethod
	 public void loginIntialize()
	 {
		 loginPage= new login();
		 // loginPage = PageFactory.initElements(driver,login.class);
	 }
	  
	 
	 @Test( description= "checking forgot username")
	 public void forgotUsernameTest () throws Throwable
	 {
		 
		 forgetusername = loginPage.forgetUsernameEmailSubmit();
		 forgetusername.mailSubmission();
		 questmailLogin("arun.r@stabilix.com", "hello007@");
		 
	 }
	 
}
