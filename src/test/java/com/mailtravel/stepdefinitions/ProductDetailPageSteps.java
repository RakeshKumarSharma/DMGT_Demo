package com.mailtravel.stepdefinitions;

import com.mailtravel.pageobjects.ProductDetailPage;
import com.mailtravel.utilities.DriverFactory;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;


public class ProductDetailPageSteps {
    ProductDetailPage productDetailPagePage = PageFactory.initElements(DriverFactory.driver,ProductDetailPage.class);

    @Then("^product detail page displays days,price,telephone$")
    public void productDetailPageDisplaysDaysPriceTelephone() {
        MatcherAssert.assertThat("User should see number of days", !StringUtils.isAllEmpty(productDetailPagePage.getNumberOfDays()));
        MatcherAssert.assertThat("User should see price", !StringUtils.isAllEmpty(productDetailPagePage.getPrice()));
        MatcherAssert.assertThat("User should see telephone Number", !StringUtils.isAllEmpty(productDetailPagePage.getTelephone()));
    }

    @When("^user clicks on online booking button$")
    public void userClicksOnOnlineBookingButton() {
        productDetailPagePage.clickBookOnlineButton();
    }
}
