Feature: Search UI
  As a customer of Moo.com
  I want to search for a product
  So that I can choose a design to purchase

  Scenario: Valid search returns products
    Given a customer navigates to the Moo.com website
    When the customer searches for a valid product
    Then the customer receives products based upon their search terms


  Scenario: Invalid search does not return any products
    Given a customer navigates to the Moo.com website
    When the customer searches for an invalid product
    Then the customer does not receive products based upon their search terms
