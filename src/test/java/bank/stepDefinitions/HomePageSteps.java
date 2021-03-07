package bank.stepDefinitions;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import cucumber.api.java.en.Then;
import cucumberOptions.Hooks;
import pageUIs.HomePageUI;

public class HomePageSteps extends AbstractPage{
	WebDriver driver;
	public HomePageSteps() {
		this.driver = Hooks.openAndQuitBrowser();
	}
	@Then("^Home page display$")
	public void homePageDisplay()  {
		assertEquals(getElementText(driver, HomePageUI.MESSAGE), "Welcome To Manager's Page of Guru99 Bank");

	}

}
