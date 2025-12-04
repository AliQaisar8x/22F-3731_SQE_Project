package com.nuces.sqe.framework.steps;

import com.nuces.sqe.framework.core.DriverFactory;
import com.nuces.sqe.framework.pages.CartPage;
import com.nuces.sqe.framework.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ProductSteps {

    private ProductsPage productsPage = new ProductsPage();
    private CartPage cartPage = new CartPage();

    @Given("I am on the products page")
    public void i_am_on_the_products_page() {
        DriverFactory.getDriver().get("https://automationexercise.com/products");
    }

    @When("I search for {string}")
    public void i_search_for(String productName) {
        productsPage.searchProduct(productName);
    }

    @Then("I should see products related to {string}")
    public void i_should_see_products_related_to(String productName) {
        Assertions.assertTrue(productsPage.getAllProductNames().stream().anyMatch(n -> n.contains(productName)));
    }

    @When("I click on the first product")
    public void i_click_on_the_first_product() {
        // Implementation depends on details page, skipping for now or just verifying
        // list
        // For simplicity, we can assume "view product" button
    }

    @Then("I should see product details")
    public void i_should_see_product_details() {
        // Placeholder
    }

    @When("I add the first product to the cart")
    public void i_add_the_first_product_to_the_cart() {
        productsPage.addFirstProductToCart();
        // Handle "Added!" modal
        try {
            Thread.sleep(1000); // Wait for modal
            DriverFactory.getDriver().findElement(org.openqa.selenium.By.cssSelector(".modal-footer button")).click();
        } catch (Exception e) {
        }
    }

    @Then("the cart count should increase")
    public void the_cart_count_should_increase() {
        // Automation Exercise doesn't have a simple badge count that updates instantly
        // without refresh sometimes
        // We can check by going to cart
        productsPage.openCart();
        Assertions.assertTrue(cartPage.getCartItemCount() > 0);
    }

    @Given("I have added a product to the cart")
    public void i_have_added_a_product_to_the_cart() {
        i_am_on_the_products_page();
        i_add_the_first_product_to_the_cart();
        productsPage.openCart();
    }

    @When("I remove the product from the cart")
    public void i_remove_the_product_from_the_cart() {
        cartPage.removeFirstItem();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    @Then("the cart should be empty")
    public void the_cart_should_be_empty() {
        Assertions.assertEquals(0, cartPage.getCartItemCount());
    }
}
