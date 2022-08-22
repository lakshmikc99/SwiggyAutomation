package PageFactoryy;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;


public class swiggyHelpPageFactory {

	//Locating help section
	@FindBy(xpath="//*[contains(text(),'Help')]")
	WebElement help;
	//Locating Partner onboarding
	@FindBy(xpath="//span[contains(text(),'Partner Onboarding')]")
	WebElement partnerOnboarding;
	//Locating Legal
	@FindBy(xpath="//span[contains(text(),'Legal')]")
	WebElement legal;
	//Locating FAQs
	@FindBy(xpath="//span[contains(text(),'FAQs')]")
	WebElement FAQs;
	
	public Logger log = Logger.getLogger(swiggyHelpPageFactory.class);

	public static WebDriver driver;	
	public swiggyHelpPageFactory(WebDriver driver)
	{
		swiggyHelpPageFactory.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void helpButton() throws InterruptedException
	{
		Thread.sleep(1000);
		help.click();
		Thread.sleep(1000);
		log.info("Opening help section");
		
	}
	public void validateHelpPage() throws InterruptedException
	{
		String actErrMsg=driver.findElement(By.xpath("//h1[contains(text(),'Help & Support')]")).getText();
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(actErrMsg, "Help & Support");
		softAssert.assertAll();	
		log.info("Help & Support verified");
		
	}
	public void partnerOnboarding() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(partnerOnboarding));
		partnerOnboarding.click();
		log.info("Help related to Partner onboarding");
		
	}
	public void Legal() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(legal));
		legal.click();
		log.info("Help related to legal doubts");
		
	}
	public void FAQs() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(FAQs));
		FAQs.click();
		log.info("Help related to FAQs");
		
	}
	public void validatePartnerOnboarding() throws InterruptedException
	{

		String actErrMsg=driver.findElement(By.xpath("//div[@class='_2at3z']")).getText();
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(actErrMsg, "Partner Onboarding");
		softAssert.assertAll();
		log.info("Validated Partner onboarding");
		
	}

	public void validateLegal() throws InterruptedException
	{

		String actErrMsg=driver.findElement(By.xpath("//div[@class='_2at3z']")).getText();
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(actErrMsg, "Legal");
		softAssert.assertAll();	
		log.info("Validated Legal");
		
	}

	public void validateFAQs() throws InterruptedException
	{

		String actErrMsg=driver.findElement(By.xpath("//div[@class='_2at3z']")).getText();
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(actErrMsg, "FAQs");
		softAssert.assertAll();	
		log.info("Validated FAQs");
		
	}
}
