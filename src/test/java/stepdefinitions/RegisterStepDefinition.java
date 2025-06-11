package stepdefinitions;

import java.util.Iterator;
import java.util.Random;

import com.bdd.pages.DashBoardPage;
import com.bdd.pages.HomePage;
import com.bdd.pages.LoginPage;
import com.bdd.pages.RegisterPage;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class RegisterStepDefinition {
	private TestContext testContext;
	private HomePage homePage;
	private RegisterPage registerPage;
	private LoginPage loginPage;
	private DashBoardPage dashBoardPage;

	public RegisterStepDefinition(TestContext context) {
		this.testContext = context;
		homePage = new HomePage(testContext.getDriver());
		registerPage = new RegisterPage(testContext.getDriver());
		loginPage = new LoginPage(testContext.getDriver());
		dashBoardPage = new DashBoardPage(testContext.getDriver());
	}

	@When("user click on register link")
	public void user_click_on_register_link() {
		homePage.clickRegisterLink();
	}

	@Then("user verify the register page title {string}")
	public void user_verify_the_register_page_title(String title) {
		String registerTitle = testContext.getDriver().getTitle();
		Assert.assertEquals(registerTitle, title);
	}

	@When("user select the male radio button")
	public void user_select_the_male_radio_button() {
		registerPage.clickGenderRadioBtn();
	}

	@When("user enter the FirstName {string}")
	public void user_enter_the_first_name(String fname) {
		registerPage.enterFirstName(fname);
	}

	@When("user enter the LastName {string}")
	public void user_enter_the_last_name(String lname) {
		registerPage.enterLastName(lname);
	}

	@Given("user enter the email address or username {string}")
	public void user_enter_the_email_address_or_username(String email) {
		String emailAddress = email +randomNum()+"@yahoo.com";
		registerPage.enterEmailAddress(emailAddress);
		testContext.getScenarioContext().setContext("username", emailAddress);
	}

	@When("user enter the password {string}")
	public void user_enter_the_password(String password) {
		registerPage.enterPassword(password);
		testContext.getScenarioContext().setContext("passcode", password);

	}

	@When("user enter the confirmpassword {string}")
	public void user_enter_the_confirmpassword(String confirmpassword) {
		registerPage.enterConfirmpassword(confirmpassword);
	}

	@When("user click on regiter button")
	public void user_click_on_regiter_button() {
		registerPage.clickRegisterButton();
	}

	@When("user click on Logout link")
	public void user_click_on_logout_link() {
		dashBoardPage.clickLogoutLink();
	}

	@When("user enter the login credetials with email and password and click Login button")
	public void user_enter_the_login_credetials_with_email_and_password_and_click_login_button() {
       homePage.clickLoginLink();
       String emailAddress = (String) testContext.getScenarioContext().getContext("username");
       loginPage.emailtxt.clear();
       loginPage.enterEmail(emailAddress);
       String password = (String) testContext.getScenarioContext().getContext("passcode");
       loginPage.passwordtxt.clear();
       loginPage.enterPassword(password);
       loginPage.clickLoginButton();
       if (dashBoardPage.logoutLink.isDisplayed()) {
    	   dashBoardPage.clickLogoutLink();
	}
       
	}

	@Then("verify the homePage title")
	public void verify_the_home_page_title() {
//		Assert.assertEquals( testContext.getDriver().getTitle(), "Demo Web Shop");
	}
	
	public String randomNum() {
		Random random = new Random();
		int number = random.nextInt(100000);
		String randomNm = String.format("%05d", number);
		return randomNm;
	}

}
