package com.bdd.pages;

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

	// indentify the webelement locators
	@FindBy(id = "Email")
	public WebElement emailtxt;
	@FindBy(id = "Password")
	public WebElement passwordtxt;
	@FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")
	public WebElement loginbtn;
	@FindBy(className = "validation-summary-errors")
	public WebElement emptyLoginError;
	@FindBy(className = "field-validation-error")
	public WebElement invalidEmailErrorMsg;
	@FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[1]/div/ul/li")
	public WebElement nocustomerFoundErrorMsg;

	// Page Object Methods

	public void enterEmail(String email) {
		emailtxt.sendKeys(email);
	}

	public void enterPassword(String pass) {
		passwordtxt.sendKeys(pass);
	}

	public void clickLoginButton() {
		loginbtn.click();
	}

	public String getEmptyLoginError() {
		return emptyLoginError.getText();
	}
	public String getInvalidEmailError() {
		return invalidEmailErrorMsg.getText();
	}
	
	public String getNoCustomerFoundError() {
		return nocustomerFoundErrorMsg.getText();
	}
}
