package com.moo.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InspirationBusinessCardDesignPage extends PageObject {
    private final String PAGE_TITLE = "Browse Business Card Design Templates | MOO (United Kingdom)";
    private String itemName;

    private List<WebElement> itemsList() {
        return find(By.className("results-container")).findElements(By.className("span4"));
    }

    @FindBy(css = ".icon.favourites")
    private WebElement favouritesView;

    public InspirationBusinessCardDesignPage(final WebDriver driver) {
        super(driver);
    }

    public void waitUntilTitleAppears() {
        waitForTitleToAppear(PAGE_TITLE);
    }

    public void addCardToFavourites() {
        final WebElement firstItem = getFirstElement();
        this.itemName = setItemName(firstItem);
        clickFavouriteIcon(firstItem);
    }

    private WebElement getFirstElement() {
        return itemsList().get(0).findElement(By.xpath("//div[@class='pdp-grid-box standard']"));
    }

    private String setItemName(WebElement firstItem) {
        return firstItem.findElement(By.cssSelector("h3")).getText();
    }

    private void clickFavouriteIcon(WebElement firstItem) {
        firstItem.findElement(By.className("icon")).click();
    }

    public void viewFavourites() {
        favouritesView.click();
    }

    public String getItemName() {
        return itemName;
    }

    public class FavouritesMenuView extends PageObject {

        public void waitForPageLoad() {
            this.waitForTextToAppear("1-1");
        }
    }
}
