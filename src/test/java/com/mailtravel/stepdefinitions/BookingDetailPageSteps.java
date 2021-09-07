package com.mailtravel.stepdefinitions;

import com.mailtravel.pageobjects.BookingDetailPage;
import com.mailtravel.utilities.DriverFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.Matchers.containsString;


public class BookingDetailPageSteps {

    BookingDetailPage bookingDetailPage = PageFactory.initElements(DriverFactory.driver,BookingDetailPage.class);


    @Then("^default values are selected in number of adults,children,departure and first available date$")
    public void default_Values_Are_Selected_In_NumberOfAdults_Children_Departure_And_FirstAvailableDate() {
        MatcherAssert.assertThat("User should see number 2 selected in Number of Adults",bookingDetailPage.getNumberOfAdults(),containsString("2"));
        MatcherAssert.assertThat("User should see number 0 selected in Number of Children",bookingDetailPage.getNumberOfChildren(),containsString("0"));
        MatcherAssert.assertThat("User should see London Heathrow  selected in Departure",bookingDetailPage.getDeparture(),containsString("London Heathrow"));
        MatcherAssert.assertThat("User should see first available date  selected in calendar",bookingDetailPage.isFirstAvailableDateSelected());
    }

    @When("^user clicks on continue button$")
    public void userClicksOnContinueButton() {
        bookingDetailPage.clickContinueButton();
    }


    @And("^select \"([^\"]*)\" number of standard rooms and click on continue button$")
    public void selectNumberOfStandardRoomsAndClickOnContinueButton(String numRooms) throws Throwable {
        bookingDetailPage.selectNumberOfStandardRooms(numRooms);
        bookingDetailPage.clickBookRoomAndContinueButton();
    }

    @And("^user clicks on without extras and continue button$")
    public void userClicksOnWithoutExtrasAndContinueButton() {
        bookingDetailPage.clickWithoutExtrasContinueButton();
    }

    @And("^fills in the passenger details in the form$")
    public void fillsInThePassengerDetailsInTheForm() throws InterruptedException {
        bookingDetailPage.fillThePassengersDetails();
    }
}
