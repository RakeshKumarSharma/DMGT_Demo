package com.mailtravel.pageobjects;

import com.mailtravel.utilities.DriverFactory;
import com.mailtravel.utilities.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends DriverFactory {

    TestContext testContext  = TestContext.getInstance();
    private static String homeUrl;

    Common common = new Common();


    @FindBy(css = ".accept-cookies-button")
    private WebElement acceptCookies;

    @FindBy(name = "searchtext")
    private WebElement searchBar;

    @FindBy(css = "div.nbf_button")
    private WebElement searchButton;

    public void goToHomepage(){
        homeUrl= testContext.readproperty("url");
        DriverFactory.driver.get(homeUrl);
    }

    public String getTitleOfPage(){
        return driver.getTitle();
    }

    public void enterSearchText(String searchText) throws InterruptedException {
        common.waitForVisibilityOfElement(acceptCookies);
        common.waitForElementToBeClickable(acceptCookies);
        Thread.sleep(500);
        acceptCookies.click();
        searchBar.clear();
        searchBar.sendKeys(searchText);
        common.waitForElementToBeClickable(searchButton).click();
    }
}