@PrestaShop @Auth
Feature: Account Registration and Sign In Validation
  As a customer of PrestaShop
  I want to register an account and validate the sign-in form
  So that I can access my user profile securely
 
  Background:
    Given the user navigates to the PrestaShop homepage
 
  @Smoke @Lifecycle
  Scenario: End-to-end user registration and authentication lifecycle
    When the user navigates to the registration page
    And the user submits valid, unique registration details
    Then a new account should be successfully created
    When the user signs out from their account
    Then the user should be redirected to the landing page as a guest
    When the user signs back in with the newly created credentials
    Then the user dashboard should display their account name
 
  @DataDriven @SignInOnly
  Scenario Outline: Validate sign-in form credentials
    Given the user navigates to the login page
    When the user enters the email "<email>"
    And the user enters the password "<password>"
    And the user clicks the sign in button
 
    Examples:
 
      | email                | password       |
      | active_user@demo.com | ValidSecure123 |
      | wronguser@demo.com   | Pass123!       |
      | active_user@demo.com | WrongPassword  |
      | invalid_email_format | Pass123!       |