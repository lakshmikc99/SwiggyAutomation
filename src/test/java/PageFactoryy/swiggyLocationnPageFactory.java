package PageFactoryy;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.datatable.DataTable;


public class swiggyLocationnPageFactory 
{
	//Locating Location Search field
	@FindBy(xpath="//input[@type='text']")
	WebElement locationField;

	//Locating Find Food button
	@FindBy(xpath="//a[@class='_3iFC5']//span")
	WebElement findFoodbutton;

	//Locating error message for entering Invalid city names
	@FindBy(xpath="//div[contains(text(),'Enter your delivery location')]")
	WebElement errorMsg;

	//Locating Clear button
	@FindBy(xpath="//button[@class='NqZN6']")
	WebElement clearButton;

	//Locating City
	@FindBy(xpath="//span[contains(text(),'Pune, Maharashtra, India')][1]")
	WebElement city;

	//Locating Locate Me button
	@FindBy(xpath="//button[@class='_1fiQt']")
	WebElement locateMeBtn;

	//Locating location Dropdown
	@FindBy(xpath="//span[@class='icon-downArrow kVKTT']")
	WebElement locationDropdown;

	//Locating Searchfield in HomePage	
	@FindBy(xpath="//input[@class='_381fS _1oTLG']")
	WebElement searchFieldHomePage;

	//Locating city name in HomePage
	@FindBy(xpath="//div[contains(text(),'Bangalore')]")
	WebElement cityyNamee;

	public Logger log = Logger.getLogger(swiggyLocationnPageFactory.class);

	public static WebDriver driver;	
	public swiggyLocationnPageFactory(WebDriver driver)
	{
		swiggyLocationnPageFactory.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void SearchField(String str) throws InterruptedException
	{
		locationField.sendKeys(str);
		log.info("Entering desired location");
		 
	}

	public void SearchFieldd() throws InterruptedException {
		city.click();
		log.info("Selecting desired location");
		 

	}

	public void locationSearchFieldScenarioOutline(String string) throws InterruptedException
	{
		locationField.sendKeys(string);
		 
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='_1oLDb']"));
		for (WebElement wb : list) {
			System.out.println(wb.getText());}
		
		log.info("Suggestions displayed for matching results");
	}
	public void locationSearchField(DataTable city) throws InterruptedException 
	{

		List<Map<String, String>> cityName = city.asMaps(String.class, String.class);        
		for (Map<String, String> data : cityName) {             
			String cityNam = data.get("location");             
			 
			locationField.sendKeys(cityNam);
			 

			clearButton.click();
			 
		}}

	public void FindFoodButton() throws InterruptedException 
	{		
		findFoodbutton.click();	
		log.info("Finding food and restaurant for selected location");
		 
	}

	public void errorMessage()
	{
		System.out.println("Error msg for entering Invalid city names: "+errorMsg.getAttribute("innerText"));
		log.info("Invalid city name validated");
	}

	public void clearBtn() throws InterruptedException
	{
		clearButton.click();
		log.info("Location field cleared");
		 
	}

	public void locateMeButton() throws InterruptedException
	{
		locateMeBtn.click();
		log.info("Fetching current location");
		 
	}

	public void locationDropDownHomePage() throws InterruptedException
	{
		locationDropdown.click();
		log.info("Changing the location");
	
	}

	public void LocationSearchfieldHomePage() throws InterruptedException
	{
		searchFieldHomePage.sendKeys("Bangalore");
		log.info("Setting new location");
	
	}

	public void cityNameHomePage() throws InterruptedException
	{
		cityyNamee.click();
		log.info("New location set");

	}

	public void swiggyPage() throws InterruptedException
	{
		String swiggyPageURL=driver.getCurrentUrl();
		Assert.assertEquals(swiggyPageURL, "https://www.swiggy.com/");
		System.out.println("Swiggy page URL: " + swiggyPageURL);
		log.info("Validating homepage url");
		
	}
	public void validateSwiggyPage() throws InterruptedException
	{
		String actErrMsg=driver.findElement(By.xpath("//h2[contains(text(),'Order food from favourite restaurants near you.')]")).getText();
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(actErrMsg, "Order food from favourite restaurants near you.");
		softAssert.assertAll();	
		
	}
	public void validateCityPage() throws InterruptedException
	{
		String actErrMsg=driver.findElement(By.xpath("//h3[contains(text(),'Popular cities in India')]")).getText();
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(actErrMsg, "POPULAR CITIES IN INDIA");
		softAssert.assertAll();
		log.info("EValidating popular indian cities");
	
	}
	public void validateHomePage() throws InterruptedException
	{
		String actErrMsg=driver.findElement(By.xpath("//span[contains(text(),'Filters')]")).getText();
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(actErrMsg, "Filters");
		softAssert.assertAll();
		
	}
	public void currentLocation() throws InterruptedException, AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		log.info("Current location fetched successfully");
	}
}
