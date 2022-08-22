package PageFactoryy;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class swiggyReadDataFromExcelPageFactory  {
	String path = "C:\\Users\\aavadhoo\\OneDrive - Capgemini\\Desktop\\JUnit\\com.swiggyyy\\src\\test\\java\\Excel\\Dishes Names.xlsx";
	//Locating cake zone 
	@FindBy(xpath="//div[@class='_23LIV']")
	WebElement cakeZone;
	@FindBy(xpath="//div[contains(text(),'CakeZone')]")
	WebElement clickCakeZone;
	
	public Logger log = Logger.getLogger(swiggyReadDataFromExcelPageFactory.class);
	
	public static WebDriver driver;	
	public swiggyReadDataFromExcelPageFactory(WebDriver driver)
	{
		swiggyReadDataFromExcelPageFactory.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void cakeZone() throws InterruptedException
	{
		cakeZone.click();
		log.info("Selecting cakezone for ordering cakes");
		
		
	}
	public void clickCakeZone() throws InterruptedException
	{
		clickCakeZone.click();
		
	}
	public void readExcel() throws EncryptedDocumentException, IOException, InterruptedException
	{			
			for(int i=1;i<3;i++)
			{
			Workbook wb = WorkbookFactory.create(new File(path)); 
			DataFormatter dataFormatter = new DataFormatter();
			Sheet sheet = wb.getSheetAt(0);
			String dish1 = dataFormatter.formatCellValue(sheet.getRow(i).getCell(0));		
			WebElement search=driver.findElement(By.xpath("//input[@placeholder='Search for dishes...']"));
			
			search.sendKeys(dish1);
			Thread.sleep(2000);
			WebElement addItem=driver.findElement(By.xpath("//div[@class='_1RPOp']"));
			addItem.click();
			Thread.sleep(2000);
			WebElement SelectCustomization=driver.findElement(By.xpath("//span[contains(text(),'Continue')]"));
			SelectCustomization.click();
			Thread.sleep(2000);		
			WebElement SubmitCustomization=driver.findElement(By.xpath("//span[contains(text(),'Add Item')]"));
			SubmitCustomization.click();
			Thread.sleep(2000);
			search.clear();	
			log.info("Validated read data from excel");
			
			}
			
		}
		
		
	}

