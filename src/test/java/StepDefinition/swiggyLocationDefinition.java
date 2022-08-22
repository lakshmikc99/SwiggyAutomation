package StepDefinition;


import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BrowserUtils.Browser;
import PageFactoryy.swiggyLocationnPageFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

public class swiggyLocationDefinition extends Browser
	{
	
	swiggyLocationnPageFactory location;

	@Before
	public void setUp() {
		openBrowser();
	}
	
	@After
	public void tearDown()
	{
		closeBrowser();
	}
	
	@Given("User is on Swiggy Page")
	public void user_is_on_swiggy_page() {
		driver.get("https://www.swiggy.com");
		location=new swiggyLocationnPageFactory(driver);
	}

	@When("User enters url of Swiggy")
	public void user_enters_url_of_swiggy() throws InterruptedException {
		location.swiggyPage();

	}

	@Then("User should be navigated to Swiggy page")
	public void user_should_be_navigated_to_swiggy_page() throws InterruptedException { 
		location.validateSwiggyPage();

	}

	@When("User enters Valid {string} and get the list of suggestions")
	public void user_enters_valid_and_get_the_list_of_suggestions(String string) throws InterruptedException {
		location.locationSearchFieldScenarioOutline(string);


	}

	@Then("User should be able to get suggestions for valid city names")
	public void user_should_be_able_to_get_suggestions_for_valid_city_names() throws InterruptedException {
		location.validateCityPage();
		

	}

	@When("User enters Invalid city names")
	public void user_enters_invalid_city_names(DataTable city) throws InterruptedException {
		location.locationSearchField(city);

	}

	@Then("User should not be able to get suggestions for Invalid city names and error message should be displayed")
	public void user_should_not_be_able_to_get_suggestions_for_invalid_city_names_and_error_message_should_be_displayed() throws InterruptedException {
		location.validateCityPage();
		
	}

	@When("User enters Valid city name and Click on Find Food button")
	public void user_enters_valid_city_name_and_click_on_find_food_button() throws InterruptedException {
		location.SearchField("Pune");
		location.SearchFieldd();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_3Ynv-']")));

	}
	@Then("User should be able to view the Restaurants for the location")
	public void user_should_be_able_to_view_the_restaurants_for_the_location() throws InterruptedException {
		location.swiggyPage();
		
	}

	@When("User click on Locate Me button")
	public void user_click_on_locate_me_button() throws InterruptedException, AWTException {
		location.locateMeButton();
		location.currentLocation();
	}
	@Then("User should be able to get restaurants for current location")
	public void user_should_be_able_to_get_restaurants_for_current_location() throws InterruptedException {
		location.validateHomePage();

	}

	@When("User clicks on Location dropdown and changes the location")
	public void user_clicks_on_location_dropdown_and_changes_the_location() throws InterruptedException {
		location.locationDropDownHomePage();
		location.LocationSearchfieldHomePage();
		location.cityNameHomePage();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_3Ynv-']")));

	}
	@Then("User is able to select location and view the Restaurants for the location")
	public void user_is_able_to_select_location_and_view_the_restaurants_for_the_location() throws InterruptedException {
		location.validateHomePage();
	
	}




}