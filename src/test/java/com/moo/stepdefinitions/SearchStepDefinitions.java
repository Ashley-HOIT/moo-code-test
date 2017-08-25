package com.moo.stepdefinitions;

import com.moo.pageobjects.MooHomePage;
import com.moo.pageobjects.MooSearchResultsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.moo.support.Hooks.driver;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;

public class SearchStepDefinitions {

    private MooHomePage mooHomePage = new MooHomePage(driver);
    private MooSearchResultsPage mooSearchResultsPage = new MooSearchResultsPage(driver);
    private final String VALID_SEARCH_TERM = "Business Cards";
    private final String INVALID_SEARCH_TERM = "djknfvkjdnfv";
    private String searchTerm;



    @When("^the customer searches for a valid product$")
    public void theCustomerSearchesForAValidProduct() {
        searchForAValidProduct();
    }

    private void searchForAValidProduct() {
        searchTerm = VALID_SEARCH_TERM;
        mooHomePage.searchForTerm(searchTerm);
    }

    @Then("^the customer receives products based upon their search terms$")
    public void theCustomerReceivesProductsBasedUponTheirSearchTerms() {
        validateSearchTerm(searchTerm);
        validResultsAreReturned();
    }

    private void validResultsAreReturned() {
        assertThat(mooSearchResultsPage.resultInformationText(), is(not("")));
    }

    @When("^the customer searches for an invalid product$")
    public void theCustomerSearchesForAnInvalidProduct() {
        searchForAnIValidProduct();
    }

    private void searchForAnIValidProduct() {
        searchTerm = INVALID_SEARCH_TERM;
        mooHomePage.searchForTerm(searchTerm);
    }

    @Then("^the customer does not receive products based upon their search terms$")
    public void theCustomerDoesNotReceiveProductsBasedUponTheirSearchTerms() {
        validateSearchTerm(searchTerm);
        noResultsAreReturned();
    }

    private void validateSearchTerm(String searchTerm) {
        mooSearchResultsPage.waitUntilTitleAppears();
        assertTrue(mooSearchResultsPage.containsText(searchTerm));
    }

    private void noResultsAreReturned() {
        assertThat(mooSearchResultsPage.invalidSearchTermTextIsDisplayed(), is(true));

    }


}
