Feature: user adds multiple products into cart
Scenario: Add multiple products to cart
    Given user is on home page
    When User searches product and add to cart    
    Then two products  should be present in the cart