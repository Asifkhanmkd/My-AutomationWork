package com.nopCommerce.testcases;

import java.io.IOException;

import org.testng.Assert;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.nopCommerce.pageObject.LoginPage;

public class TC_LoginTest1 extends Base {
	
	
	
	@Test
	public void LoginTest() throws InterruptedException, IOException {
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(email);
		log.info("Email Entered");
		lp.setPassword(password);
		log.info("Password Entered");
		lp.submit();
		log.info("Submit button clicked");
		
		
	/*	Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
		
		log.info("Page Title Validated");
		lp.logout();
		log.info("Sucessfully Logged out");*/
		String actual_Title= driver.getTitle();
		log.info(actual_Title);
		String Expected_Title="Dashboard / nopCommerce administration";
		
		if(actual_Title.equals(Expected_Title))  
		{
		 Assert.assertTrue(true);	
		 log.info("Test Passed");	
			
		}
		else
		{
	    takeScreenshot("LoginTest");
		Assert.assertTrue(false);	
		
		log.info("Test failed");
			
		}	
		
		
	}

}
