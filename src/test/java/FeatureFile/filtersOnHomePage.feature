Feature: Swiggy Filters on HomePage Functionality
	Background: Given User is on Location speicific Home page
  @Filters
  Scenario: Check if User is able to click on Cuisines checkboxes and get Restaurants accordingly
  	Given User is on Home  Page
  	When User clicks on filter section
  	And User selects the appropriate checkboxes of cuisines
  	And Clicks on Show restaurant button
  	Then Appropriate restaurants according to filter applied will be displayed
  
 	@Filters
  Scenario: Check if User is able to clear applied filters
  	Given User is on Home  Page
  	When User clicks on filter section
  	And User selects the appropriate checkboxes of cuisines
  	Then User should be able to click on clear button 
    