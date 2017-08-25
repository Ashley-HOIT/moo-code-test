package com.moo.stepdefinitions;

import com.moo.pageobjects.MooHomePage;
import com.moo.testconfiguration.TestConfiguration;
import cucumber.api.java.en.Given;

import static com.moo.support.Hooks.driver;

public class NavigationStepDefinitions {

    private MooHomePage mooHomePage = new MooHomePage(driver);

    @Given("^a customer navigates to the Moo\\.com website$")
    public void aCustomerNavigatesToTheMooComWebsite() {
        navigateToHomePage();
    }

    private void navigateToHomePage() {
        mooHomePage.navigateTo(TestConfiguration.BASE_URL);
        mooHomePage.waitUntilTitleAppears();
    }
}
