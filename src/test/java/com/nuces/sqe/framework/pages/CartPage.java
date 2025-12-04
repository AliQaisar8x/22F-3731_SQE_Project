package com.nuces.sqe.framework.pages;

import com.nuces.sqe.framework.core.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    private final WebDriver driver;

    @FindBy(css = "#cart_info_table tbody tr")
    private List<WebElement> cartRows;

    @FindBy(css = ".check_out")
    private WebElement proceedToCheckoutBtn;

    @FindBy(css = "a[href='/delete_quantity/1']")
    private WebElement deleteItemBtn;

    public CartPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    public boolean isLoaded() {
        return driver.getCurrentUrl().contains("view_cart");
    }

    public int getCartItemCount() {
        return cartRows.size();
    }

    public void proceedToCheckout() {
        proceedToCheckoutBtn.click();
    }

    public void removeFirstItem() {
        if (deleteItemBtn.isDisplayed()) {
            deleteItemBtn.click();
        }
    }
}
