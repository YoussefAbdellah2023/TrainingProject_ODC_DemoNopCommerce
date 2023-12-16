
  Feature: User Could Search For Any Products
    Scenario: user could search using product name
      When user go to url search
      And user write product name in search

      Scenario: user could search for product using sku
        When user search with SKU

