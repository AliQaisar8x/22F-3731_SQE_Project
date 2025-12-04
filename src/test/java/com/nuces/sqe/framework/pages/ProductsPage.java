package com.nuces.sqe.framework.pages;

import com.nuces.sqe.framework.core.DriverFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage {

    private final WebDriver driver;

    @FindBy(css = "a[href='/products']")
    private WebElement productsLink;

    @FindBy(css = ".features_items .col-sm-4")
    private List<WebElement> productItems;

    @FindBy(css = ".productinfo p")
    private List<WebElement> productNames;

    @FindBy(id = "search_product")
    private WebElement searchInput;

    @FindBy(id = "submit_search")
    private WebElement searchButton;

    @FindBy(css = ".add-to-cart")
    private List<WebElement> addToCartButtons;

    @FindBy(css = "a[href='/view_cart']")
    private WebElement cartLink;

    public ProductsPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void navigateToProducts() {
        productsLink.click();
    }

    public boolean isLoaded() {
        return driver.getCurrentUrl().contains("products");
    }

    public List<String> getAllProductNames() {
        return productNames.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    @Step("Search for product: {0}")
    public void searchProduct(String productName) {
        searchInput.clear();
        searchInput.sendKeys(productName);
        searchButton.click();
    }

    @Step("Add first product to cart")
    public void addFirstProductToCart() {
        if (!addToCartButtons.isEmpty()) {
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();",
                    addToCartButtons.get(0));
        }
    }

    @Step("Open cart")
    public void openCart() {
        cartLink.click();
    }
}
