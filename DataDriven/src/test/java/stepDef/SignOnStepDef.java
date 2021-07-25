package stepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.annotations.Test;
import page.actions.SignOnActions;
import utils.SeleniumDriver;

public class SignOnStepDef {
	SignOnActions signOnActions = new SignOnActions();

	@When("^user logged in using \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_logged_in_using_and(String url, String userID, String password) throws Throwable {
		SeleniumDriver.OpenURL(url);
		Thread.sleep(5000);
		signOnActions.EnterUserName(userID);
		signOnActions.EnterPassword(password);
		signOnActions.ClickSignOn();

	}

	@Then("^dashboard page is displayed$")
	public void dashboard_page_is_displayed() throws Throwable {

	}

	@Given("^Open MMT URL$")
	public void open_MMT_URL() throws Throwable {
		SeleniumDriver.OpenURL("https://www.makemytrip.com/");
		Thread.sleep(10000);
	}

	@Then("^test the flight search$")
	public void test_the_flight_search() throws Throwable {

		SeleniumDriver.GetDriver().findElement(By.xpath("//*[@id='SW']/div[1]/div[1]/ul/li[6]")).click();
		Thread.sleep(3000);
		SeleniumDriver.GetDriver().findElement(By.xpath("//*[@id='fromCity']")).click();
		SeleniumDriver.GetDriver().findElement(By.xpath("//*[@for='fromCity']/../div/div/div/div/input"))
				.sendKeys("MUM");
		Thread.sleep(3000);
		SeleniumDriver.GetDriver().findElement(By.xpath("//*[@for='fromCity']/../div/div/div/div/input"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}

	@Test
	public void myTest(){

	}

}
