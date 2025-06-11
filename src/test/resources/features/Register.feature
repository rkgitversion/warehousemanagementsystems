Feature: register functionality

  Background: 
    Given user navigate to site url "https://demowebshop.tricentis.com/"

  @register @smoke  @HBP-4333
  Scenario: verify registration and login
    When user click on register link
    Then user verify the register page title "Demo Web Shop. Register"
    When user select the male radio button
    When user enter the FirstName "kudikala"
    And user enter the LastName "ramesh"
    And user enter the email address or username "testsome"
    When user enter the password "testing124"
    And user enter the confirmpassword "testing124"
    When user click on regiter button
    And user click on Logout link
    And user click on login link
    When user enter the login credetials with email and password and click Login button

