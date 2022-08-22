package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(features="C:\\Users\\LAKSHKC\\eclipse-workspace\\Selenium\\SwiggyAutomationProject\\src\\test\\java\\FeatureFile", glue= {"StepDefinition"}, tags=("") ,monochrome=true,plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
			"timeline:test-output-thread/","html:target/cucumber-reports.html","json:target/cucumber-reports/Cucumber.json",
	"junit:target/cucumber-reports/Cucumber.xml","rerun:target/failedrerun.txt"})
	public class testRunnerClass extends AbstractTestNGCucumberTests

	{

	}


