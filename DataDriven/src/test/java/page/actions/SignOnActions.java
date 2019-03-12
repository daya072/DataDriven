package page.actions;

import locators.SignOnLocators;

public class SignOnActions {
	SignOnLocators signOnLocators = new SignOnLocators();

	public void ClickLogInLink() {
		signOnLocators.loginButton.click();
	}

}
