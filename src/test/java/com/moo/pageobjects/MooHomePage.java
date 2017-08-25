package com.moo.pageobjects;

import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MooHomePage extends PageObject {

    private final String PAGE_TITLE = "Custom Online Business Printing & Design | MOO";
    private final String CONTACT_INFORMATION = "+44 20 8629 1415";

    @FindBy(id = "query")
    private WebElement query;

    @FindBy(linkText = "Inspiration")
    private WebElement inspirationMenu;

    @FindBy(linkText = "MOO Designs")
    private WebElement mooDesignsMenu;

    @FindBy(linkText = "Business Card Designs")
    private WebElement businessCardDesigns;

    @FindBy(id ="answerdash-helpButton-text")
    private WebElement chatQAMenu;

    @FindBy(xpath = "//td[@data-answerdash-hub-view='contactInfo']")
    private WebElement contactInfo;

    public MooHomePage(final WebDriver driver) {
        super(driver);
    }

    public void navigateTo(String url) {
        openAt(url);
    }

    public void waitUntilTitleAppears() {
        waitForTitleToAppear(PAGE_TITLE);
    }

    public void searchForTerm(String validSearchTerm) {
        query.sendKeys(validSearchTerm, Keys.ENTER);
    }

    public void goToInspirationBusinessCardDesigns() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(inspirationMenu).build().perform();
        waitFor(ExpectedConditions.visibilityOf(mooDesignsMenu));
        actions.moveToElement(mooDesignsMenu).build().perform();
        waitFor(ExpectedConditions.visibilityOf(businessCardDesigns));
        businessCardDesigns.click();
    }


    public void viewChatAndQA() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(chatQAMenu).build().perform();
    }

    public class ChatQAMenu extends PageObject {

        public void viewContactInfo() {
            waitFor(ExpectedConditions.visibilityOf(contactInfo));
            contactInfo.click();
        }

        public boolean contactInformationIsDisplayed() {
            waitForTextToAppear(CONTACT_INFORMATION);
            return containsText(CONTACT_INFORMATION);
        }
    }
}
