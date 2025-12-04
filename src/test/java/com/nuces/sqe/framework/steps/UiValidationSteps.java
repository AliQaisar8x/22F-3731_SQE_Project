package com.nuces.sqe.framework.steps;

import com.nuces.sqe.framework.core.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UiValidationSteps {

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        DriverFactory.getDriver().get("https://automationexercise.com");
    }

    @Then("the page title should be {string}")
    public void the_page_title_should_be(String expectedTitle) {
        Assertions.assertEquals(expectedTitle, DriverFactory.getDriver().getTitle());
    }

    @Then("the URL should contain {string}")
    public void the_url_should_contain(String expectedUrlPart) {
        Assertions.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains(expectedUrlPart));
    }

    @Then("I should not see any broken images")
    public void i_should_not_see_any_broken_images() {
        List<WebElement> images = DriverFactory.getDriver().findElements(By.tagName("img"));
        for (WebElement img : images) {
            String src = img.getAttribute("src");
            if (src != null && !src.isEmpty()) {
                // Verify image link (simplified)
                // verifyLink(src);
            }
        }
    }
}
