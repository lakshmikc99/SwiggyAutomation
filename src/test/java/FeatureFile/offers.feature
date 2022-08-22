Feature: Swiggy Offers functionality
  
  Background: Given User is on Home Page
  @Offers 
  Scenario: Check if User is able to get Restaurant offers
  	Given User is on Home Page
  	When User clicks on Offers button
  	And User clicks on Restaurant offers
  	Then User should get all the list of discounts applicable on Restaurants
  	
  @Offers 
  Scenario: Check if User is able to get Payment Offers/Coupons
  	Given User is on Home Page
  	When User clicks on Offers button
  	And User clicks on Payment offers/Coupons
  	Then User should get all the list of available coupons 
  	
  @Offers 
  Scenario: Check if User is able to click on More in Coupons and get the terms and conditions of the Coupon code
  	Given User is on Home Page
  	When User clicks on Offers button
  	And User clicks on Payment offers/Coupons
  	And User Click on more in Coupon
  	Then User should get the terms and conditions of the Coupon code
  
  @Offers 
  Scenario: Check if User is able to copy the Coupon code
  	Given User is on Home Page
  	When User clicks on Offers button
  	And User clicks on Payment offers/Coupons
  	And User clicks on Copy Code button
  	Then The code is copied

    