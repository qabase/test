package com.stabilix.hcdemo.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.stabilix.hcdemo.commoncode;

public class HcForgetPassword extends commoncode {
	
	
	@FindBy(how=How.ID,using="email")
	@CacheLookup
	private WebElement emailid;
	
	@FindBy(how=How.ID,using="felix-widget-button-btnCheckUsrnme")
	@CacheLookup
	private WebElement submit;
	
	@FindBy(how=How.ID,using="felix-widget-button-btnClose")
	@CacheLookup
	private WebElement close;
	
	

	
	
	

}
