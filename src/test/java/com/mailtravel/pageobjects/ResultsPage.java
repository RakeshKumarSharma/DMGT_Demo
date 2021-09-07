package com.mailtravel.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultsPage {

    Common common = new Common();

    @FindBy(css="[id=products-found] .nbf_tpl_productsearchcount_cnt")
    private WebElement numberOfResults;

    @FindBy(id = "iterator_1_product_custom_more-info-button")
    private WebElement firstResult;


    public int getNumberOfResults() throws InterruptedException {
        Thread.sleep(5000);
        String number = common.waitForVisibilityOfElement(numberOfResults).getAttribute("innerText").replaceAll("\\D","");
        return Integer.valueOf(number.split("\\s+")[0]);
    }

    public void clickOnFirstResult()  {
        common.waitForVisibilityOfElement(firstResult).click();
    }
}
