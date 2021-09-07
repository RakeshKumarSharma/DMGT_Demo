@booking
Feature: search and book a product from Mail Travel home page
  As an user when I navigate to Mail Travel website
  And Search for a travel product
  Then I should see the relevant results and be able to book the product

  Scenario: Quick search
    Given an user on Mail Travel home page
    Then the title of the homepage is "Home Page | Mail Travel"
    When user enter text "India" on search bar
    And User should see at least 1 result
    And User clicks on first result
    Then product detail page displays days,price,telephone
    When user clicks on online booking button
    Then default values are selected in number of adults,children,departure and first available date
    When user clicks on continue button
    And select "1" number of standard rooms and click on continue button
    And user clicks on without extras and continue button
    And fills in the passenger details in the form


