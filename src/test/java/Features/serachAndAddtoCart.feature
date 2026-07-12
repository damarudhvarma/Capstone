Feature: user search and add to cart
Scenario: Add searched product to cart
    Given User is on home page to be searched
    When User searches and selects a product
    Then the searched Product should be added to shopping cart