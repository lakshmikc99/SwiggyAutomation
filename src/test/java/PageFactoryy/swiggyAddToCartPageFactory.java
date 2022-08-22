package PageFactoryy;

import java.util.List;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;



public class swiggyAddToCartPageFactory{
	//Locating cart button
	@FindBy(xpath="//span[contains(text(),'Cart')]")
	WebElement addToCart;
	//Locating search
	@FindBy(xpath="//span[contains(text(),'Search')]")
	WebElement search; 
	//Locating searchBar
	@FindBy(xpath="//input[@class='_2FkHZ']")
	WebElement searchBar;
	//Locating add food items
	@FindBy(xpath="//div[contains(text(),'Burgers')]")
	WebElement burger;
	@FindBy(xpath="//*[@id=\"h1500331816\"]/div[2]/div[2]/div[1]/div/div[2]/div/div/div[1]")
	WebElement addburger;
	@FindBy(xpath="//*[@id=\"menu-content\"]/div[1]/div[1]/div/div/div[1]/div/a[3]/div")
	WebElement combos;
	@FindBy(xpath="//*[@id=\"h-1065760579\"]/div[2]/div[1]/div[1]/div/div[2]/div/div/div[1]")
	WebElement addcombos;	
	@FindBy(xpath="//div[contains(text(),'Quick Bites')]")
	WebElement quickBites;
	@FindBy(xpath="//*[@id=\"h-1314674465\"]/div[2]/div[1]/div[1]/div/div[2]/div/div/div[1]")
	WebElement addquickBites;
	//Locating swiggy icon
	@FindBy(xpath="//*[@id=\"root\"]/div[1]/header/div/div/a/svg/path")
	WebElement swiggyIcon;
	//Locating checkout button
	@FindBy(xpath="//*[@id=\"menu-content\"]/div[2]/div/div[3]/button")
	WebElement checkOutButton;
	//Locating increase quantity
	@FindBy(xpath="/html/body/div[1]/div[1]/div[1]/div[1]/div[4]/div[2]/div/div[2]/div[2]/div/div[2]/div[3]/div[2]/div/div[1]/div[2]")
	WebElement increaseQuantity;
	//Locating decrease quantity
	@FindBy(xpath="//*[@id=\"menu-content\"]/div[2]/div/div[2]/div[2]/div/div[2]/div[3]/div[2]/div/div[1]/div[3]")
	WebElement decreaseQuantity;
	
	public Logger log = Logger.getLogger(swiggyAddToCartPageFactory.class);

	public static WebDriver driver;
	
	public swiggyAddToCartPageFactory(WebDriver driver)
	{
		swiggyAddToCartPageFactory.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void addToCart() throws InterruptedException
	{
		log.info("Clicking on addToCart section");
		addToCart.click();
		
	}
	public void validateSecureCheckoutPage() throws InterruptedException
	{
		String secureCheckout=driver.findElement(By.xpath("//span[contains(text(),'Secure Checkout')]")).getText();
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(secureCheckout, "SECURE CHECKOUT");
		softAssert.assertAll();	
		log.info("Secure Checkout page displayed");
		
	}
	public void validateEmptyCart() throws InterruptedException
	{

		String emptyCart=driver.findElement(By.xpath("//div[contains(text(),'Your cart is empty')]")).getText();
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(emptyCart, "Your cart is empty");
		softAssert.assertAll();	
		log.info("Your cart is empty");
		
	}
	public void search() throws InterruptedException
	{
		log.info("Clicking on search field");
		WebElement elementSearch=driver.findElement(By.xpath("//span[contains(text(),'Search')]"));
		elementSearch.click();
		
	}
	public void searchBar() throws InterruptedException
	{
		searchBar.sendKeys(" Hotel Durga");
		log.info("Entered Hotel Durga");
		WebElement element=driver.findElement(By.xpath("//div[@class='_23LIV']"));
		element.click();
		
		WebElement element1=driver.findElement(By.xpath("//div[contains(text(),'Hotel Durga')]"));
		element1.click();
		log.info("Hotel durga restaurant menu displayed");
	}
	public void validateRecommendedFoodItems()
	{

		List<WebElement> recommendedFoodItems = driver.findElements(By.xpath("//div[@class='nh_z0']"));
		for (WebElement wb : recommendedFoodItems) {
			System.out.println(wb.getText());}
	}
	public void addItems() throws InterruptedException
	{

		Thread.sleep(2000);
		burger.click();
		log.info("Adding burger");
		Thread.sleep(2000);
		addburger.click();
		log.info("Adding combo");
		combos.click();
		addcombos.click();
		log.info("Adding quick bites");
		quickBites.click();
		addquickBites.click();
		
	}
	public void swiggyIcon() throws InterruptedException
	{
		swiggyIcon.click();
		
	}
	public void checkOutButton() throws InterruptedException
	{	
		checkOutButton.click();
		log.info("Checkout clicked and redirected to secure checkout page");
		Thread.sleep(1000);
		
	}
	public void increaseQuantity() throws InterruptedException
	{	
		log.info("Increasing the quantity of food");
		Thread.sleep(1000);
		increaseQuantity.click();
		Thread.sleep(1000);
		increaseQuantity.click();
		Thread.sleep(1000);
		increaseQuantity.click();
		Thread.sleep(1000);
		
	}
	public void decreaseQuantity() throws InterruptedException
	{
		log.info("Decreasing the quantity of food");
		decreaseQuantity.click();
		Thread.sleep(2000);
		
	}
	public void validateCheckOutPage() throws InterruptedException
	{
		
		String OrderDetails =driver.findElement(By.xpath("//div[@class='_2sMsA']")).getText();
		System.out.println("Order details: \n"+OrderDetails);
		log.info("Order details printed");
		
	}

}

