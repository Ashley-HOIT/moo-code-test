Feature: View Contact information
  As a customer of Moo.com
  I want to view contact information for Moo
  So that I know who to contact if I have any problems

  Scenario: View Contact information via the homepage
    Given a customer navigates to the Moo.com website
    When a customer selects to view Contact information via the homepage
    Then the customer is presented with the Moo.com's contact information
