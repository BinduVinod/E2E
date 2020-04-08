Feature: Search and place order for Vegetables
@test
  Scenario: Search item and validate
    Given User is in Greencart landing page
    When user searched for Cucumber vegetable
    Then "Cucumber" results are displayed
@test
  Scenario Outline: Search and add item to checkout and verify
    Given User is in Greencart landing page
    When user searched for <item> vegetable
    And add vegetable to cart
    And user proceeded to checkout page to purchase
    Then selected <item> vegetable are displayed in check out page
    Examples:
      | item     |
      | Carrot   |
      | Beetroot |
@test1
  Scenario: Add multiple items to checkout
    Given User is in Greencart landing page
    When user added the vegetables in cart
      | vegetable |
      | Brocolli  |
      | Beetroot  |
      | Carrot    |
    And user proceeded to checkout page to purchase
    And user applied the promocode and verify
      | promocode          |
      | rahulshettyacademy |
    And user placed the order and navigated to country page
    And user selected "India" from the dropdown and accept the terms and conditions
    Then I should be redirected to the home page


