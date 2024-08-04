@Login
@Regression
Feature: Swag Labs login screen

  @Login:PositivePath
  Rule: The one where the user can login

    @Login:1 @Sanity
    Scenario: As a user of Swag Labs, Brandon want to login to the app
      Given Brandon is a user of Swag Labs
      When  He logs in using correct credentials
      Then  He can view the Inventory page

  @Login:NegativePath
  Rule: The one where the user cannot login

    @Login:2
    Scenario: As a user of Swag Labs, Jimmy cannot login
      Given Jimmy is a user of Swag Labs
      When  He logs in using incorrect credentials
      Then  He can see an error message

    @Login:3 @wip
    Scenario: As a user of Swag Labs, Ronnie cannot login
      Given Ronnie is a user of Swag Labs
      When  He tries to login only using his username
      Then  He can see the error message "Password is required"

    @Login:4 @wip
    Scenario: As a user of Swag Labs, Helena cannot login
      Given Helena is a user of Swag Labs
      When  She tries to login only using her password
      Then  She can see the error message "Username is required"

    @Login:5 @wip
    Scenario: As a user of Swag Labs, Rob cannot login
      Given Rob is a user of Swag Labs
      When  He tries to login without credentials
      Then  He can see the error message "Username is required"