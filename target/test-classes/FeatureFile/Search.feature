Feature: Search functionality

  Background: Given User is on Search Page

  @Search 
  Scenario: Check if User is able to get suggestions for Restaurant names in Search field
    Given User is on Search Page
    When User enters Restaurant name
    Then User should get appropriate suggestions

  @Search 
  Scenario: Check if User is able to get suggestion for Invalid restaurant and food item name
    Given User is on Search Page
    When User enters Invalid restaurant name
      | Restaurant    |
      | southern star |
      | Ironhill      |
    When User enters Invalid Food name
      | Food     |
      | abdhfyri |
      | ejrjk32  |
    Then No suggestions are displayed

  @Search 
  Scenario: Check if User is able to click on suggestions by Restaurant name
    Given User is on Search Page
    When User enters Valid restaurant name
    And User is able to click on suggestions displayed
    Then User should be redirected to appropriate Restaurant result page

  @Search 
  Scenario: Check if User is able to click on suggestions by Food Items
    Given User is on Search Page
    When User enters Valid food item name
    And User is able to click on suggestion displayed
    Then User should be redirected to appropriate Food result page

  @Search 
  Scenario: Check if User is able to click on Popular Cuisines and get suggestions
    Given User is on Search Page
    When User looks for Popular cuisines
    And Clicks on desired popular cuisines suggestion
    Then User should be able to view appropriate restaurants list for that cuisine

  @Search 
  Scenario: Check if Restaurants and Dishes section are giving results
    Given User is on Search Page
    When User click on Valid food item
    And User is able to see options Restaurants and Dishes
    And User click on Restaurants and Dishes
    Then User is able to click on them to fetch appropriate result
    
   @Search 
    Scenario: Check if User is able to sort the search results by different methods
  	 Given User is on Search Page
    When User click on Valid food item
    And User is able to see options Restaurants and Dishes
  	And User can sort by different methods 
  	Then Appropriate search results should be displayed
