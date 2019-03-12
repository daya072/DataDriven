package page.actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;

import locators.SignOnLocators;
import utils.SeleniumDriver;

public class SignOnActions {
	SignOnLocators signOnLocators = new SignOnLocators();
	Logger log = Logger.getLogger(SignOnActions.class);

	public void ClickLogInLink() {
		signOnLocators.loginButton.click();
		log.info("Login button clicked");
	}
	
	public void ClickLoginWithMobile() {
		SeleniumDriver.waitDriver.until(ExpectedConditions.visibilityOf(signOnLocators.loginWithMobileLink));
		
		signOnLocators.loginWithMobileLink.click();
		log.info("Login with mobile clicked");
	}

}
