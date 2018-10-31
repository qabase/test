package com.stabilix.hcdemo;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {

	
	public static String createScreenShot(WebDriver driver, String screenshotname) 
	{
		
	
		
		
		 String	image="D:/workspace/NewHCAutomation/test-output/"+screenshotname+".png";
    	 File  dest= new File(image);
		
		try {
			TakesScreenshot t= (TakesScreenshot)driver;
			 
			File source= t.getScreenshotAs(OutputType.FILE);
			
			//image=".\\Screenshotsoutput\\"+screenshotname+".png";
		//image=	"D:\\workspace\\NewHCAutomation\\Screenshotsoutput\\"+screenshotname+".png";
		//	image= "D:/workspace/NewHCAutomation/Screenshotsoutput/"+screenshotname+".png";
			//image= "C:/Users/arun/Desktop/Screenshotsoutput/"+screenshotname+".png";
			
			
			
			FileUtils.copyFile(source,dest);
		
			//D:\workspace\NewHCAutomation\Screenshotsoutput\
		
		    } catch (Exception e) {
		 	// TODO Auto-generated catch block
			System.out.println(" The error message"+ e.getMessage());
		    }
	
		
		return dest.getPath();
	
	}
}
