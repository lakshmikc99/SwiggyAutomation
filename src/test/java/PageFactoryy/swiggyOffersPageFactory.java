package PageFactoryy;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class swiggyOffersPageFactory {

	//Locating Offers button
	@FindBy(xpath="//*[@id=\"root\"]/div[1]/header/div/div/ul/li[4]/div/a")
	WebElement  offers;
	//Locating Restaurant offers section
	@FindBy(xpath="//div[@class='_1E9Bh _1oHqQ']")
	WebElement restaurantOffersSection;
	//Locating payment/coupons
	@FindBy(xpath="//div[@id='payment']")
	WebElement paymentOffers;
	//Locating more button in paymentOffer
	@FindBy(xpath="//button[@class='WybuQ _3LVhJ _1Gp4i']")
	WebElement moreBtn;
	//Locating copy code button
	@FindBy(xpath="//button[@class='_3dmIW _1KzVF']")
	WebElement copyCodeBtn;

	public Logger log = Logger.getLogger(swiggyOffersPageFactory.class);
	
	public static WebDriver driver;	
	public swiggyOffersPageFactory(WebDriver driver)
	{
		swiggyOffersPageFactory.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void offersButton() throws InterruptedException
	{
		offers.click();
		log.info("Opening offers section");
		
	}
	public void restaurantOffersSection() throws InterruptedException
	{
		restaurantOffersSection.click();
		log.info("Fetching restaurant related offers");
		
	}
	public void validateRestaurantOffers() throws InterruptedException
	{
		String res=driver.findElement(By.xpath("//span[contains(text(),'50% off | Use WELCOME50')]")).getText();
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(res, "50% off | Use WELCOME50");
		softAssert.assertAll();	
		log.info("Validating restaurant related offers");
		
	}
	public void paymentOffersSection() throws InterruptedException
	{
		paymentOffers.click();
		log.info("Fetching payment method related offers");
		
	}
	public void listOfAvailableCoupons()
	{
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='offers-containers']"));
		for (WebElement wb : list) {
			System.out.println(wb.getText());}
		log.info("Fetched payment method related offers");
	}
	public void moreButton() throws InterruptedException
	{
		moreBtn.click();
		log.info("Terms and condition to be displayed");
		
	}
	public void getTermsAndConditions() throws InterruptedException
	{
		String termsAndConditions=driver.findElement(By.xpath("//div[@class='KVykS _1hEG_']")).getText();
		System.out.println(termsAndConditions);
		log.info("Terms and conditions displayed");
		

	}
	public void copyCodeButton() throws InterruptedException
	{
		copyCodeBtn.click();
		
	}
	public void validateCopied() throws InterruptedException
	{

		String res=driver.findElement(By.xpath("//button[contains(text(),'COPIED')]")).getText();
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(res, "COPIED");
		softAssert.assertAll();	

	}
}
