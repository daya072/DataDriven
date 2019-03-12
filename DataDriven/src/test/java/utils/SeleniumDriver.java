package utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDriver {
	final static Log log = LogFactory.getLog(SeleniumDriver.class.getName());
	static WebDriver driver;
	static ConfigFileReader configFileReader = new ConfigFileReader();

	public static void invokeBrowser() {
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
	}
	
	
	public static WebDriver GetDriver(){
		return driver;
	}
	
	public static void OpenURL(String URL) {
		if(URL!=null) {
			driver.get(URL);
			log.info("URL launched");
		}
	}
	public static void tearDown() {
		if(driver!=null) {
			driver.close();
			driver.quit();
			driver = null;
		}
	}

}
