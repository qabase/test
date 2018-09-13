package com.stabilix.hcdemo.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.stabilix.hcdemo.commoncode;

public class DrHomePage extends commoncode{
	
	String strCurrentWindow;
	Object [] strAllWindows;
	
	@FindBy(how=How.ID, using="lnkCreatePatient" )
	@CacheLookup
	WebElement newpatientlink;
	
	
	@FindBy(how=How.ID, using="LastName" )
	@CacheLookup
	WebElement lastname;
	
	
	@FindBy(how=How.ID, using="FirstName" )
	@CacheLookup
	WebElement firstname;
	
	@FindBy(how=How.ID, using="felix-widget-calendar-DateOfBirth-input" )
	@CacheLookup
	WebElement dob;
	
	@FindBy(how=How.ID, using="Gender" )
	@CacheLookup
	WebElement Gender;
	
	@FindBy(how=How.ID, using="Ethinicity" )
	@CacheLookup
	WebElement Ethinicity;
	
	@FindBy(how=How.ID, using="Language" )
	@CacheLookup
	WebElement Language;
	
	
	@FindBy(how=How.ID, using="Email" )
	@CacheLookup
	WebElement emailid;
	
	@FindBy(how=How.ID, using="PatientId")
	@CacheLookup
	WebElement PatientId;
	
	@FindBy(how=How.ID, using="lnkCreateClosePatient-button")
	@CacheLookup
	WebElement Patientclose;
	
	@FindBy(how=How.XPATH, using="//span[@id='lnkCreateVisit']/span")
	@CacheLookup
	WebElement createexam;
	
	@FindBy(how=How.ID, using="ModalityCode")
	@CacheLookup
	WebElement ModalityCode;
	
	@FindBy(how=How.ID, using="PhysicianId")
	@CacheLookup
	WebElement physician;
	
	@FindBy(how=How.ID, using="felix-widget-calendar-VisitDateStr-btn")
	@CacheLookup
	WebElement datepicker;
	
	@FindBy(how=How.ID, using="ActionButton1-button")
	@CacheLookup
	WebElement examsave;
	
	@FindBy(how=How.CSS , using="a[title=\"Click at end of exam or visit to print Clinical Summary or send to PHR\"]")
	@CacheLookup
	WebElement endexam;
	
	@FindBy(how=How.LINK_TEXT, using="Logout")
	@CacheLookup
	WebElement logout;
	
	public DrHomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void addPatient(String lname, String fname, String dbirth, String email_id) throws Throwable
	{
		Thread.sleep(10000);
		newpatientlink.click();
		Thread.sleep(10000);
		
		//********** Patient creation****************code below
		
		lastname.clear();
		lastname.sendKeys(lname);
		firstname.clear();
		firstname.sendKeys(fname);
		dob.click();
		dob.clear();
		dob.sendKeys(dbirth);
		
		new Select(Gender).selectByVisibleText("Male");
		//new Select(Ethinicity).selectByVisibleText("Hispanic or Latino");
		//new Select(Language).selectByVisibleText("English (eng)");
		
		emailid.click();
		emailid.clear();
		emailid.sendKeys(email_id);
		
		
		patientidreg= PatientId.getAttribute("Value");
		
			
		
		Patientclose.click();
		
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
		
	}

	
public void examCreation(String arg) throws Throwable
{
	
	Thread.sleep(15000);
	
	
	createexam.click();
	//driver.findElement(By.id("ModalityCode")).click();
	
	new Select(physician).selectByVisibleText("Dr. Arun Ram");

	new Select(ModalityCode).selectByVisibleText("AN - Anesthesiology");
	Thread.sleep(1000);
	datepicker.click();
	driver.findElement(By.linkText(arg)).click();
	examsave.click();
	
}

public void examend() throws Throwable
{
	
	endexam.click();
	
	Thread.sleep(6000);

	 strCurrentWindow = driver.getWindowHandle();
      strAllWindows = driver.getWindowHandles().toArray();
       
     //  for( int i=0; i<2; i++ ) 
           String strWindow = ""+strAllWindows[1];
       
           
           if( !strWindow.equals(strCurrentWindow) ) 
           
           {
           	driver.switchTo().window(strWindow);
           }
       
           
       
//WebElement examendpopup= driver.findElement(By.cssSelector("html"));
//Assert.assertTrue(examendpopup.isDisplayed());
Thread.sleep(3000);
driver.close();
driver.switchTo().window(strCurrentWindow);
Thread.sleep(1000);
//driver.close();

driver.findElement(By.linkText("Logout")).click();

logout.click();
Thread.sleep(3000);

}
	

	
	}
