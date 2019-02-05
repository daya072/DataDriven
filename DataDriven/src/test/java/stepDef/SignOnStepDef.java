package stepDef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.SeleniumDriver;

public class SignOnStepDef {

	@When("^user logged in using \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_logged_in_using_and(String url, String userID, String password) throws Throwable {
	    SeleniumDriver.OpenURL(url);
	    
	}

	@Then("^dashboard page is displayed$")
	public void dashboard_page_is_displayed() throws Throwable {
	   
	}
	
}
