#@smoke
Feature: registration-user
#@smoke
  Scenario: user could create account with all valid data
    When  user press on register icon
    And  user fill valid data
    And  user press on register button
    Then  registration done successfully with success message is displayed


#  @smoke
  Scenario Outline: user could not create account with all invalid and empty data
    When  user press on register icon
    And  user fill invalid and empty "<firstname>", "<lastname>", "<email>", "<password>", and "<confirmpassword>"
    And  user press on register button
    Then  registration error message is displayed

    Examples:
      | firstname | lastname   |      email          | password | confirmpassword|
      |           |            |                     |          |                |
      |           | abdellah   | youssef@gmail.com   | abc123   |    abc123      |
      | youssef   |            | youssef@gmail.com   | abc123   |    abc123      |
      | youssef   | abdellah   |                     | abc123   |    abc123      |
      | youssef   | abdellah   | youssef@gmail.com   |          |    abc123      |
      | youssef   | abdellah   | youssef@gmail.com   | abc123   |                |
      | 123       | abdellah   | youssef@gmail.com   | abc123   |    abc123      |
      | youssef   | 123        | youssef@gmail.com   | abc123   |    abc123      |
      | youssef   | abdellah   | youssef@.com        | abc123   |    abc123      |
      | youssef   | abdellah   | youssef@gmail.com   | abc123   |    abc123      |
      | youssef   | abdellah   | youssef@gmail       | abc123   |    abc123      |
      | youssef   | abdellah   | youssef@gmail.com   | abc1     |    abc12       |







