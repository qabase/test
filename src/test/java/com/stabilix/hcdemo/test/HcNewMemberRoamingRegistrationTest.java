package com.stabilix.hcdemo.test;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.stabilix.hcdemo.commoncode;
import com.stabilix.hcdemo.hcDataProvider;
import com.stabilix.hcdemo.pageobjects.DrHomePage;
import com.stabilix.hcdemo.pageobjects.DrLogin;
import com.stabilix.hcdemo.pageobjects.HcHomepage;
import com.stabilix.hcdemo.pageobjects.HcRoamingLogin;

public class HcNewMemberRoamingRegistrationTest extends commoncode {
	
	
	DrLogin Drloginpage;
	DrHomePage Drhomepage;
	HcRoamingLogin Hcroaminglogin;
	HcHomepage hchomepage;
	
	WebElement userprofile;
	
	static String  lname;
	static String fname;
	static String dbirth;
	static  String email_id;
	
	//hcDataProvider dataprovider1;
     @BeforeClass  
	 @Parameters({"Webbrowser","drurl"})
	  public void startBrowser(String Webbrowser, String url)
	   {
		  //getDriver("firefox","https://nist.healthcompanion.com/HealthCompanion/phr/Home.action");
		   getDriver(Webbrowser,url);
		  Drloginpage= new DrLogin();
	   }
	 
	@BeforeMethod
	 public void patient_Setup() throws Throwable
	 { 
		 Object[][] loginvalues= hcDataProvider.loginDetails("D:\\workspace\\NewHCAutomation\\Testdata.xlsx",2);
		 String uname=loginvalues[0][0].toString();
		 String pword=loginvalues[0][1].toString();
		 Drhomepage= Drloginpage.dr_login(uname, pword);
		 Object[][] patientvalues=hcDataProvider.fetchPatientdata("D:\\workspace\\NewHCAutomation\\Testdata.xlsx", 3,"Newlinkage");
		 
		 lname=patientvalues[0][0].toString();
		 fname=patientvalues[0][1].toString();
		 dbirth=patientvalues[0][2].toString();
		 email_id=patientvalues[0][3].toString();
		 
		 System.out.println(" ******************************* ");
		 System.out.println(" Date of birth....."+ dbirth);
		 System.out.println(" email id...."+ email_id);
		 
		 Drhomepage.addPatient(lname, fname, dbirth, email_id);
		 Drhomepage.examCreation("8");
		 Drhomepage.examend();
		 
	 }
	 
	 
	 
	
	
	/* @Test
	 public void loadHcUrl() 
	 {
		 String url ="https://nist.healthcompanion.com/HealthCompanion/roamingportal/RoamingPortal.action?providerInterfaceCode=2&emrId=DR&mailLink=y#loginPage";
		 driver.get(url); 
	 }*/
	
	@Test(priority=1, description= "ehr-HC Linkage by new new member registration" )
    public void newMemberRoamingRegistration() throws Throwable
	{   
		
	   	// driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 //driver.manage().window().maximize();
		 
		 String url ="https://nist.healthcompanion.com/HealthCompanion/roamingportal/RoamingPortal.action?providerInterfaceCode=2&emrId=DR&mailLink=y#loginPage";
		 driver.get(url); 
		 
		 Hcroaminglogin= new HcRoamingLogin();
		 Hcroaminglogin.searchPatient(fname, lname, dbirth);
		 Hcroaminglogin.verifyPin();
		 
		 Object[][] loginvalues= hcDataProvider.loginDetails("D:\\workspace\\NewHCAutomation\\Testdata.xlsx",4);
		 String uname=loginvalues[0][0].toString();
		 String pword=loginvalues[0][1].toString();
		 hchomepage= Hcroaminglogin.patientRegistration(uname,pword);
		 
		 userprofile=hchomepage.getUserprofileName();
			
		    Assert.assertTrue(userprofile.isDisplayed());
	}

}
