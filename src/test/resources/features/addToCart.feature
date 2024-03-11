Feature: Add to cart
  Scenario: Adding a “Monitor” Item in Cart and verifying sub total
    Given User is on amazon home page
    When Search for an item monitor
    And Adds the first item from the list
    And Open Cart from the top-right
    Then Verify that the price is identical to the product page
    And Verify that the sub total is identical to the product page