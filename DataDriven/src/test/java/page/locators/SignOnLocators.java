package page.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumDriver;

public class SignOnLocators {
	
/*	@FindBy(xpath="//*[@class='userName']")
	public WebElement loginButton;
	
	@FindBy(xpath="//*[@id=\"wallet-container-new qr-bg-white\"]/qr-code-login/div[2]/div[2]/div[3]")
	public WebElement loginWithMobileLink;
*/
	
	@FindBy(xpath="//input[@name='userName']")
	public WebElement userNmae;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement password;
	
	@FindBy(name="submit")
	public WebElement submit;

	@FindBy(xpath = "//*[@href='register.php']")
	public WebElement registerLink;
	
	
	public SignOnLocators(){
		WebDriver driver = SeleniumDriver.GetDriver();
		PageFactory.initElements(driver, this);
	}

}
