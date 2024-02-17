Feature: Login feature

  Background:
    Given User should be on the login page
  @login @sanity
  Scenario: User should able to login with valid credentials
    When User enter "standard_user" on the username filed
    And User enter "secret_sauce" on the password filed
    And User click on the login button
    Then User should navigate to product page

  @negative @login
  Scenario: User should not be able to login with an invalid password
    When User enter "standard_user" on the username filed
    And User enter "secret_s" on the password filed
    And User click on the login button
    Then User should see "Epic sadface: Username and password do not match any user in this service" error message

  @negative @login
  Scenario: User should not be able to login without username
    When User enter "secret_sauce" on the password filed
    And User click on the login button
    Then User should see "Epic sadface: Username is required" error message

  @negative @login
  Scenario: User should not be able to login without password
    When User enter "standard_user" on the username filed
    And User click on the login button
    Then User should see "Epic sadface: Password is required" error message

  @negative @login
  Scenario: User should not be able to login with an invalid username
    When User enter "standard_us" on the username filed
    And User enter "secret_sauce" on the password filed
    And User click on the login button
    Then User should see "Epic sadface: Username and password do not match any user in this service" error message

  @negative @login
  Scenario: User should not be able to login with an invalid username and password
    When User enter "standard_us" on the username filed
    And User enter "secret_sau" on the password filed
    And User click on the login button
    Then User should see "Epic sadface: Usernam and password do not match any user in this service" error message

  @negative @login
  Scenario: User should not be able to login without username and password
    When User click on the login button
    Then User should see "Epic sadface: Username is required" error message

  @negative @login @regression
  Scenario Outline: User should not be able to login with invalid credentials
    When User enter <username> on the username filed
    And User enter <password> on the password filed
    And User click on the login button
    Then User should see <error> error message
    Examples:
      | username        | password       | error                                                                      |
      | "standard_user" | "secret_s"     | "Epic sadface: Username and password do not match any user in this service"|
      | ""              | "secret_sauce" | "Epic sadface: Username is required"|
      | "standard_user" | ""             | "Epic sadface: Password is required"|
      | "standard_"     | "secret_sauce" | "Epic sadface: Username and password do not match any user in this service"|
      | "standard_us"   | "secret_s"     | "Epic sadface: Username and password do not match any user in this service"|
      | ""              | ""             | "Epic sadface: Username is required"|
