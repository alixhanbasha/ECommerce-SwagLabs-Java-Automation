@Login
@Regression
Feature: Swag Labs login screen

  @Login:1 @Sanity
  Scenario: As a user of Swag Labs, Brandon want to login to the app
    Given Brandon is a user of Swag Labs
    When  He logs in using correct credentials
    Then  He can view the Inventory page

  @Login:2
  Scenario: As a user of Swag Labs, Jimmy cannot login
    Given Jimmy is a user of Swag Labs
    When  He logs in using incorrect credentials
    Then  He can see an error message