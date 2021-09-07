package com.mailtravel.stepdefinitions;

import com.mailtravel.pageobjects.ResultsPage;
import com.mailtravel.utilities.DriverFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.commons.lang3.StringUtils;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class ResultsPageSteps {

    ResultsPage resultsPage = PageFactory.initElements(DriverFactory.driver,ResultsPage.class);

    @And("^User should see at least (\\d+) result$")
    public void userShouldSeeAtLeastResult(int results) throws InterruptedException {
        MatcherAssert.assertThat("User should see at least 1 result",resultsPage.getNumberOfResults(),greaterThanOrEqualTo(results));
    }

    @And("^User clicks on first result$")
    public void userClicksOnFirstResult()  {
        resultsPage.clickOnFirstResult();
    }
}
