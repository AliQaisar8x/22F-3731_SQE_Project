Feature: UI Validation

  Scenario: Verify title and URLs
    Given I am on the home page
    Then the page title should be "Automation Exercise"
    And the URL should contain "automationexercise"

  Scenario: Verify broken links or images
    Given I am on the home page
    Then I should not see any broken images
