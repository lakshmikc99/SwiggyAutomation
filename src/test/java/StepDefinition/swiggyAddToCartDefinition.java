package StepDefinition;

import java.io.IOException;

import BrowserUtils.Browser;
import PageFactoryy.swiggyAddToCartPageFactory;
import PageFactoryy.swiggyLocationnPageFactory;
import PageFactoryy.swiggySearchPageFactoryy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class swiggyAddToCartDefinition extends Browser{

	swiggyLocationnPageFactory location;
	swiggySearchPageFactoryy search;

	swiggyAddToCartPageFactory add;


	@Given("User is already on Home page")
	public void user_is_already_on_home_page() throws InterruptedException {
		driver.get("https://www.swiggy.com");
		location=new swiggyLocationnPageFactory(driver);
		location.SearchField("Pune");
		location.SearchFieldd();
		search=new swiggySearchPageFactoryy(driver);
		add=new swiggyAddToCartPageFactory(driver);
	}
	@When("User clicks on Cart button without adding any food item")
	public void user_clicks_on_cart_button_without_adding_any_food_item() throws InterruptedException {
		add.addToCart();
	}
	@When("User gets redirected to secure checkout page")
	public void user_gets_redirected_to_secure_checkout_page() throws InterruptedException {
		add.validateSecureCheckoutPage();
	}
	@Then("User should get empty cart message")
	public void user_should_get_empty_cart_message() throws InterruptedException, IOException {
		add.validateEmptyCart();
		search.takeScreenshot("C:\\Users\\LAKSHKC\\eclipse-workspace\\Selenium\\SwiggyAutomationProject\\Report\\secure checkout page.png");
	}
	@When("User click on search field")
	public void user_click_on_search_field() throws InterruptedException {
		add.search();
	}
	@When("User enters Valid Restaurant name and click on enter")
	public void user_enters_valid_restaurant_name_and_click_on_enter() throws InterruptedException {
		add.searchBar();
	}
	@Then("User should be able to view recommended food items list")
	public void user_should_be_able_to_view_recommended_food_items_list() throws IOException, InterruptedException {
		add.validateRecommendedFoodItems();
		search.takeScreenshot("C:\\Users\\LAKSHKC\\eclipse-workspace\\Selenium\\SwiggyAutomationProject\\Report\\Recommended FoodItems.png");

	}
	@When("User is able to add different desired food items")
	public void user_is_able_to_add_different_desired_food_items() throws InterruptedException {
		add.addItems();
	}
	@When("User is able to increase or decrease the quantity of food item")
	public void user_is_able_to_increase_or_decrease_the_quantity_of_food_item() throws InterruptedException {
		add.increaseQuantity();
		add.decreaseQuantity();
	}
	@Then("User is able to click on Checkout button and User should be able to redirect to secure checkout page")
	public void user_is_able_to_click_on_checkout_button_and_user_should_be_able_to_redirect_to_secure_checkout_page() throws InterruptedException, IOException {
		add.checkOutButton();
		add.validateSecureCheckoutPage();	  

	}
	@Then("User is able to view total cost and discount in cart page")
	public void user_is_able_to_view_total_cost_and_discount_in_cart_page() throws IOException, InterruptedException {
		add.validateCheckOutPage();
		search.takeScreenshot("C:\\Users\\LAKSHKC\\eclipse-workspace\\Selenium\\SwiggyAutomationProject\\Report\\secure checkoutPage.png");

	}




}
