Feature: PrestaShop User Signingup

  Scenario: User signs up successfully
    Given User launches Prestashop application
    When User clicks on Sign In
    And User enters first name "Damarudh"
    And User enters last name "Varma"
    And User enters email "damarudh@test.com"
    And User enters password "Test@1234$"
    And User accepts checkboxes
    And User clicks on Create Account
    Then User account should be created successfully
