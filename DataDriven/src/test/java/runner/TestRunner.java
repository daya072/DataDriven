package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import utils.SeleniumDriver;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterClass;;

@CucumberOptions(
		plugin = {"pretty"},
		features = "src/test/resources/FeatureFiles",
		glue = "stepDef",
		tags = {"@test"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	@BeforeSuite
	public void beforeSuite() {
		SeleniumDriver.invokeBrowser();
	}
	
	@AfterClass
	public void afterClass() {
		SeleniumDriver.tearDown();
	}
	
}
