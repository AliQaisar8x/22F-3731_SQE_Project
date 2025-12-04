Feature: Form Submission

  Background:
    Given I am on the contact page

  Scenario: Fill contact form
    When I fill the contact form with "Test User", "test@example.com", "Subject", "Message"
    And I submit the form
    Then I should see a success message

  Scenario: Submit invalid data
    When I fill the contact form with "", "", "", ""
    And I submit the form
    Then I should see validation errors
