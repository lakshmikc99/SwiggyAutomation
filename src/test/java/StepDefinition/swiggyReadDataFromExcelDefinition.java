package StepDefinition;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import BrowserUtils.Browser;
import PageFactoryy.swiggyAddToCartPageFactory;
import PageFactoryy.swiggyLocationnPageFactory;
import PageFactoryy.swiggyReadDataFromExcelPageFactory;
import PageFactoryy.swiggySearchPageFactoryy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class swiggyReadDataFromExcelDefinition extends Browser{
	
	swiggyLocationnPageFactory location;
	swiggySearchPageFactoryy search;
	swiggyReadDataFromExcelPageFactory excel;
	swiggyAddToCartPageFactory add;

	
	
	
	@Given("User is on Swiggy Home Page")
	public void user_is_on_swiggy_home_page() throws InterruptedException {
		
		driver.navigate().to("https://www.swiggy.com/search");
		location=new swiggyLocationnPageFactory(driver);	
		location.SearchField("Pune");
		location.SearchFieldd();
		search=new swiggySearchPageFactoryy(driver);
		add=new swiggyAddToCartPageFactory(driver);
		excel=new swiggyReadDataFromExcelPageFactory(driver);
		
		
	}
	@When("User click on search field & User enters Valid Restaurant name and click  on enter")
	public void user_click_on_search_field_user_enters_valid_restaurant_name_and_click_on_enter() throws InterruptedException {
	  search.search();
	  search.restaurantName();
	  excel.cakeZone();
	  excel.clickCakeZone();
	}
	@When("User should be able to read dishes names from Excel file and add Food items")
	public void user_should_be_able_to_read_dishes_names_from_excel_file_and_add_food_items() throws EncryptedDocumentException, IOException, InterruptedException {
	   excel.readExcel();
	   
	}
	@Then("Click on CheckOut button and should be redirected to Secure Checkout page")
	public void click_on_check_out_button_and_should_be_redirected_to_secure_checkout_page() throws InterruptedException, IOException {
		add.checkOutButton();
		search.takeScreenshot("C:\\Users\\LAKSHKC\\eclipse-workspace\\Selenium\\SwiggyAutomationProject\\Report\\checkOutPage.png");
		
	}
	
}
