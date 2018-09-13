package com.stabilix.hcdemo.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.stabilix.hcdemo.commoncode;
//import com.stabilix.pageobjects.common.



public class login extends commoncode{

//-----------------    @locator declaration ---------------------------------------
	
	
//By viewOrEditPhr =By.id("responsivehcform_label_viewhr");
//By username= By.id("j_username");
//By password=By.id("j_password");
//By submit=By.xpath("//button[@type='button']");
//By answerpopcontinue=By.id("felix-widget-button-Continue");
	
//By answer1= By.id("secAnswer1");
//By answer2= By.id("secAnswer2");




	
//----------------------@WebElement -locator declaration for login------------------------------//
	


	
	@FindBy(how = How.ID, using = "j_username")
	@CacheLookup
	public WebElement username;
	
	@FindBy(how=How.ID,using="j_password")
	@CacheLookup
	public WebElement password; 
	
	
	@FindBy(how=How.ID,using= "felix-widget-button-btnSignIn")
	@CacheLookup
	public WebElement submit;
	
	
	@FindBy(how=How.ID,using= "felix-widget-button-Continue")
	@CacheLookup
	public WebElement answerpopcontinue;
	
	
	@FindBy(how=How.ID,using= "secAnswer1")
	@CacheLookup
	public WebElement answer1;
	
	
	@FindBy(how=How.ID,using= "secAnswer2")
	@CacheLookup
	public WebElement answer2;
	
	@FindBy(how=How.ID,using="felix-widget-button-btnSaveAns")
	@CacheLookup
	public WebElement answerSubmit;
	
	@FindBy(how=How.CSS,using="b")
	@CacheLookup
	private WebElement invalidLoginError_label;
	
	
	@FindBy(how=How.CSS,using="p.strong")
	@CacheLookup
	private WebElement invalidAnswer_label;
	
	@FindBy(how=How.ID,using="felix-widget-button-btnClose1")
	@CacheLookup
	private WebElement answerPopButton_close;
	
	
	
	/*@FindBy(id= "felix-widget-button-btnClose1")
	private WebElement c; */
	
	//----------------------@WebElement -locator declaration for New Registration------------------------------//
	
	@FindBy(how=How.ID,using="registrationDTO.userName")
	@CacheLookup
	private WebElement newusername;
	
	@FindBy(how=How.ID,using="registrationDTO.email")
	@CacheLookup
	private WebElement newemailid;
	
	
	@FindBy(how=How.ID,using="registrationDTO.passWord")
	@CacheLookup
	private WebElement newpassword;
	
	@FindBy(how=How.ID,using="registrationDTO.conPassword")
	@CacheLookup
	private WebElement newconpassword;
	
	@FindBy(how=How.XPATH,using="//div[@id='registrationDiv']/div[2]/div/div[5]/label/span[2]")
	@CacheLookup
	private WebElement iagree;
	
	@FindBy(how=How.ID,using="felix-widget-button-btnSaveReg")
	@CacheLookup
	private WebElement signup;

	@FindBy(how=How.CSS,using="div.popover-content")
	@CacheLookup
	private WebElement usernameverifypopover;
	
	@FindBy(how=How.ID,using="forgotusernameId")
	@CacheLookup
	private WebElement forgetusername;
	
	@FindBy(how=How.ID,using="forgotpasswordId")
	@CacheLookup
	private WebElement forgetpassword;


	//glyphicon glyphicon-exclamation-sign text-danger
	
	//glyphicon glyphicon glyphicon-ok text-success
	//assertEquals("Username already exists.", driver.findElement(By.cssSelector("div.popover-content")).getText());


public login() {
	//this.driver = driver;
	PageFactory.initElements(driver, this);
	
}

public WebElement getInvalidLoginErrorLabel()
{
	return invalidLoginError_label;
}

public WebElement getInvalidAnswerLabel()
{
	return invalidAnswer_label;
}

public WebElement getAnswerPopButtonClose()
{
	return answerPopButton_close;
}


public WebElement getforgetusername()
{
	return forgetusername;
}

public WebElement getforgetpassword()
{
	return forgetpassword;
}


public HcForgetUsername forgetUsernameEmailSubmit()
{
	
	getforgetusername().click();
	
	return new HcForgetUsername();
	
}

public HcForgetPassword forgetPasswordEmailSubmit()
{
	
	getforgetpassword().click();
	return new HcForgetPassword();
}

	public void loginToHc(String uname, String pword) throws Throwable 
	{
	
		Thread.sleep(3000);
		username.clear();
	    username.sendKeys(uname);
        password.sendKeys(pword);
        submit.click();
    }
	
	public void answeringSecurityQuestion(String answsera,String answserb) throws Throwable
	{
		

	        Thread.sleep(3000);
	        
	        answerpopcontinue.click();
	        
		    answer1.clear();
	        answer1.sendKeys(answsera);
	        
	        Thread.sleep(1000);
	     
	        answer2.clear();
		    answer2.sendKeys(answserb);
	        
	      
		    
	        answerSubmit.click();
       // driver.switchTo().alert();

			//driver.findElement(answer2).click();
	        //answer2.click();
	        
	       // return new Hchomepage();
			
	}

}
