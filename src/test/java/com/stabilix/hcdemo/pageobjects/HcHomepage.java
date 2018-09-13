package com.stabilix.hcdemo.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.stabilix.hcdemo.commoncode;





public class HcHomepage extends commoncode  {
	
	//-----------@WebElement ---------Home page locators declaration...........
	
	@FindBy(how=How.XPATH, using="//a[3]/span[2]")
	@CacheLookup
	private WebElement viewOrEditPhr;
	//By viewOrEditPhr =By.id("responsivehcform_label_viewhr");
	//"#responsivehcform_0_1865451969614248 > span.btn-cards-text"
	//id=responsivehcform_label_viewhr
	
	@FindBy(how=How.CSS,using="span.profile-name")
	@CacheLookup
	private WebElement userprofileName;
	
	@FindBy(how=How.CSS,using="div.line-text.word-wrap")
	@CacheLookup
	private WebElement healthsummary;
	
	@FindBy(how=How.XPATH,using="//div[@id='recenthealthrecords']/div/a[2]/div")
	@CacheLookup
	private WebElement healthccda;
	
	
	@FindBy(how=How.ID,using="felix-widget-button-b1")
	@CacheLookup
	private WebElement ccdaclose;
	
	public WebElement getUserprofileName()
	{
		return userprofileName;
	}
	
	
	public HcHomepage() {
		//this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public HcHealthRecord clickon_viewOrEditPhr () throws Throwable
	{   
        Thread.sleep(8000);
		
        System.out.println(" Entered into home page");
		//click on the health record link of the landing page
        
      //  driver.findElement(By.xpath("//a[3]/span[2]")).click();

		viewOrEditPhr.click();
		 test.log(Status.INFO,"Clicked on the View or Edit Phr section");
		return new HcHealthRecord();
		
	}
	
	public WebElement gethealthsummary()
	{
		
		return healthsummary;
		
	}
	
	public WebElement gethealthccda()
	{
		
		return healthccda;
	}
	
	public WebElement getccdaclose()
	{
		
		return ccdaclose;
	}
	
}
