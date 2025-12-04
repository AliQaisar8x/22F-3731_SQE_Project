package com.nuces.sqe.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nuces.sqe.framework.core.DriverFactory;

public class LoginPage {
    private final WebDriver driver;

    @FindBy(css = "a[href='/login']")
    private WebElement loginLink;

    @FindBy(css = "input[data-qa='login-email']")
    private WebElement emailInput;

    @FindBy(css = "input[data-qa='login-password']")
    private WebElement passwordInput;

    @FindBy(css = "button[data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(css = "a[href='/logout']")
    private WebElement logoutButton;

    public LoginPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void navigateToLogin() {
        loginLink.click();
    }

    public void login(String username, String password) {
        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void logout() {
        logoutButton.click();
    }

    public boolean isLogoutButtonVisible() {
        try {
            return logoutButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
