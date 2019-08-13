package com.nopCommerce.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage {

	WebDriver driver;

	public AddNewCustomerPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='wrapper']/div[2]/div/ul/li[4]/a/i[2]")
	WebElement drp_Customer;

	@FindBy(xpath = "//a[@href='/Admin/Customer/List']")
	WebElement link_addCust;

	@FindBy(xpath = "//a[@class='btn bg-blue']")
	WebElement btn_addNew;

	@FindBy(xpath = "//input[@id='Email']")
	WebElement txt_Email;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement txt_Password;

	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement txt_FirstName;

	@FindBy(xpath = "//input[@id='LastName']")
	WebElement txt_LastName;

	@FindBy(xpath = "//input[@id='Gender_Male']")
	WebElement Radio_M;

	@FindBy(xpath = "//input[@id='Gender_Female']")
	WebElement Radio_F;

	@FindBy(id = "DateOfBirth")
	WebElement box_DOB;

	@FindBy(id="Company")
	WebElement txt_Company;

	@FindBy(xpath = "//input[@id='IsTaxExempt']")
	WebElement chk_TaxExmpt;

	@FindBy(xpath = "//div[@class='k-multiselect-wrap k-floatwrap']")
	WebElement multiSel_CustRole;

	@FindBy(xpath = "//span[@class='k-icon k-delete']")
	WebElement del_defRole;

	@FindBy(xpath = "//li[contains(text(),'Administrators')]")
	WebElement sel_Admin;
	@FindBy(xpath = "//li[contains(text(),'Forum Moderators')]")
	WebElement sel_Moderator;
	@FindBy(xpath = "//li[contains(text(),'Registered')]")
	WebElement sel_Registered;
	@FindBy(xpath = "//li[contains(text(),'Guests')]")
	WebElement sel_Guest;
	@FindBy(xpath = "//li[contains(text(),'Vendors')]")
	WebElement sel_Vendor;

	@FindBy(xpath = "//select[@id='VendorId']")
	WebElement sel_VendID;

	@FindBy(xpath = "//textarea[@id='AdminComment']")
	WebElement txt_Admin;

	@FindBy(xpath = "//button[@name='save']")
	WebElement btn_CustSave;

	            // *************Action Methods*************\\

	public void ClickCustDropdown() {
		drp_Customer.click();
	}

	public void ClickCustlnk() {
		link_addCust.click();
	}

	public void clickCustBtn() {
		btn_addNew.click();
	}

	public void enterEmail(String email) {
		txt_Email.sendKeys(email);
	}

	public void enterPassword(String pswd) {
		txt_Password.sendKeys(pswd);
	}

	public void enterFirstName(String fname) {
		txt_FirstName.sendKeys(fname);
	}

	public void enterLastName(String lname) {
		txt_LastName.sendKeys(lname);
	}

	public void selectGender(char g) {
		if(g=='M') {
		Radio_M.click();
		}
		else 
		{
		 Radio_F.click();	
		}
			
	}

	

	public void enterDOB(String dob) {
		box_DOB.sendKeys(dob);
	}

	public void enterCompanyName(String company) {
		txt_Company.sendKeys(company);
	}

	public void chickTaxExempt() {
		chk_TaxExmpt.click();
	}

	public void deleteDefaultRole() {

		del_defRole.click();

	}

	public void selectCustRole(String role) {
		//multiSel_CustRole.click();
		
		WebElement item;
		if (role=="Administrators") {
			item = sel_Admin;
			JavascriptExecutor js = (JavascriptExecutor)driver;
			 js.executeScript("arguments[0].click();", item);
			
		}
		else if(role=="Forum Moderators") {
			item = sel_Moderator;
			JavascriptExecutor js = (JavascriptExecutor)driver;
			 js.executeScript("arguments[0].click();", item);
			}
		else if(role=="Registered") {
			item=sel_Registered;
			JavascriptExecutor js = (JavascriptExecutor)driver;
			 js.executeScript("arguments[0].click();", item);
			}
		else if(role=="Guests") {
			
		  item=sel_Guest;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", item);
	}
	}	
	//WebElement item;
		/*switch (role) {
		case "Administrators":
			item = sel_Admin;break;
		case "Forum Moderators":
			item = sel_Moderator;break;
		case "Registered":
			item = sel_Registered;break;
		case "Guests":
			item = sel_Guest;break;
		default:
			item = sel_Guest;
		}*/
        /* JavascriptExecutor js = (JavascriptExecutor)driver;
 		 js.executeScript("arguments[0].click();", item);*/
     
	

	public void SelectMangerID(String managId) {

		Select drop = new Select(sel_VendID);
		drop.selectByVisibleText(managId);
	}

	public void adminComment(String comnt) {
		txt_Admin.sendKeys(comnt);

	}

	public void custSave() {
		btn_CustSave.click();

	}

}
