Feature: PrestaShop Authentication Engine

 @Registration
Scenario: PS01 - Verify user registration using email

  Given the user is on the PrestaShop live store homepage
  When the user clicks on the Sign In link
  And the user clicks on Create Your Account button
  And the user enters valid registration details
  And the user clicks on Create Account button
  Then the account should be created successfully
  And the My Account page should be displayed

 Scenario: User Login Verification Loop with Valid Credentials
   Given the user is on the PrestaShop live store homepage
   When the user navigates to the portal sign in screen
   And user submits their registered email "pub@prestashop.com" and password "123456789"
   
@ProductSearch
Scenario: PS03 - Search Product Add To Cart And Checkout

  Given the user is on the PrestaShop live store homepage
  When the user clicks on All Featured Products
  And the user searches for product "tshirt"
  And the user selects the first searched product
  And the user adds the product to cart
  And the user proceeds to checkout
  And the user clicks checkout from cart page
  Then the personal information page should be displayed
  
 @GuestCheckout
Scenario: PS04 - Complete Guest Checkout

  Given the user is on the PrestaShop live store homepage
  When the user clicks on All Featured Products
  And the user searches for product "tshirt"
  And the user selects the first searched product
  And the user adds the product to cart
  And the user proceeds to checkout
  And the user clicks checkout from cart page
  And the user enters guest checkout details
  And the user clicks Continue
  And the user enters address details
  And the user selects shipping method
  And the user selects payment method
  Then the order should be placed successfully

  