package com.stabilix.hcdemo;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class hcDataProvider  

{
	
	
	        @DataProvider(name="InvalidLoginData")
			public static  Object[][] getinvalidLoginData() throws Exception
			{
			
	        	
	        	Object values[][]=getTableArray("D:\\workspace\\NewHCAutomation\\Testdata.xlsx", 0);
			
			   /*File src= new File("D:\\workspace\\NewHCAutomation\\Testdata.xls");
			
			 Workbook wb= Workbook.getWorkbook(src);
			 
			 //String[] values= new String[2];
			 
			 Object[][] values= new Object[3][2];
			 
			 values[0][0]= wb.getSheet(0).getCell(0, 1).getContents();
			 values[0][1]=wb.getSheet(0).getCell(1,1).getContents();*/
					
			 return values;
			   
			
					
			}
			
	        
	        @DataProvider(name="ValidLoginData")
			public static  Object[][] getvalidLoginData() throws Exception
			{
			
	        	
	        	Object values[][]=getTableArray("D:\\workspace\\NewHCAutomation\\Testdata.xlsx", 1);
			
			   /*File src= new File("D:\\workspace\\NewHCAutomation\\Testdata.xls");
			
			 Workbook wb= Workbook.getWorkbook(src);
			 
			 //String[] values= new String[2];
			 
			 Object[][] values= new Object[3][2];
			 
			 values[0][0]= wb.getSheet(0).getCell(0, 1).getContents();
			 values[0][1]=wb.getSheet(0).getCell(1,1).getContents();*/
					
			 return values;
			   
			
					
			}
	        
	        
	       

public static Object[][] getTableArray(String xlFilePath, int sheetNum) throws Exception
{
		
		   
		  // File src= new File("D:/workspace/NewHCAutomation/Testdata.xlsx");
		   System.out.println("File accessed");
		  FileInputStream file= new FileInputStream(new File(xlFilePath));
		 
		   
		   XSSFWorkbook wb = new XSSFWorkbook (file);
		   XSSFSheet ws= wb.getSheetAt(sheetNum);
		   
		 
		   int totalrows= ws.getLastRowNum();
		   int totalcols= ws.getRow(totalrows).getLastCellNum();
		   System.out.println("The last row  "+totalrows+ ""+"The last col  "+totalcols );
		   Object[][] values= new Object[totalrows][totalcols];
		    
		   DataFormatter formatter = new DataFormatter(); //creating formatter using the default local
		 
			
		      for(int i=0;i<totalrows; i++)
			  {
		    	  
		    	  for(int j=0;j<totalcols;j++)
		    	  {
			   values[i][j] = formatter.formatCellValue(ws.getRow(i+1).getCell(j)); 
			
		    	  }
			  
			  }
		 
		 /*   XSSFRow row = ws.getRow(0);
		    XSSFCell cell = row.getCell(1);
		    if (cell.getCellType()==cell.CELL_TYPE_STRING )*/
		   
		   
		    file.close();
		    return values;
		
       
    }  



public static Object[][] fetchPatientdata(String xlFilePath, int sheetNum, String linkage) throws Exception 
{
	
	
	FileInputStream file = new FileInputStream(new File(xlFilePath));
	
	   XSSFWorkbook wb = new XSSFWorkbook (file);
	   XSSFSheet ws= wb.getSheetAt(sheetNum);
	   Object[][] values= new Object[1][4];
	   
	   int i;
	   
	   if(linkage.equalsIgnoreCase("Newlinkage"))
	   {
		   i=1;
		   
	   }
	   else
	   {
		   i=2;
	   }
	   
	   DataFormatter formatter = new DataFormatter();
	   for(int j=0;j<=3; j++)
	   {
		   values[0][j] = formatter.formatCellValue(ws.getRow(i).getCell(j)); 
	   }
	   
	
	return values;
	
}


public static Object[][] loginDetails(String xlFilePath, int sheetNum) throws Exception 
{
	
	
	FileInputStream file = new FileInputStream(new File(xlFilePath));
	
	   XSSFWorkbook wb = new XSSFWorkbook (file);
	   XSSFSheet ws= wb.getSheetAt(sheetNum);
	   Object[][] values= new Object[1][2];
	   

	   
	
	   
	   DataFormatter formatter = new DataFormatter();
	   for(int j=0;j<=1; j++)
	   {
		   values[0][j] = formatter.formatCellValue(ws.getRow(1).getCell(j)); 
	   }
	   
	
	return values;
	
}




}
