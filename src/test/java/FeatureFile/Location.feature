Feature: Location Functionality

  @Location 
  Scenario: Validate the url of Swiggy Page
    Given User is on Swiggy Page
    When User enters url of Swiggy
    Then User should be navigated to Swiggy page

 @Location 
  Scenario Outline: Check if the Delivery Location field is giving suggestions for valid city names
    Given User is on Swiggy Page
    When User enters Valid "<City names>" and get the list of suggestions
    Then User should be able to get suggestions for valid city names

    Examples: 
      | City names |
      | Pune       |
      | Bangalore  |

  @Location 
  Scenario Outline: Check if the Delivery Location field is giving suggestions for Invalid city names
    Given User is on Swiggy Page
    When User enters Invalid city names
      | location  |
      | gsadhdj   |
      | 231265273 |
    Then User should not be able to get suggestions for Invalid city names and error message should be displayed

  @Location 
  Scenario: Check if User is able to enter other location after clicking on Clear button
    Given User is on Swiggy Page
    When User enters Valid city name and Click on Find Food button
    Then User should be able to view the Restaurants for the location

  @Location 
  Scenario: Check if clicking on Locate Me button fetch the current location.
    Given User is on Swiggy Page
    When User click on Locate Me button
    Then User should be able to get restaurants for current location

  @Location 
  Scenario: Check if User is able to change the location on Home Page
    Given User is on Swiggy Page
    When User enters Valid city name and Click on Find Food button
    And User clicks on Location dropdown and changes the location
    Then User is able to select location and view the Restaurants for the location
