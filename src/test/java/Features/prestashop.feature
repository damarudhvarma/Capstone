Feature: PrestaShop User Shopping Flow

  Scenario: User signs up successfully
    Given User launches Prestashop application
    When User clicks on Sign In
    And User clicks on Create Your Account
    And User selects gender as "Mr"
    And User enters first name "Damarudh"
    And User enters last name "Varma"
    And User enters email "damarudh@test.com"
    And User enters password "Demo@123"
    And User accepts checkboxes
    And User clicks on Create Account
    Then User account should be created successfully


  Scenario: User signs in successfully
    Given User launches Prestashop application
    When User logs in with email "damarudh@test.com" and password "Demo@123"
    Then User should be logged in successfully


  Scenario: User searches for a product
    Given User is logged into Prestashop
    When User clicks on All Products
    And User searches for product "frame"
    Then Product should be displayed in search results


  Scenario: User adds product to cart
    Given User is viewing product details page
    When User clicks Add To Cart
    Then Product should be added to cart successfully


  Scenario: User proceeds to checkout
    Given Product is available in cart
    When User clicks Proceed To Checkout
    Then Checkout page should be displayed


  Scenario Outline: User places order successfully
    Given User is on checkout page
    When User enters shipping first name "<fname>"
    And User enters shipping last name "<lname>"
    And User adds address "<address>"
    And User enters postcode "<postcode>"
    And User enters city "<city>"
    And User clicks Continue Address
    And User clicks Continue To Payment
    And User selects payment mode "<payment>"
    And User confirms the order
    Then Order should be placed successfully

    Examples:
      | fname    | lname | address           | postcode | city      | payment |
      | Damarudh | Varma | Hyderabad Colony  | 90001    | California| bank    |
