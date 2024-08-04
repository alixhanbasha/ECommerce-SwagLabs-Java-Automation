@Inventory
Feature: Inventory page for Swag Labs

  @Inventory:1
  Scenario Outline: As a user of Swag Labs, Tonny can view the details of a product
    Given Tonny has logged in
    And   He can view the Inventory page
    When  He selects the product "<merch>"
    Then  He is redirected to the product page
    Examples:
      | merch                             |
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |

  @Inventory:2
  Scenario Outline: As a user of Swag Labs, Jeff can add a product to the cart
    Given Jeff has logged in
    And   He can view the Inventory page
    When  He adds the "<merch>" to the cart
    Examples:
      | merch                             |
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |

  @Inventory:3
  Scenario: As a user of Swag Labs, Bruce can add multiple products to cart from the inventory page
    Given Bruce has logged in
    And   He can view the Inventory page
    Then  He adds the following products to the cart
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |

    Rule: The one where the user tries to access the inventory page without logging in
      @Inventory:4 @NegativePath
      Scenario: Elliot tries to access the inventory page without being logged in
        Given Elliot navigates to the Inventory page without logging in
        Then  He should be redirected to the login screen
        And   He can see the error message "You can only access '/inventory.html' when you are logged in."