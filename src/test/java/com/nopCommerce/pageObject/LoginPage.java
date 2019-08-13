package com.nopCommerce.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "Email")
	WebElement Emailbox;

	@FindBy(id = "Password")
	WebElement Passwordbox;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnClick;

	@FindBy(linkText = "Logout")
	WebElement lnkLogout;

	public void setEmail(String email) {

		Emailbox.sendKeys(email);
	}

	public void setPassword(String password) {

		Passwordbox.sendKeys(password);
	}

	public void submit() {
		btnClick.click();
	}

	public void logout() {
		lnkLogout.click();

	}

}
