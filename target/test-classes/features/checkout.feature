Feature: Checkout Process

  Background:
    Given I am logged in with "test_user@example.com" and "password123"
    And I have added a product to the cart
    And I am on the cart page

  Scenario: Fill checkout form
    When I proceed to checkout
    And I enter payment details "John Doe", "1234567812345678", "123", "01", "2025"
    And I confirm the order
    Then the order should be placed successfully

  Scenario: Apply wrong payment data
    When I proceed to checkout
    And I enter payment details "John Doe", "123", "123", "01", "2025"
    And I confirm the order
    Then I should see a payment error

  Scenario: Successful order placement
    When I proceed to checkout
    And I enter valid payment details
    And I confirm the order
    Then the order should be placed successfully
