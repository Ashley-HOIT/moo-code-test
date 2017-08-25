package com.moo.stepdefinitions;

import com.moo.pageobjects.MooHomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.moo.support.Hooks.driver;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ViewContactInformationStepDefinitions {

    private MooHomePage mooHomePage = new MooHomePage(driver);
    private MooHomePage.ChatQAMenu chatQAMenu = mooHomePage.new ChatQAMenu();

    @When("^a customer selects to view Contact information via the homepage$")
    public void aCustomerSelectsToViewContactInformationViaTheHomepage() {
        viewContactInformation();
    }

    private void viewContactInformation() {
        mooHomePage.viewChatAndQA();
        chatQAMenu.viewContactInfo();
    }

    @Then("^the customer is presented with the Moo\\.com's contact information$")
    public void theCustomerIsPresentedWithTheMooComSContactInformation() {
        assertThat(chatQAMenu.contactInformationIsDisplayed(), is(true));
    }


}
