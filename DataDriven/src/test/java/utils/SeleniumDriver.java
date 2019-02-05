package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDriver {
	static WebDriver driver;

	public static void invokeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	public static WebDriver GetDriver(){
		return driver;
	}
	
	public static void OpenURL(String URL) {
		if(URL!=null) {
			driver.get(URL);
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
