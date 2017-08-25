package com.moo.stepdefinitions;

import com.moo.pageobjects.InspirationBusinessCardDesignPage;
import com.moo.pageobjects.MooHomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.moo.support.Hooks.driver;
import static junit.framework.TestCase.assertTrue;

public class InspirationStepDefinitions {

    private MooHomePage mooHomePage = new MooHomePage(driver);
    private InspirationBusinessCardDesignPage inspirationBusinessCardDesignPage = new InspirationBusinessCardDesignPage(driver);
    private InspirationBusinessCardDesignPage.FavouritesMenuView favouritesMenuView = inspirationBusinessCardDesignPage.new FavouritesMenuView();

    @When("^the customer selects to add a Business Card to the Favourites View$")
    public void theCustomerSelectsToAddABusinessCardToTheFavouritesView() {
        selectInspirationBusinessCardDesigns();
        addBusinessCardToFavourites();
        viewFavouritesMenu();
    }

    private void selectInspirationBusinessCardDesigns() {
        mooHomePage.goToInspirationBusinessCardDesigns();
    }

    private void addBusinessCardToFavourites() {
        inspirationBusinessCardDesignPage.waitUntilTitleAppears();
        inspirationBusinessCardDesignPage.addCardToFavourites();
    }

    private void viewFavouritesMenu() {
        inspirationBusinessCardDesignPage.viewFavourites();
        favouritesMenuView.waitForPageLoad();
    }

    @Then("^the selected Business Card is available within the Favourites View$")
    public void theSelectedBusinessCardIsAvailableWithinTheFavouritesView() {
        validateSelectedCardIsAvailable();
    }

    private void validateSelectedCardIsAvailable() {
        String itemName = getItemName();
        assertTrue(favouritesMenuView.containsText(itemName));
    }

    private String getItemName() {
        return inspirationBusinessCardDesignPage.getItemName();
    }
}
