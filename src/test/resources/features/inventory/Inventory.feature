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
#      | Sauce Labs Bike Light             |
#      | Sauce Labs Bolt T-Shirt           |
#      | Sauce Labs Fleece Jacket          |
#      | Sauce Labs Onesie                 |
#      | Test.allTheThings() T-Shirt (Red) |

  @Inventory:3
  Scenario Outline: As a user of Swag Labs, Bruce can add multiple products to cart from the inventory page
    Given Bruce has logged in
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