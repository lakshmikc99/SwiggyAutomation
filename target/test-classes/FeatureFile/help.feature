Feature: Swiggy Help functionality

	@Help
  Scenario: Check if User is able to access Help Page to clarify basic doubts
   Given User is on  Home  Page
   When User clicks on Help section
   And User is redirected to Help and Support Page
   Then User should be able to resolve doubts related to Partner Onboarding, Legal and FAQs