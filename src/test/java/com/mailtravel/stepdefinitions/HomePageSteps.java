package com.mailtravel.stepdefinitions;

import com.mailtravel.pageobjects.Homepage;
import com.mailtravel.utilities.DriverFactory;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.support.PageFactory;

public class HomePageSteps {

    Homepage home = PageFactory.initElements(DriverFactory.driver, Homepage.class);

    @Given("^an user on Mail Travel home page$")
    public void user_on_HomePage() {
        home.goToHomepage();
    }

    @When("^user enter text \"([^\"]*)\" on search bar$")
    public void user_enter_searchText(String searchText) throws InterruptedException {
        home.enterSearchText(searchText);
    }

    @Then("^the title of the homepage is \"([^\"]*)\"$")
    public void the_Title_Of_The_Homepage_Is(String title) {
        MatcherAssert.assertThat("Page title should contain title as" + title, StringUtils.containsIgnoreCase(home.getTitleOfPage(),title));
    }
}