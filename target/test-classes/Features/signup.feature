Feature: PrestaShop User Signingup

  Scenario Outline: User signs up successfully
    Given User launches Prestashop application
    When User clicks on Sign In
    And User enters first name "<fname>"
    And User enters last name "<lname>"
    And User enters email "<email>"
    And User enters password "<password>"
    And User accepts checkboxes
    And User clicks on Create Account
    Then User account should be created successfully
 
Examples:

|fname|lname|email|password|
|Damarudh|Varma|damarudh@test.com|Test@1234$|
|abc|Def|abd@test.com|Test@12$|


Scenario: Registration with mandatory fields empty
  Given User navigates to registration page
  When User submits registration form without entering mandatory details
  Then Registration validation message should be displayed