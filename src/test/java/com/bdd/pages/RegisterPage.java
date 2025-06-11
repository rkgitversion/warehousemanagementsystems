package com.bdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// objects
	@FindBy(id = "gender-male")
	public WebElement genderMaleRdp;
	@FindBy(id = "FirstName")
	public WebElement firstNametxt;
	@FindBy(id = "LastName")
	public WebElement lastNameTxt;
	@FindBy(id = "Email")
	public WebElement emailtxt;
	@FindBy(id = "Password")
	public WebElement passwordTxt;
	@FindBy(id = "ConfirmPassword")
	public WebElement confirmPasswordtxt;
	@FindBy(id = "register-button")
	public WebElement registerButton;
	
	public void clickGenderRadioBtn() {
		genderMaleRdp.click();
	}
	
	public void enterFirstName(String fname) {
		firstNametxt.clear();
		firstNametxt.sendKeys(fname);
	}
	
	public void enterLastName(String lname) {
		lastNameTxt.clear();
		lastNameTxt.sendKeys(lname);
	}
	
	public void enterEmailAddress(String email) {
		emailtxt.clear();
		emailtxt.sendKeys(email);
	}
	
	public void enterPassword(String pass) {
		passwordTxt.clear();
		passwordTxt.sendKeys(pass);
	}
	public void enterConfirmpassword(String confirmPass) {
		confirmPasswordtxt.clear();
		confirmPasswordtxt.sendKeys(confirmPass);
	}
	
	public void clickRegisterButton() {
		registerButton.click();
	}
}
