package com.mailtravel.pageobjects;

import com.mailtravel.utilities.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Common extends DriverFactory {

    public WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        return wait;
    }

    public WebElement waitForVisibilityOfElement(WebElement element) {
        return getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> waitForVisibilityOfElements(List<WebElement> elements) {
        return getWait().until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public WebElement waitForElementToBeClickable(WebElement element) {
        return getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

}
