package runner;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import utils.SeleniumDriver;

@CucumberOptions(plugin = {
			"json:target/cucumber.json",
			"pretty",
			"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"
			},
		features = "src/test/resources/FeatureFiles",
		glue = "stepDef",
		tags = { "@login" })
public class TestRunner extends AbstractTestNGCucumberTests {
	public static Scenario scenario;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;

	@Before
	public void before(Scenario scenario) {

		System.out.println("Current Scenario: " + scenario.getName()
		);
	}

	@BeforeSuite
	public void beforeSuite() {

	}

	@BeforeClass
	public void beforeClass(){
		SeleniumDriver.SetupDriver();
		ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter("./target/extent.report.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);

		extentTest = extentReports.createTest("Test 1");
	}

	@AfterClass
	public void afterClass() {
		SeleniumDriver.tearDown();
	}

	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("config/extent-config.xml"));
		extentTest.pass("passed");
		extentReports.flush();
		SeleniumDriver.tearDown();
	}

}
