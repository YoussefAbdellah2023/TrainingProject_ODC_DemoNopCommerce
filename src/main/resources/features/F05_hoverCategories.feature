
Feature: F06_Hovering | user could hover on any option and select different categories

  Scenario: logged user could hover on Apparel option and select clothes category
    When user hover on Apparel option and select clothes category
    Then user move successfully to the clothes page

#  Scenario: logged user could hover on Apparel option and select clothes category
#    Given user hover on the selected category and select one of the sub categories

