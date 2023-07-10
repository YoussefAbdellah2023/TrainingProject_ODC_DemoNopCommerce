@smoke
Feature:  currencies

  Scenario: select currencies
    When user select Euro currency
    And  check the Euro symbol is shown on the products
