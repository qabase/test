package com.stabilix.hcdemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stabilix.hcdemo.commoncode;

public class HcRoamingLogin extends commoncode{

	
	
	@FindBy(how=How.ID,using="ccdRepDto.firstName")
	@CacheLookup
	private WebElement memberfirstname;
	
	
	@FindBy(how=How.ID,using="ccdRepDto.lastName")
	@CacheLookup
	private WebElement memberlastname;
	
	@FindBy(how=How.ID,using="felix-widget-calendar-ccdRepDto.dob-input")
	@CacheLookup
	private WebElement memberdob;
	
	
	@FindBy(how=How.ID,using="felix-widget-button-btnSearch")
	@CacheLookup
	private WebElement membersearch;
	
	@FindBy(how=How.XPATH ,using="//div[@id='termsDiv']/section/div/div[2]/div/label/span[2]")
	@CacheLookup
	private WebElement termsagree;
	
	
	@FindBy(how=How.ID,using="providerPin")
	@CacheLookup
	private WebElement providerpin;
	
	@FindBy(how=How.ID,using="felix-widget-button-verifyPIN")
	@CacheLookup
	private WebElement verifypin;
	
	@FindBy(how=How.CSS,using="span.label_radio")
	@CacheLookup
	private WebElement yesclick;
	
	@FindBy(how=How.ID,using="confirmRegistration.userName")
	@CacheLookup
	private WebElement regusername;

	
	@FindBy(how=How.ID,using="confirmRegistration.passWord")
	@CacheLookup
	private WebElement regpassword;
	
	@FindBy(how=How.ID,using="confirmRegistration.conPassword")
	@CacheLookup
	private WebElement conpassword;
	
	
	@FindBy(how=How.ID,using="felix-widget-button-btnSaveReg")
	@CacheLookup
	private WebElement firstregsavebutton;
	
	

	@FindBy(how=How.ID,using="confirmRegistration.secQuestionSelect1")
	@CacheLookup
	private WebElement secquestion1;
	

	@FindBy(how=How.ID,using="confirmRegistration.secAnswer1")
	@CacheLookup
	private WebElement secanswer1;
	

	@FindBy(how=How.ID,using="confirmRegistration.secQuestionSelect2")
	@CacheLookup
	private WebElement secquestion2;
	
	@FindBy(how=How.ID,using="confirmRegistration.secAnswer2")
	@CacheLookup
	private WebElement secanswer2;
	
	@FindBy(how=How.ID,using="confirmRegistration.secQuestionSelect3")
	@CacheLookup
	private WebElement secquestion3;
	
	@FindBy(how=How.ID,using="confirmRegistration.secAnswer3")
	@CacheLookup
	private WebElement secanswer3;
	
	
	@FindBy(how=How.XPATH,using="//div[2]/label/span[2]")
	@CacheLookup
	private WebElement mobileselection;
	
	
	public HcRoamingLogin()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void searchPatient(String fname, String lname, String DOB) throws Throwable
	{
		Thread.sleep(6000);
		memberfirstname.clear();
		memberfirstname.sendKeys(fname);
        memberlastname.clear();
		memberlastname.sendKeys(lname);
	    memberdob.clear();
	    memberdob.sendKeys(DOB);
		
	    membersearch.click();
		Thread.sleep(6000);
		termsagree.click();
		
	}
	
	public void verifyPin() throws Throwable
	
	{
		Thread.sleep(2000);
        providerpin.clear();

		
		String idpin=  patientidreg;
		providerpin.sendKeys(idpin.substring(2)); 
		Thread.sleep(3000);
		verifypin.click();
	
		
		
	}
	
	public HcHomepage patientRegistration(String uname, String pword) throws Throwable
	{
		Thread.sleep(6000);
         yesclick.click();
        Thread.sleep(3000);
        regusername.clear();
        regusername.sendKeys(uname);
        regpassword.clear();
        regpassword.sendKeys(pword);
        conpassword.clear();
        conpassword.sendKeys(pword);
    	Thread.sleep(3000);
    	
    	//driver.findElement(By.xpath("//div[2]/label/span[2]")).click();

    	mobileselection.click();
		

    	firstregsavebutton.click();
		Thread.sleep(10000);
		
		
		new Select(secquestion1).selectByVisibleText("What was the first car you drove or owned (make and model)?");
		secanswer1.clear();
		secanswer1.sendKeys("1");
		
		new Select(secquestion2).selectByVisibleText("What was your favorite class in high school?");
		secanswer2.clear();
		secanswer2.sendKeys("1");
		
		new Select(secquestion3).selectByVisibleText("What was your first pet's name?");
		secanswer3.clear();
		secanswer3.sendKeys("1");
		
		Thread.sleep(10000);
		
		
		WebDriverWait wait = new WebDriverWait(driver, 10 );
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("felix-widget-button-btnSignUP")));
		//or try: WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("someid")));
		element.click();
		//driver.findElement(By.id("felix-widget-button-btnSignUP")).click();
		Thread.sleep(10000);
        
		return new HcHomepage();
        
		
		
	}
	
	}

