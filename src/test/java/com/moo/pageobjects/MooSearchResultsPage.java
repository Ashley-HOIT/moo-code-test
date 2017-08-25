package com.moo.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MooSearchResultsPage extends PageObject {

    private final String PAGE_TITLE = "MOO | Search | MOO (United Kingdom)";
    private final String INVALID_SEARCH_TERM_TEXT= "Sorry";

    @FindBy(id = "resInfo-0")
    public WebElement resultInformation;

    public MooSearchResultsPage(final WebDriver driver) {
        super(driver);
    }

    public void waitUntilTitleAppears() {
        waitForTitleToAppear(PAGE_TITLE);
    }

    public String resultInformationText() {
        return resultInformation.getText();
    }

    public boolean invalidSearchTermTextIsDisplayed() {
        return containsText(INVALID_SEARCH_TERM_TEXT);
    }
}
