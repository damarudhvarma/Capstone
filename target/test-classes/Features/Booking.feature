Feature: PrestaShop User Shopping Flow

Scenario Outline: user login search and buys a product
Given User Signups
And user clicks on All featured products
And search for the product
And lands on product page and add to cart
And procced to checkout
And User enters shipping names "<fname>" and "<lname>"
And User adds address "<address>"
And User enters postcode "<postcode>" and "<city>"
And User clicks Continue Address
And User clicks Continue To Payment
And User selects payment mode "<payment>"
And User confirms the order
Then Order should be placed successfully

Examples:
      | fname    | lname | address           | postcode | city      | payment |
      | Damarudh | Varma | Hyderabad Colony  | 90001    | California| cod    |
      

Scenario: User order booking verification
Given user goes to my orders section
And clicks on order details
Then check with order detials

  