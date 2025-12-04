package com.nuces.sqe.framework.steps;

import com.nuces.sqe.framework.core.DriverFactory;
import com.nuces.sqe.framework.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class LoginSteps {

    private LoginPage loginPage = new LoginPage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        DriverFactory.getDriver().get("https://automationexercise.com/login");
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        loginPage.login(username, password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        // Already handled in login method, but if split steps needed:
        // loginPage.clickLogin();
        // For this framework, login method handles click.
        // If the feature file has explicit click step, we can keep it empty or refactor
        // page object.
        // Refactoring Page Object to split actions if needed, or just do nothing here
        // if login() did it.
        // Actually, looking at LoginPage.java, login() does click.
        // So this step is redundant but required by feature file.
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assertions.assertTrue(loginPage.isLogoutButtonVisible(), "Logout button should be visible");
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        // Automation Exercise shows error in body.
        // Simplified check: URL stays on login or error text exists.
        String pageSource = DriverFactory.getDriver().getPageSource();
        Assertions.assertTrue(pageSource.contains("incorrect") || pageSource.contains("exist"),
                "Error message expected");
    }

    @Then("I should remain on the login page")
    public void i_should_remain_on_the_login_page() {
        Assertions.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("login"));
    }

    @Given("I am logged in with {string} and {string}")
    public void i_am_logged_in_with(String username, String password) {
        i_am_on_the_login_page();
        loginPage.login(username, password);
    }

    @When("I click the logout button")
    public void i_click_the_logout_button() {
        loginPage.logout();
    }

    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page() {
        Assertions.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("login"));
    }
}
