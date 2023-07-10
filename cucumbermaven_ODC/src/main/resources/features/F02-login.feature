@smoke
Feature: login-user could login with valid data

  Scenario: user could login with valid email and password
    Given user go to login page
    When user login with valid data
    And  user press on login button
    Then user login to the system successfully

  Scenario: user could login with invalid email and password
    Given user go to login page
    When user login with invalid data
    And  user press on login button
    Then user could not login to the system



