package StepDefinition;

import java.io.IOException;

import BrowserUtils.Browser;
import PageFactoryy.swiggyHelpPageFactory;
import PageFactoryy.swiggyLocationnPageFactory;
import PageFactoryy.swiggySearchPageFactoryy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class swiggyHelpDefinition extends Browser{

	swiggyLocationnPageFactory location;
	swiggySearchPageFactoryy search;
	swiggyHelpPageFactory help;

	@Given("User is on  Home  Page")
	public void user_is_on_home_page() throws InterruptedException {
		
		driver.navigate().to("https://www.swiggy.com/search");
		location=new swiggyLocationnPageFactory(driver);
		location.SearchField("Pune");
		location.SearchFieldd();
		search=new swiggySearchPageFactoryy(driver);
		help=new swiggyHelpPageFactory(driver);

	}
	@When("User clicks on Help section")
	public void user_clicks_on_help_section() throws InterruptedException {
		help.helpButton();
	}
	@When("User is redirected to Help and Support Page")
	public void user_is_redirected_to_help_and_support_page() throws IOException, InterruptedException {
		help.validateHelpPage();
		search.takeScreenshot("C:\\Users\\LAKSHKC\\eclipse-workspace\\Selenium\\SwiggyAutomationProject\\Report\\Help page.png");
	}
	@Then("User should be able to resolve doubts related to Partner Onboarding, Legal and FAQs")
	public void user_should_be_able_to_resolve_doubts_related_to_partner_onboarding_legal_and_fa_qs() throws InterruptedException, IOException {
		help.partnerOnboarding();
		help.validatePartnerOnboarding();
		search.takeScreenshot("C:\\Users\\LAKSHKC\\eclipse-workspace\\Selenium\\SwiggyAutomationProject\\Report\\Partner Onboarding.png");
		help.Legal();
		help.validateLegal();
		search.takeScreenshot("C:\\Users\\LAKSHKC\\eclipse-workspace\\Selenium\\SwiggyAutomationProject\\Report\\Legal.png");
		help.FAQs();
		help.validateFAQs();
		search.takeScreenshot("C:\\Users\\LAKSHKC\\eclipse-workspace\\Selenium\\SwiggyAutomationProject\\Report\\FAQs.png");
	}
}
