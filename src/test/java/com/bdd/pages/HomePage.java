package com.bdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Log in")
	private WebElement loginLink;
	@FindBy(linkText = "Register")
	private WebElement registerLink;

	public void clickLoginLink() {
		loginLink.click();
	}
	
	public void clickRegisterLink() {
		registerLink.click();
	}
}
