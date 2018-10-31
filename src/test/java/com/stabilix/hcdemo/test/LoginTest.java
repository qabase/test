package com.stabilix.hcdemo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.Status;
//import com.beust.jcommander.Parameters;
import com.stabilix.hcdemo.commoncode;
import com.stabilix.hcdemo.hcDataProvider;
import com.stabilix.hcdemo.pageobjects.HcHomepage;
import com.stabilix.hcdemo.pageobjects.login;



public class LoginTest extends commoncode{
	
	
	// login loginPage = PageFactory.initElements(driver,login.class);
	 
	 
  login loginPage;
  HcHomepage hchomepage;
  
  String  errorLogin;
  WebElement errorAnswer;
  WebElement answerPop;
  WebElement userprofile;


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
	  
	 @Test(priority=1, description="checking invalid login", dataProvider="InvalidLoginData", dataProviderClass=hcDataProvider.class)
	   public void checkInvalidLogin(String uname, String pword) throws Throwable 
	  {
		test= extent.createTest("checking invalid login");
	        
		    loginPage.loginToHc(uname,pword);// Login to Health Companion
		    test.log(Status.INFO,"Logging into the application");
		    
		    Thread.sleep(5000);
		    AssertJUnit.assertEquals("Invalid Username/Email or Password.", driver.findElement(By.cssSelector("b")).getText());
		    test.log(Status.PASS, "Invalid login attempt verified");		    
		 
		
		    //extent.close();
	  }

	  
	  
 @Test(priority=2, description="checking invalid answer attempt", dataProvider="ValidLoginData", dataProviderClass=hcDataProvider.class)
 //@Parameters({"username","password"})
  public void checkInvalidAnswerAttempt(String uname, String pword ) throws Throwable {
	     
	    
		 test =extent.createTest("checking invalid answer attempt");
		 
		 String answser1="1";
		 String answser2="2";
	
		 loginPage.loginToHc(uname, pword);
		 test.log(Status.INFO,"Trying Log into the application");
		 
	
		 loginPage.answeringSecurityQuestion(answser1, answser2);
		 test.log(Status.INFO,"Answering the security question with wrong answers");
	    
		 WebElement errorAnswer= loginPage.getInvalidAnswerLabel();
	    
	    // WebElement element= driver.findElement(invalidAnswer_label);
		 AssertJUnit.assertTrue(errorAnswer.isDisplayed());
		 test.log(Status.PASS,"Got the validation message for invalid answer attempt");
		 
		// WebElement answerPop= driver.findElement(answerPopButton_close );
		 
		  // button id="felix-widget-button-btnClose1" class="btn btn-button btn btn-default btn-lg" type="button" name="btnClose1" title="Close"> Close </button>
		 
		    //answerPopButton_close.click();
		 answerPop=loginPage.getAnswerPopButtonClose();
		 answerPop.click();
		 test.log(Status.INFO,"Security pop-up is closed");
		  
  } 
  
  @Test(priority=3, description="checking valid login", dataProvider="ValidLoginData", dataProviderClass=hcDataProvider.class)
  public void checkValidLogin(String uname, String pword) throws Throwable 
  { 
	  
	
		test= extent.createTest("Checking valid login");
		     String answser1="1";
			 String answser2="1";
		 loginPage.loginToHc(uname, pword);
	      test.log(Status.INFO,"Trying Log into the application");
		 
		 loginPage.answeringSecurityQuestion(answser1, answser2);
	      test.log(Status.INFO,"Answering the security question with correct answers");
	    
	    
	    Thread.sleep(10000);
	//	WebElement userprofile=driver.findElement(userprofileName);
	    hchomepage=new HcHomepage();
		userprofile=hchomepage.getUserprofileName();
		
		Boolean v= userprofile.isDisplayed();
	    AssertJUnit.assertTrue(userprofile.isDisplayed());
		test.log(Status.PASS,"Successfully logged into the application");

  }
  

  
  
/* @AfterClass
  public void closeBrowser()
  
  {    
	  closeDriver();
  }*/
  
}