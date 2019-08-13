package com.nopCommerce.testcases;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.nopCommerce.pageObject.AddNewCustomerPage;
import com.nopCommerce.pageObject.LoginPage;

public class TC_AddNewCustomerTest extends Base {
	
	@Test
	public void addNewCustomerTest() throws InterruptedException, IOException {
	
		LoginPage lp=new LoginPage(driver);
		AddNewCustomerPage add= new AddNewCustomerPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.submit();
		add.ClickCustDropdown();
		log.info("Customer DropDown Linked Clicked");
		add.ClickCustlnk();
		log.info("Customer Link Clicked");
		add.clickCustBtn();
		log.info("Add new Customer button Clicked");
		//add.enterEmail("uytre@yahoo.com");
		String Email=emailGenerate()+"@yahoo.com";
	    add.enterEmail(Email);
	    log.info("Random Email Entered");
		add.enterPassword("testing1");
		log.info("Password Entered");
		add.enterFirstName("adfh");
		log.info("First Name Entered");
		add.enterLastName("poiu");
		log.info("Last Name entered");
		add.selectGender('f');
		log.info("Gender Entered");
		add.enterDOB("10/08/1990");
		log.info("Date of Birth Entered");
		add.enterCompanyName("fakecomp ltd");
		log.info("Company Name Entered");
		add.chickTaxExempt();
		log.info("Tax Exemption ChickBox Ticked");
		add.deleteDefaultRole();
		log.info("Default role deleted");
		add.selectCustRole("Registered");
		log.info("Customer role Entered");
		add.SelectMangerID("Vendor 2");
		log.info("Vendor ID selected");
		add.adminComment("Hello How r u???");
		log.info("Comment given by Admin");
		add.custSave();
		
		log.info("New customer Save button Entered to save the Record");
		String msg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
		
		//String msg=driver.findElement(By.tagName("body")).getText();
		System.out.println(msg);
		if(msg.contains("The new customer has been added successfully."))
			
		{
			Assert.assertTrue(true);
			log.info("Test passed");
		}
			else 
			
			{
			takeScreenshot("addNewCustomerTest");
				Assert.assertTrue(false);
				
				
			}
			
			
			
			
		}		
		//System.out.println(success);
		//Assert.assertEquals(success, true);
		
		//	log.info("Customer Sucessfully created");
			//Assert.assertTrue(true);
			
			
		/*else 
		
		{
			takeScreenshot("addNewCustomerTest");
			Assert.assertTrue(false);
			
			
			log.info("Add new Customer failed with screenshot attached in Extent Report");
			
		}*/
		
		
	}
	
	
	


