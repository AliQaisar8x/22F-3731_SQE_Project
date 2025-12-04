package com.nuces.sqe.framework.pages;

import com.nuces.sqe.framework.core.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private final WebDriver driver;

    @FindBy(css = "a[href='/payment']")
    private WebElement placeOrderBtn;

    @FindBy(name = "name_on_card")
    private WebElement nameOnCard;

    @FindBy(name = "card_number")
    private WebElement cardNumber;

    @FindBy(name = "cvc")
    private WebElement cvc;

    @FindBy(name = "expiry_month")
    private WebElement expiryMonth;

    @FindBy(name = "expiry_year")
    private WebElement expiryYear;

    @FindBy(id = "submit")
    private WebElement payButton;

    @FindBy(css = ".alert-success")
    private WebElement successMessage;

    public CheckoutPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void placeOrder() {
        placeOrderBtn.click();
    }

    public void enterPaymentDetails(String name, String number, String cvcCode, String month, String year) {
        nameOnCard.sendKeys(name);
        cardNumber.sendKeys(number);
        cvc.sendKeys(cvcCode);
        expiryMonth.sendKeys(month);
        expiryYear.sendKeys(year);
    }

    public void confirmPayment() {
        payButton.click();
    }

    public boolean isOrderPlaced() {
        try {
            return successMessage.isDisplayed(); // Simplified check
        } catch (Exception e) {
            return false;
        }
    }
}
