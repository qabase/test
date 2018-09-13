package com.stabilix.hcdemo.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.stabilix.hcdemo.commoncode;

public class DrLogin extends commoncode {
	
	@FindBy(how=How.ID, using="UserName" )
	@CacheLookup
	WebElement username;
	
	@FindBy(how=How.ID, using="Password" )
	@CacheLookup 
	WebElement password;
	
	@FindBy(how=How.CSS, using="input[type=\"button\"]" )
	@CacheLookup
	WebElement login;
	
	public DrLogin()
	{
		PageFactory.initElements(driver, this);
	}

	public DrHomePage dr_login(String uname, String pword) throws Throwable
	{
		username.clear();
		username.sendKeys(uname);
		password.clear();
		password.sendKeys(pword);
		login.click();
		Thread.sleep(15000);
		
		return new DrHomePage ();
		
		
	}


}
