package com.stabilix.hcdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class commoncode {
	
	
	protected static WebDriver driver;
	protected static String browser;
	protected static String patientidreg;
	//protected static String patientidlinkmember;
	
	public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
	

	@FindBy(how=How.CSS,using="td.subject")
	@CacheLookup
	private WebElement message;
	
	@FindBy(how=How.LINK_TEXT,using="Please click here to complete your account recovery.")
	@CacheLookup
	private WebElement link;
	
	@FindBy(how=How.ID,using="rcmloginuser")
	@CacheLookup
	private  WebElement questmail;
	
	@FindBy(how=How.ID,using="rcmloginpwd")
	@CacheLookup
	private WebElement questpassword;
	
	
	@FindBy(how=How.ID,using="button mainaction")
	@CacheLookup
	private WebElement submit;
	
	
	
	protected static WebDriver getDriver(String Browser, String url)
	
	{
		browser=Browser;
		
	
		
		if (driver==null)
		{  
		   if(	browser.equalsIgnoreCase("firefox"))
			//if(browser=="firefox")
			{
				
				System.setProperty("webdriver.gecko.driver","E:\\ARUNR_BACKUP\\selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
				driver=new FirefoxDriver();
				
			}
		   
		   
		   if(	browser.equalsIgnoreCase("chrome"))
				//if(browser=="firefox")
				{
					
			        System.setProperty("webdriver.chrome.driver", "D:\\ARUNR_BACKUP\\selenium\\chromedriver_win32chromedriver.exe");
					driver=new ChromeDriver();
					
				}
			   
		   
		}
		
		
		
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 
			//URL url= new URL("https://nist.healthcompanion.com/HealthCompanion/phr/Home.action");
			//driver.navigate().to(url);
			
		 driver.get(url);

		 return driver;
		
		
	}
	
	protected  void closeDriver()
	{  
		driver.quit();
		driver=null;
		
	}
	
	public void questmailLogin(String username, String password) throws Throwable
	{
		driver.navigate().to("https://questmail.futurequest.net/");
		
		//WebElement questmail = driver.findElement(By.id("rcmloginuser"));
		
		questmail.sendKeys(username);

		//WebElement questpassword = driver.findElement(By.id("rcmloginpwd"));
		
		questpassword.sendKeys(password);
		submit.click();
		Thread.sleep(3000);
		message.click();
		Thread.sleep(1000);
		link.click();
		Thread.sleep(1000);
		
		
		
		
	}
	

     
    @BeforeSuite
    public void setUp()
    {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/html/MyOwnReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
         
        extent.setSystemInfo("OS", "Windows7");
        extent.setSystemInfo("Host Name", "Arun");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Arun R");
        

         
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("AutomationTesting.in Demo Report");
        htmlReporter.config().setReportName("My Own Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
     //htmlReporter.config().setAutoCreateRelativePathMedia(true);
        
    }
     
    @AfterMethod
    public void getResult(ITestResult result)
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
            test.fail(result.getThrowable());
            
            try
            {
           String image= Utility.createScreenShot(driver, result.getName()); 
           test.addScreenCaptureFromPath(image);
          // test.lo
        // test.log(Status.FAIL, "The screenshot is here:" + image1);
           
            }
            
            catch(Exception e)
            {
            	System.out.println(" The error message"+ e.getMessage());
                 test.log(Status.INFO,e.getMessage());
            }
           
           
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
        else
        {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }
     
    @AfterSuite
    public void tearDown() throws Throwable
    {
    	
        extent.flush();
        
       // driver.get(System.getProperty("user.dir") +"\\test-output\\MyOwnReport.html");
       // driver.get("D:\\workspace\\NewHCAutomation\\test-output\\MyOwnReport.html");
        driver.navigate().to("file:\\D:\\workspace\\NewHCAutomation\\test-output\\MyOwnReport.html");
        
       // D:\workspace\NewHCAutomation\test-output\MyOwnReport.html
        Thread.sleep(20000);
        this.closeDriver();
    }
	}


