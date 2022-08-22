package StepDefinition;

import java.io.IOException;


import BrowserUtils.Browser;
import PageFactoryy.swiggyFiltersOnHomepagePageFactory;
import PageFactoryy.swiggyLocationnPageFactory;
import PageFactoryy.swiggySearchPageFactoryy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class swiggyFiltersOnHomepageDefinition extends Browser{
	
	swiggyLocationnPageFactory location;
	swiggySearchPageFactoryy search;
	swiggyFiltersOnHomepagePageFactory filters;

	@Given("User is on Home  Page")
	public void user_is_on_home_page() throws InterruptedException {
		driver.navigate().to("https://www.swiggy.com/search");
		location=new swiggyLocationnPageFactory(driver);
		location.SearchField("Pune");
		location.SearchFieldd();
		search=new swiggySearchPageFactoryy(driver);
		filters=new swiggyFiltersOnHomepagePageFactory(driver);

	}

	@When("User clicks on filter section")
	public void user_clicks_on_filter_section() throws InterruptedException, IOException {
		filters.filtersButton();
		search.takeScreenshot("C:\\Users\\LAKSHKC\\eclipse-workspace\\Selenium\\SwiggyAutomationProject\\Report\\filters.png");
	}

	@When("User selects the appropriate checkboxes of cuisines")
	public void user_selects_the_appropriate_checkboxes_of_cuisines() throws InterruptedException {
		filters.selectingCheckBoxes();
	}

	@When("Clicks on Show restaurant button")
	public void clicks_on_show_restaurant_button() throws InterruptedException {
		filters.showRestaurantButton();
	}

	@Then("Appropriate restaurants according to filter applied will be displayed")
	public void appropriate_restaurants_according_to_filter_applied_will_be_displayed() throws IOException, InterruptedException {
		search.takeScreenshot("C:\\Users\\LAKSHKC\\eclipse-workspace\\Selenium\\SwiggyAutomationProject\\Report\\Restaurant after applying filters.png");
	}

	@Then("User should be able to click on clear button")
	public void user_should_be_able_to_click_on_clear_button() throws IOException, InterruptedException {
		search.takeScreenshot("C:\\Users\\LAKSHKC\\eclipse-workspace\\Selenium\\SwiggyAutomationProject\\Report\\After applying filters.png");
		filters.clearButton();
		search.takeScreenshot("C:\\Users\\LAKSHKC\\eclipse-workspace\\Selenium\\SwiggyAutomationProject\\Report\\After clearing filters.png");
		
	}


}
