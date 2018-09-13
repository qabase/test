package com.stabilix.hcdemo.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.stabilix.hcdemo.commoncode;

public class HcHealthRecord extends commoncode{
	
	//-----------@WebElement ---------Home page locators declaration...........
	
	@FindBy(how=How.XPATH, using="//div[2]/div/div/h2")
	@CacheLookup
	private WebElement problemCard;
	
	
	@FindBy(how=How.ID, using="felix-widget-button-addNewProblem")
	@CacheLookup
	private WebElement problemNewButton;
	
	
	@FindBy(how=How.ID, using="diagnosisName")
	@CacheLookup
	private WebElement problemName;
	
	
	@FindBy(how=How.ID, using="felix-widget-button-addProblem")
	@CacheLookup
	private WebElement problemAdd;
	
	@FindBy(how=How.CLASS_NAME, using="Test1")
	@CacheLookup
	private WebElement problemVerification;
	
	
	public HcHealthRecord() {
		//this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void addproblem() throws Throwable
	
	{
		 Thread.sleep(6000);
		 problemCard.click();
		 test.log(Status.INFO,"Clicked on the problem card");
		 Thread.sleep(6000);
		 problemNewButton.click();
		 test.log(Status.INFO,"Clicked on the problem Add-New button");
		 
		 
		 if (browser=="firefox")
				//  The below code doesn't work in chrome
			 problemName.clear();
			 problemName.sendKeys("Test1");
			 problemAdd.click();
			 test.log(Status.INFO,"Clicked on the problem submit button");
			 
			// driver.findElement(By.xpath("//div[2]/div/div/h2")).click();

			
	}
	
	public WebElement getproblemVerification()
	{
		return problemVerification;
	}
   
		
	 
		

}
