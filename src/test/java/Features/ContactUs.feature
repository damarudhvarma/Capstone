Feature: Featured Product Checkout Flow
Scenario: Submit Contact Us form successfully
    Given User is on Contact Us page
    When User enters contact email
    And User enters issue message
    And User clicks Send your message button
    Then Contact Us form should be submitted successfully