package utils;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDriver {
	private static  SeleniumDriver seleniumDriver;
	static ConfigFileReader configFileReader = new ConfigFileReader();
	public static WebDriverWait waitDriver; 
	public final static int TIMEOUT = 10;
	public final static int PAGE_LOAD_TIMEOUT = 10;
	
	
	final static Log log = LogFactory.getLog(SeleniumDriver.class.getName());
	static WebDriver driver;
	

	public SeleniumDriver() {
		String browserName = configFileReader.GetBrowserName();
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			throw new RuntimeException("Browser name provided in config file is not valid");
		}
		
		waitDriver = new WebDriverWait(driver, TIMEOUT);
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}
	
	public static void SetupDriver() {
		if (seleniumDriver == null) {
			seleniumDriver = new SeleniumDriver();
		}
	}
	
	
	public static WebDriver GetDriver(){
		return driver;
	}
	
	public static void OpenURL(String URL) {
		if(URL!=null) {
			driver.get(URL);
			log.info(driver);
			log.info("URL launched");
		}
	}
	
	public static WebDriverWait getWetDriver() {
		return waitDriver;
	}
	public static void tearDown() {
		if(driver!=null) {
			driver.close();
			driver.quit();
			driver = null;
		}
	}

}
