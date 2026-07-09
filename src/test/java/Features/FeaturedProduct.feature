@prestashop @checkoutFlow
Feature: Featured Product Checkout Flow
 
  Scenario: User purchases a featured product successfully
 
    Given user is logged into the PrestaShop application
    When user navigates to featured products
    And user selects and customizes a product
    And user adds the product to the cart
    And user proceeds through checkout and shipping
    Then checkout page should be displayed successfully