package StepDefinition;


import java.io.IOException;

import BrowserUtils.Browser;
import PageFactoryy.swiggyLocationnPageFactory;
import PageFactoryy.swiggySearchPageFactoryy;
import io.cucumber.datatable.DataTable;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class swiggySearchDefinition extends Browser{

	swiggyLocationnPageFactory location;
	swiggySearchPageFactoryy search;
	

	@Given("User is on Search Page")
	public void user_is_on_search_page() throws InterruptedException {
		driver.navigate().to("https://www.swiggy.com/search");
		location=new swiggyLocationnPageFactory(driver);
		search=new swiggySearchPageFactoryy(driver);
		location.SearchField("Pune");
		location.SearchFieldd();
		search.search();
	}
	@When("User enters Restaurant name")
	public void user_enters_restaurant_name() throws InterruptedException {

		search.restaurantName();
		search.suggestion();

	}

	@Then("User should get appropriate suggestions")
	public void user_should_get_appropriate_suggestions() throws IOException, InterruptedException {
		search.takeScreenshot("C:\\Users\\LAKSHKC\\eclipse-workspace\\Selenium\\SwiggyAutomationProject\\Report\\suggestion screenshot.png");
	
	}

	@When("User enters Invalid restaurant name")
	public void user_enters_invalid_restaurant_name(DataTable restaurant) throws InterruptedException {
		search.validateInvalidRestaurantName(restaurant);
	}

	@When("User enters Invalid Food name")
	public void user_enters_invalid_food_name(DataTable food) throws InterruptedException {
		search.validateInvalidFoodName(food);


	}
	@Then("No suggestions are displayed")
	public void no_suggestions_are_displayed() throws InterruptedException {
		search.validateInvalidSearch();
		
	}
	@When("User enters Valid restaurant name")
	public void user_enters_valid_restaurant_name() throws InterruptedException {
		search.validRestaurantName();
	}
	@When("User is able to click on suggestions displayed")
	public void user_is_able_to_click_on_suggestions_displayed() throws InterruptedException, IOException {
		search.openValidRestaurantName();
	}

	@Then("User should be redirected to appropriate Restaurant result page")
	public void user_should_be_redirected_to_appropriate_restaurant_result_page() throws IOException, InterruptedException {
		search.takeScreenshot("C:\\Users\\LAKSHKC\\eclipse-workspace\\Selenium\\SwiggyAutomationProject\\Report\\restaurant page.png");
		
	}

	@When("User enters Valid food item name")
	public void user_enters_valid_food_item_name() throws InterruptedException, IOException {
		search.validFoodName();
	}
	@When("User is able to click on suggestion displayed")
	public void user_is_able_to_click_on_suggestion_displayed() throws InterruptedException, IOException {
		search.openValidFoodName();
	}
	@Then("User should be redirected to appropriate Food result page")
	public void user_should_be_redirected_to_appropriate_food_result_page() throws IOException, InterruptedException {
		search.takeScreenshot("C:\\Users\\LAKSHKC\\eclipse-workspace\\Selenium\\SwiggyAutomationProject\\Report\\Food page.png");
		
	}
	@When("User looks for Popular cuisines")
	public void user_looks_for_popular_cuisines() throws IOException, InterruptedException {
		search.takeScreenshot("C:\\Users\\LAKSHKC\\eclipse-workspace\\Selenium\\SwiggyAutomationProject\\Report\\PopularCuisinesPage.png");
	}
	@When("Clicks on desired popular cuisines suggestion")
	public void clicks_on_desired_popular_cuisines_suggestion() throws InterruptedException, IOException {
		search.popularCuisine();
		search.openValidFoodName();
	}
	@Then("User should be able to view appropriate restaurants list for that cuisine")
	public void user_should_be_able_to_view_appropriate_restaurants_list_for_that_cuisine() throws InterruptedException, IOException  {
		search.takeScreenshot("C:\\Users\\LAKSHKC\\eclipse-workspace\\Selenium\\SwiggyAutomationProject\\Report\\cuisinerestuarant.png");
		
	}

	@When("User click on Valid food item")
	public void user_click_on_valid_food_item() throws InterruptedException, IOException {
		search.validFoodName();
		search.openValidFoodName();
	}
	@When("User is able to see options Restaurants and Dishes")
	public void user_is_able_to_see_options_restaurants_and_dishes() throws InterruptedException, IOException {

		search.validateFoodAndDishes();
	}
	@When("User click on Restaurants and Dishes")
	public void user_click_on_restaurants_and_dishes() throws InterruptedException, IOException {
		search.restaurantSection();
		search.takeScreenshot("C:\\Users\\LAKSHKC\\eclipse-workspace\\Selenium\\SwiggyAutomationProject\\Report\\restaurant section.png");
		search.dishesSection();
		search.takeScreenshot("C:\\Users\\LAKSHKC\\eclipse-workspace\\Selenium\\SwiggyAutomationProject\\Report\\dishes section.png");
	}
	@Then("User is able to click on them to fetch appropriate result")
	public void user_is_able_to_click_on_them_to_fetch_appropriate_result() {
		System.out.println("Able to select food by restaurant and dishes");
	}

	@When("User can sort by different methods")
	public void user_can_sort_by_different_methods() throws InterruptedException {
		search.sortBy();
		search.ratingHighToLow();
		search.sortByy();
		search.priceLowToHigh();
		search.rating();
	}
	@Then("Appropriate search results should be displayed")
	public void appropriate_search_results_should_be_displayed() throws IOException, InterruptedException {
		search.takeScreenshot("C:\\Users\\LAKSHKC\\eclipse-workspace\\Selenium\\SwiggyAutomationProject\\Report\\sortBy.png");
		
	}

}

