package runner;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import utils.SeleniumDriver;

@CucumberOptions(plugin = { "json:target/cucumber.json", "pretty",
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" },
		features = "src/test/resources/FeatureFiles",
		glue = "stepDef",
		tags = { "@smokeTest" })
public class TestRunner extends AbstractTestNGCucumberTests {
	public static Scenario scenario;

	@Before
	public void before(Scenario scenario) {

		System.out.println("Current Scenario: " + scenario.getName()
		);
	}

	@BeforeSuite
	public void beforeSuite() {
		SeleniumDriver.SetupDriver();
	}

	@AfterClass
	public void afterClass() {
		SeleniumDriver.tearDown();
	}

	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("config/extent-config.xml"));

	}

}
