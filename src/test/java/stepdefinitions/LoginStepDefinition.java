package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.bdd.pages.DashBoardPage;
import com.bdd.pages.HomePage;
import com.bdd.pages.LoginPage;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
    private TestContext testContext;
    private HomePage homePage;
    private LoginPage loginPage;
    private DashBoardPage dashBoardPage;

    // Constructor to initialize pages and TestContext
    public LoginStepDefinition(TestContext context) {
        this.testContext = context;
        homePage = new HomePage(testContext.getDriver());
        loginPage = new LoginPage(testContext.getDriver());
        dashBoardPage = new DashBoardPage(testContext.getDriver());
    }

    // Step to navigate to the specified URL
    @Given("user navigate to site url {string}")
    public void user_navigate_to_site_url(String url) {
        System.out.println("Navigating to URL: " + url);
        testContext.getDriver().get(url);
    }

    // Step to click on the login link on the home page
    @When("user click on login link")
    public void user_click_on_login_link() {
        homePage.clickLoginLink();
    }

    // Step to verify the page title after navigating to the login page
    @Then("verify login page title {string}")
    public void verify_login_page_title(String loginTitle) {
        String title = testContext.getDriver().getTitle();
        Assert.assertEquals("Login page title mismatch", loginTitle, title);
    }

    // Step to enter the email address in the login form
    @When("user enter the email address {string}")
    public void user_enter_the_email_address(String email) {
        loginPage.enterEmail(email);
    }

    // Step to enter the password in the login form
    @When("user enter password {string}")
    public void user_enter_password(String pass) {
        loginPage.enterPassword(pass);
    }

    // Step to click the login button after entering credentials
    @When("user click on login button")
    public void user_click_on_login_button() {
        loginPage.clickLoginButton();
    }

    // Step to verify the logout link is visible after login
    @Then("verify the logout link visible")
    public void verify_the_logout_link_visible() {
        Assert.assertTrue("Logout link not visible", dashBoardPage.logoutLink.isDisplayed());
        dashBoardPage.clickLogoutLink();
    }

    // Step to verify the login error message when invalid credentials are provided
    @Then("verify the login error message")
    public void verify_the_login_error_message() {
        String loginError = testContext.getDriver().findElement(By.className("field-validation-error")).getText();
        Assert.assertTrue("Error message not found", loginError.contains("Please enter a valid email address."));
    }

    // Step to verify the error message for empty credentials
    @Then("verify the login error message for empty credential")
    public void verify_the_login_error_message_for_empty_credential() {
        String loginError = testContext.getDriver().findElement(By.className("validation-summary-errors")).getText();
        Assert.assertTrue("Error message for empty credentials not found", loginError.contains("Login was unsuccessful. Please correct the errors and try again."));
    }

    // Step to log in with multiple credentials
    @When("user login to site with multiple credentials")
    public void user_login_to_site_with_multiple_credentials(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> userData = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> map : userData) {
            homePage.clickLoginLink();
            loginPage.enterEmail(map.get("username"));
            loginPage.enterPassword(map.get("password"));
            loginPage.clickLoginButton();
            dashBoardPage.clickLogoutLink();  // Logout after each login attempt
        }
    }

    // Step to log in with multiple invalid test credentials and verify error messages
    @When("user login to application with multiple invalid test credentials")
    public void user_login_to_application_with_multiple_invalid_test_credentials(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> userData = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> map : userData) {
            homePage.clickLoginLink();
            enterUserName(map.get("username"));
            enterPassword(map.get("password"));
            loginPage.clickLoginButton();

            switch (map.get("type")) {
                case "empty":
                    loginPage.emailtxt.clear();
                    loginPage.passwordtxt.clear();
                    loginPage.clickLoginButton();
                    Assert.assertTrue("Empty login error message not found", loginPage.getEmptyLoginError().contains(map.get("errormessage")));
                    break;
                case "incorrectemail":
                    loginPage.passwordtxt.clear();
                    loginPage.clickLoginButton();
                    Assert.assertTrue("Invalid email error message not found", loginPage.getInvalidEmailError().contains(map.get("errormessage")));
                    break;
                case "incorrectLoginCredentials":
                    Assert.assertTrue("No customer found error message not found", loginPage.getNoCustomerFoundError().contains(map.get("errormessage")));
                    break;
                case "incorrectPassword":
                    Assert.assertTrue("No customer found error message not found", loginPage.getNoCustomerFoundError().contains(map.get("errormessage")));
                    break;
                default:
                    System.out.println("No Matching CaseFound");
            }
        }
    }

    // Helper method to handle username entry
    public void enterUserName(String username) {
        username = (username == null) ? "" : username;
        loginPage.enterEmail(username);
    }

    // Helper method to handle password entry
    public void enterPassword(String password) {
        password = (password == null) ? "" : password;
        loginPage.enterPassword(password);
    }
}
