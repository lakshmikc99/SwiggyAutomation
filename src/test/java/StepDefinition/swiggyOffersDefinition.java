package StepDefinition;

import java.io.IOException;
import BrowserUtils.Browser;
import PageFactoryy.swiggyLocationnPageFactory;
import PageFactoryy.swiggyOffersPageFactory;
import PageFactoryy.swiggySearchPageFactoryy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class swiggyOffersDefinition extends Browser{
	
	swiggyLocationnPageFactory location;
	swiggyOffersPageFactory offers;
	swiggySearchPageFactoryy search;

	@Given("User is on Home Page")
	public void user_is_on_home_page() throws InterruptedException {
		driver.navigate().to("https://www.swiggy.com/search");
		location=new swiggyLocationnPageFactory(driver);
		location.SearchField("Pune");
		location.SearchFieldd();
		search=new swiggySearchPageFactoryy(driver);
		offers=new swiggyOffersPageFactory(driver);
	}
	@When("User clicks on Offers button")
	public void user_clicks_on_offers_button() throws InterruptedException {
		offers.offersButton();
	}
	@When("User clicks on Restaurant offers")
	public void user_clicks_on_restaurant_offers() throws InterruptedException, IOException {
		search.takeScreenshot("C:\\Users\\LAKSHKC\\eclipse-workspace\\Selenium\\SwiggyAutomationProject\\Report\\Restauant Offers.png");	
	}
	@Then("User should get all the list of discounts applicable on Restaurants")
	public void user_should_get_all_the_list_of_discounts_applicable_on_restaurants() throws InterruptedException {
		offers.validateRestaurantOffers();
		
	}

	@When("User clicks on Payment offers\\/Coupons")
	public void user_clicks_on_payment_offers_coupons() throws InterruptedException, IOException {
		offers.paymentOffersSection();
		search.takeScreenshot("C:\\Users\\LAKSHKC\\eclipse-workspace\\Selenium\\SwiggyAutomationProject\\Report\\Payment offers.png");
	}
	@Then("User should get all the list of available coupons")
	public void user_should_get_all_the_list_of_available_coupons() {
		offers.listOfAvailableCoupons();
		
	}
	@When("User Click on more in Coupon")
	public void user_click_on_more_in_coupon() throws InterruptedException, IOException {
		offers.moreButton();
		search.takeScreenshot("C:\\Users\\LAKSHKC\\eclipse-workspace\\Selenium\\SwiggyAutomationProject\\Report\\Terms and conditions.png");
	}
	@Then("User should get the terms and conditions of the Coupon code")
	public void user_should_get_the_terms_and_conditions_of_the_coupon_code() throws InterruptedException {
		offers.getTermsAndConditions();
		
	}
	@When("User clicks on Copy Code button")
	public void user_clicks_on_copy_code_button() throws InterruptedException, IOException {
		offers.copyCodeButton();
		search.takeScreenshot("C:\\Users\\LAKSHKC\\eclipse-workspace\\Selenium\\SwiggyAutomationProject\\Report\\copied.png");
	}
	@Then("The code is copied")
	public void the_code_is_copied() throws InterruptedException {
		offers.validateCopied();
		
	}

}
