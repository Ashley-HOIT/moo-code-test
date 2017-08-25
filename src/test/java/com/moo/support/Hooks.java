package com.moo.support;

import com.moo.driverfactory.CustomDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setupTests() {
        setupDriver();
    }

    private void setupDriver() {
        CustomDriver customDriver = new CustomDriver();
        driver = customDriver.newDriver();
    }

    @After
    public void tearDownTests() {
        tearDownDriver();
    }

    private void tearDownDriver() {
        driver.close();
        driver.quit();
    }
}
