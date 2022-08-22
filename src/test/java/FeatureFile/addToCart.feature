Feature: Add To Cart functionality

  Background: Given User is already on Home page

  @AddToCart
  Scenario: Check the behaviour of Cart button when no food item is added
    Given User is already on Home page
    When User clicks on Cart button without adding any food item
    And User gets redirected to secure checkout page
    Then User should get empty cart message

  @AddToCart
  Scenario: Check if User is able to view the list of all Recommended food items
    Given User is already on Home page
    When User click on search field
    And User enters Valid Restaurant name and click on enter
    Then User should be able to view recommended food items list
    
   @AddToCart
	Scenario: Check if User is able to add multiple food items from same restaurant 
		Given User is already on Home page
    When User click on search field
    And User enters Valid Restaurant name and click on enter
		And User is able to add different desired food items 
		And User is able to increase or decrease the quantity of food item
		Then User is able to click on Checkout button and User should be able to redirect to secure checkout page  
	
	@AddToCart
	  Scenario: Check if User is able to view the total cost and discount in Cart page
  	Given User is already on Home page
    When User click on search field
    And User enters Valid Restaurant name and click on enter
		And User is able to add different desired food items 
		And User is able to increase or decrease the quantity of food item
		Then User is able to click on Checkout button and User should be able to redirect to secure checkout page  
		Then User is able to view total cost and discount in cart page
	