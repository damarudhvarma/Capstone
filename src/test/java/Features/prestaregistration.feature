@PrestaShop @Regression
Feature: User Lifecycle and Purchase Journey
  As a new customer of PrestaShop
  I want to register an account, log in, manage my profile, and place an order
  So that I can complete a full end-to-end shopping experience successfully

Background:
    Given the user navigates to the PrestaShop homepage

 @Smoke @Auth
 Scenario: Successful user account setup and authentication lifecycle
    When the user navigates to the registration page
    And the user submits valid, unique registration details
    Then a new account should be successfully created
    When the user signs out from their account
    Then the user should be redirected to the landing page as a guest
    When the user signs back in with the newly created credentials
    Then the user dashboard should display their account name
    
    