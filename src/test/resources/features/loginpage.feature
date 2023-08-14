Feature: Login functionality for opencart ecommerce website

  As a user i should be able to
  login and access the account
  related features.

  Background:
    Given User is on the opencart login page

  Scenario: User is able to login with valid input parameters
    Given User entered valid username and password
    When User clicks on login button
    Then User should be logged in successfully

  Scenario Outline: User is not able to login with invalid or empty credentials
    Given User entered invalid "<username>" and "<password>"
    When User clicks on login button
    Then Error message should be displayed as "<error_message>"

    Examples:
      | username          | password        | error_message                                         |
      |                   | abcdefg12       | Warning: No match for E-Mail Address and/or Password. |
      | cucumber@test.com | invalidpassword | Warning: No match for E-Mail Address and/or Password. |
      | invalid@email.com | cucumber        | Warning: No match for E-Mail Address and/or Password. |


