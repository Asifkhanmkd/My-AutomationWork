package com.nopCommerce.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopCommerce.pageObject.LoginPage;
import com.nopCommerce.utilities.XLUtils;

public class TC_LoginTestDDT extends Base {
	
	
@Test(dataProvider="testdata")	
public void logInTest(String userName,String password) throws InterruptedException 
{
 LoginPage lp= new LoginPage(driver);
 
  lp.setEmail(userName);
 
  lp.setPassword(password);
 
  lp.submit();
  
 
  if(driver.getTitle().equals("Dashboard / nopCommerce administration")) 
  {
	
	  Assert.assertTrue(true);
	  log.info("DataDriven Test paased");
  }
  else
  {
	  Assert.assertTrue(false);
	  log.info("DataDriven Test Failed");
	
	  
  }  
 



}	
	
	
	
	
@DataProvider(name="testdata")
public String[][] getLoginData() throws IOException {
String path= System.getProperty("user.dir")+"\\src\\test\\java\\com\\nopCommerce\\testdata\\LoginData.xlsx";
int rownum = XLUtils.getRowCount(path, "Sheet1");
int colnum= XLUtils.getCellCount(path, "Sheet1", rownum);
String [][] data=new String[rownum][colnum];

 for(int i=1;i<=rownum;i++) 
 {
	for(int j=0; j<colnum;j++) 
	{
	 data[i-1][j]= XLUtils.getCellData(path, "Sheet1", i, j);	
		
		
	}
	 
}
 
 return data;
	
}

}