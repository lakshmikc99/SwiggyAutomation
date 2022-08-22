package BrowserUtils;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;


public class Browser 
{
	public static WebDriver driver;
	public static ChromeOptions options; 
	public static JavascriptExecutor js;
	public Logger log = Logger.getLogger(Browser.class);
	public void openBrowser()
	{
	options= new ChromeOptions();
	options.addArguments("--disable-notifications");		
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver(options);	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	log.info("Browser Opened");
	}
	
	public void closeBrowser()
	{
		driver.close();
		log.info("Browser closed");
	}
}

