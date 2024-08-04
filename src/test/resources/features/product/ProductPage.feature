# don't forget to read the readme.md for more info
@ProductPage
Feature: The Product page
  As a user of Swag Labs
  I can see a more detailed view of a product I like by accessing its product page
  and then I can decide if I want to add it to my cart

  @ProductPage:1
  Scenario Outline: As a user of Swag Labs, Peter can view the product he likes from the Product page
    Given Peter has logged in
    And   He can view the Inventory page
    When  He selects the product "<merch>"
    And   He is redirected to the product page
    Examples:
      | merch                             |
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |

  @ProductPage:2
  Scenario Outline: As a user of Swag Labs, Tonny can add a product to the cart from the details of a product
    Given Tonny has logged in
    And   He can view the Inventory page
    When  He selects the product "<merch>"
    And   He is redirected to the product page
    Then  He adds the "<merch>" to the cart
    Examples:
      | merch                             |
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |

  Rule: The one where the user tries to access the product page without logging in
    @ProductPage:3 @NegativePath
    Scenario: Darleen tries to access the inventory page without being logged in
      Given Darleen navigates to the Product page without logging in
      Then  She should be redirected to the login screen
      And   She can see the error message "You can only access '/inventory-item.html' when you are logged in."