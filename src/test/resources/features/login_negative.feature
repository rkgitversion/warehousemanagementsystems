Feature: login negative test case

  Background: 
    Given user navigate to site url "https://demowebshop.tricentis.com/"
    Then verify login page title "Demo Web Shop"

  @datatable
  Scenario: verify login functionality with multiple credentials
  When user login to site with multiple credentials
  | username            | password    |
  | something@yahoo.com | testing123  |
  | someone@yahoo.com   | testing3211 |
  
  @dataTable_negative_tc @smoke @HBP-3124
  Scenario: verify login functionality with multiple incorrect credentials
    When user login to application with mulitple invalid test credentials
      | username                | password          | type                      | errormessage                                                    |
      |                         |                   | empty                     | Login was unsuccessful. Please correct the errors and try again |
      | something               |                   | incorrectemail            | Please enter a valid email address                              |
      | somethijhkgs15@test.com | dgfsfdmnhkhks     | incorrectLoginCredentials | No customer account found                                       |
      | something@yahoo.com     | asfkhjkjghkjsdfsf | incorrectPassword         | The credentials provided are incorrect                          |
