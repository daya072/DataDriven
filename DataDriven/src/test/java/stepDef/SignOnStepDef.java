package stepDef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.actions.SignOnActions;
import utils.SeleniumDriver;

public class SignOnStepDef {
	SignOnActions signOnActions = new SignOnActions();

	@When("^user logged in using \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_logged_in_using_and(String url, String userID, String password) throws Throwable {
	    SeleniumDriver.OpenURL(url);
	    signOnActions.ClickLogInLink();
	    signOnActions.ClickLoginWithMobile();
	    
	}

	@Then("^dashboard page is displayed$")
	public void dashboard_page_is_displayed() throws Throwable {
	   
	}
	
}
