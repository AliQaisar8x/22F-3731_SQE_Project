Feature: Login Functionality

  Background:
    Given I am on the login page

  Scenario: Login with valid credentials
    When I enter username "test_user@example.com" and password "password123"
    And I click the login button
    Then I should be logged in successfully

  Scenario: Login with invalid credentials
    When I enter username "invalid@example.com" and password "wrong"
    And I click the login button
    Then I should see an error message

  Scenario: Login with empty fields
    When I enter username "" and password ""
    And I click the login button
    Then I should remain on the login page

  Scenario: Logout test
    Given I am logged in with "test_user@example.com" and "password123"
    When I click the logout button
    Then I should be redirected to the login page
