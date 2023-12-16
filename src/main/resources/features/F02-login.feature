#@smoke
Feature: login-user
#  @smoke
  Scenario:  user could login with valid email and password
    Given user go to login page
    When user login with valid data
    And  user press on login button
    Then user login to the system successfully and logout


#  @smoke
  Scenario Outline: user could login with invalid email and password
    Given user go to login page
    When user login with invalid data "<email>" and "<password>"
    And  user press on login button
    Then display error message

    Examples:
      | email | password |
      |       |          |
      |youssef|          |
      |       |abc123    |
      |youssef@gmail     |abc123       |
      |youssef@gmail.com |abc          |






