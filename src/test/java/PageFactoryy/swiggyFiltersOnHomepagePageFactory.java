package PageFactoryy;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class swiggyFiltersOnHomepagePageFactory {
	//Locating filters on home page
	@FindBy(xpath="//div[@class='_3eFQ-']")
	WebElement filters;
	//Locating check boxes
	@FindBy(xpath="//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div/div[3]/div[1]/div[2]/label[5]/div/div[1]")
	WebElement checkBox1;
	@FindBy(xpath="//div[contains(text(),'Continental')]")
	WebElement checkBox2;
	@FindBy(xpath="//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div/div[3]/div[1]/div[2]/label[7]/div/div[1]")
	WebElement checkBox3;
	@FindBy(xpath="//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div/div[3]/div[1]/div[2]/label[8]/div/div[1]")
	WebElement checkBox4;
	@FindBy(xpath="//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div/div[3]/div[1]/div[2]/label[12]/div/div[1]")
	WebElement checkBox5;
	//Locating show restaurant button
	@FindBy(xpath="//*[contains(text(),'SHOW RESTAURANTS')]")
	WebElement showRestaurantBtn;
	//Locating clear button
	@FindBy(xpath="//*[contains(text(),'CLEAR')]")
	WebElement clearBtn;
	
	public Logger log = Logger.getLogger(swiggyFiltersOnHomepagePageFactory.class);

	public static WebDriver driver;	
	public swiggyFiltersOnHomepagePageFactory(WebDriver driver)
	{
		swiggyFiltersOnHomepagePageFactory.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void filtersButton() throws InterruptedException
	{
		filters.click();
		log.info("Clicking on filter section");
		
	}
	public void selectingCheckBoxes() throws InterruptedException
	{
		checkBox1.click();
		
		checkBox1.click();
		
		checkBox1.click();
		
		checkBox2.click();
		
		checkBox3.click();
		
		checkBox4.click();
		
		checkBox5.click();
		log.info("Selecting checkboxes");
	}
	public void showRestaurantButton() throws InterruptedException
	{
		showRestaurantBtn.click();
		log.info("Filtering according to checkboxes selected");
		
	}

	public void clearButton() throws InterruptedException
	{
		clearBtn.click();
		log.info("Clearing the selected checkbox filter");
		
	}
}
