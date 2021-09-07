package com.mailtravel.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage {
    Common common = new Common();

    @FindBy(id="price-pin_days-num-01")
    private WebElement numberOfDays;

    @FindBy(className = "pin-price-normal")
    private WebElement price;

    @FindBy(id = "supplier-phone")
    private WebElement telephone;

    @FindBy(name = "enterbookingflow")
    private WebElement bookOnlineButton;

    public String getNumberOfDays()  {
        return common.waitForVisibilityOfElement(numberOfDays).getAttribute("innerText");
    }

    public String getPrice()  {
        return common.waitForVisibilityOfElement(price).getAttribute("innerText");
    }

    public String getTelephone()  {
        return common.waitForVisibilityOfElement(telephone).getAttribute("innerText");
    }

    public void clickBookOnlineButton()  {
        common.waitForElementToBeClickable(bookOnlineButton).click();
    }
}
