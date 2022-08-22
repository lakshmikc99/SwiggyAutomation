Feature: Search dishes from Restaurant and Add to Cart

  @DishesFromExcel
  Scenario: Check if User is able to read data from Excel
    Given User is on Swiggy Home Page
    When User click on search field & User enters Valid Restaurant name and click  on enter
    And User should be able to read dishes names from Excel file and add Food items
    Then Click on CheckOut button and should be redirected to Secure Checkout page
