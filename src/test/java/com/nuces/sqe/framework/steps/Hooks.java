package com.nuces.sqe.framework.steps;

import com.nuces.sqe.framework.core.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.initDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            saveScreenshot(screenshot);
        }
        DriverFactory.quitDriver();
    }

    @Attachment(value = "Failure screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] bytes) {
        return bytes;
    }
}


