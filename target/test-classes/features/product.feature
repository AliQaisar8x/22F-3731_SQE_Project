Feature: Product Management

  Background:
    Given I am on the products page

  Scenario: Search for a product
    When I search for "Dress"
    Then I should see products related to "Dress"

  Scenario: Open product details page
    When I click on the first product
    Then I should see product details

  Scenario: Add product to cart
    When I add the first product to the cart
    Then the cart count should increase

  Scenario: Remove product from cart
    Given I have added a product to the cart
    When I remove the product from the cart
    Then the cart should be empty
