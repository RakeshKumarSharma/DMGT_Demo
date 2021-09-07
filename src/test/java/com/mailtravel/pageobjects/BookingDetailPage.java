package com.mailtravel.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BookingDetailPage {
    Common common = new Common();

    @FindBy(name="numAdults")
    private WebElement numberOfAdults;

    @FindBy(name="numChildren")
    private WebElement numberOfChildren;

    @FindBy(name="departure")
    private WebElement departure;


    @FindBy(css=".nbf_pms_tpl_calendar_selecteddate [name=seldate]")
    private WebElement radioSelectedDate;


    @FindBy(css=".nbf_fancy_nbf_tpl_pms_continue")
    private WebElement buttonContinue;

    @FindBy(id="room-0-numselect")
    private WebElement numberOfStandardRoom;

    @FindBy(css=".nbf_fancy_nbf_tpl_pms_book_room")
    private WebElement bookRoomAndContinue;

    @FindBy(css=".nbf_fancy_extrasButton")
    private WebElement withoutExtrasContinue;

    @FindBy(css="[name=pax-a-title-1]")
    private WebElement adult1Title;

    @FindBy(css="[name=pax-a-first-1]")
    private WebElement adult1FirstName;

    @FindBy(css="[name=pax-a-last-1]")
    private WebElement adult1LastName;

    @FindBy(css="[name=pax-a-dobd-1]")
    private WebElement adult1DobDay;

    @FindBy(css="[name=pax-a-dobm-1]")
    private WebElement adult1DobMonth;

    @FindBy(css="[name=pax-a-doby-1]")
    private WebElement adult1DobYear;


    @FindBy(css="[name=pax-a-title-2]")
    private WebElement adult2Title;

    @FindBy(css="[name=pax-a-first-2]")
    private WebElement adult2FirstName;

    @FindBy(css="[name=pax-a-last-2]")
    private WebElement adult2LastName;

    @FindBy(css="[name=pax-a-dobd-2]")
    private WebElement adult2DobDay;

    @FindBy(css="[name=pax-a-dobm-2]")
    private WebElement adult2DobMonth;

    @FindBy(css="[name=pax-a-doby-2]")
    private WebElement adult2DobYear;


    @FindBy(css="[name=contact-name]")
    private WebElement leadName;

    @FindBy(css="[name=contact-mobile]")
    private WebElement leadMobile;

    @FindBy(css="[name=contact-email]")
    private WebElement leadEmail;

    @FindBy(css="[name=contact-address1]")
    private WebElement leadAddress1;

    @FindBy(css="[name=contact-city]")
    private WebElement leadCity;

    @FindBy(css=".nbf_fancy_paxButton")
    private WebElement continueToPayment;

    public String getNumberOfAdults()  {
        common.waitForVisibilityOfElement(numberOfAdults);
        Select selectListNumberOfAdults = new Select(numberOfAdults);
        return selectListNumberOfAdults.getFirstSelectedOption().getText();
    }

    public String getNumberOfChildren()  {
         common.waitForVisibilityOfElement(numberOfChildren);
         Select selectListNumberOfChildren = new Select(numberOfChildren);
         return selectListNumberOfChildren.getFirstSelectedOption().getText();
    }

    public String getDeparture()  {
         common.waitForVisibilityOfElement(departure);
         Select selectListDeparture = new Select(departure);
         return selectListDeparture.getFirstSelectedOption().getText();
    }

    public boolean isFirstAvailableDateSelected()  {
        return common.waitForVisibilityOfElement(radioSelectedDate).isSelected();
    }

    public void clickContinueButton()  {
        common.scrollToElement(buttonContinue);
        common.waitForElementToBeClickable(buttonContinue).click();
    }

    public void selectNumberOfStandardRooms(String numberOfRooms)  {
        common.waitForVisibilityOfElement(numberOfStandardRoom);
        Select selectListNumberOfAdults = new Select(numberOfStandardRoom);
        selectListNumberOfAdults.selectByValue(numberOfRooms);
    }

    public void clickBookRoomAndContinueButton()  {
        common.scrollToElement(bookRoomAndContinue);
        common.waitForElementToBeClickable(bookRoomAndContinue).click();
    }

    public void clickWithoutExtrasContinueButton()  {
        common.scrollToElement(withoutExtrasContinue);
        common.waitForElementToBeClickable(withoutExtrasContinue).click();
    }

    public void fillThePassengersDetails() throws InterruptedException {
        Thread.sleep(5000);
        selectValueInDropDown(adult1Title,"Mr");

        enterTextInInputBox(adult1FirstName,"A1_First");

        enterTextInInputBox(adult1LastName,"A1_Last");

        selectValueInDropDown(adult1DobDay,"1");
        selectValueInDropDown(adult1DobMonth,"1");
        selectValueInDropDown(adult1DobYear,"1980");

        selectValueInDropDown(adult2Title,"Mrs");

        enterTextInInputBox(adult2FirstName,"A2_First");

        enterTextInInputBox(adult2LastName,"A2_Last");

        selectValueInDropDown(adult2DobDay,"10");
        selectValueInDropDown(adult2DobMonth,"1");
        selectValueInDropDown(adult2DobYear,"1985");


        enterTextInInputBox(leadName,"LeadFirst LeadLast");

        enterTextInInputBox(leadMobile,"12345678910");

        enterTextInInputBox(leadEmail,"abc@example.org");

        enterTextInInputBox(leadAddress1,"first line");

        enterTextInInputBox(leadCity,"London");

        continueToPayment.click();

        Thread.sleep(15000);
    }

    public void selectValueInDropDown(WebElement element, String value){
        common.scrollToElement(element);
        common.waitForElementToBeClickable(element);
        Select selectList = new Select(element);
        selectList.selectByValue(value);
    }

    public void enterTextInInputBox(WebElement element, String value){
        try {
            common.scrollToElement(element);
            common.waitForVisibilityOfElement(element);
            element.sendKeys(value);

        }
        catch (org.openqa.selenium.StaleElementReferenceException ex){
            element.sendKeys(value);
        }
    }
}
