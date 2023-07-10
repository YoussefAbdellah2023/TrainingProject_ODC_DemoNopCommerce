@smoke
Feature: registration-user could register with valid data

  Scenario: user could create account with all valid data

    And  user go to url
    And  user press on register icon
    And  user fill all required data
    And  user press on register button
    Then  registration done successfully with success message is displayed

