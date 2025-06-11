#Author : Ramesh kudikala
Feature: This feature file verify the login functionality

  Background: 
    Given user navigate to site url "https://demowebshop.tricentis.com/"
    Then verify login page title "Demo Web Shop"
    When user click on login link
    Then verify login page title "Demo Web Shop. Login"

  @smoke @regression @sanity @login  @HBP-3123
  Scenario: verify Login functionality with valid data
    When user enter the email address "something@yahoo.com"
    And user enter password "testing123"
    When user click on login button
    Then verify the logout link visible

  @functional @regression @smoke @HBP-3125
  Scenario: verify login functionality with invalid data
    When user enter the email address "something"
    And user enter password "testing3"
    When user click on login button
    Then verify the login error message

  @regression @smoke  @HBP-3134
  Scenario: verify login functionality with empty credentials
    When user enter the email address ""
    And user enter password ""
    When user click on login button
    Then verify the login error message for empty credential

  @datadriven @smoke  @HBP-4322
  Scenario Outline: verify Login functionality with multiple login credentials
    When user enter the email address "<username>"
    And user enter password "<password>"
    When user click on login button
    Then verify the logout link visible

    Examples: 
      | username                     | password   |
      | rktest083@yahoo.com          | testing123 |
      | sriramreddy00219@hotmail.com | testing123 |
      | abhisheknagula123@gmail.com  | testing123 |
      | rajashkera567@test.com       | Gmail@112  |
      
      


