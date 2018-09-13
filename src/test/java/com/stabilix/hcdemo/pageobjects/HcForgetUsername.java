package com.stabilix.hcdemo.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.stabilix.hcdemo.commoncode;

public class HcForgetUsername  extends commoncode{
	
	@FindBy(how=How.ID,using="email")
	@CacheLookup
	private WebElement emailid;
	
	@FindBy(how=How.ID,using="felix-widget-button-")
	@CacheLookup
	private WebElement submit;
	
	@FindBy(how=How.ID,using="felix-widget-button-btnNewUser")
	@CacheLookup
	private WebElement close;


	public WebElement getemail()
	
	{
		return emailid;
	}
	
	public HcForgetUsername() {
		//this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	

	public void mailSubmission() throws Throwable
	
	{   emailid.clear();
		emailid.sendKeys("arun.r@stabilix.com");
		Thread.sleep(1000);
		submit.click();
	}

}
