package bank.stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pageUIs.RegisterPageUI;
import utilities.FakerConfig;

public class RegisterPageSteps extends AbstractPage{
	WebDriver driver;
	static String user, password;
	FakerConfig dataFaker;
	public RegisterPageSteps() {
		this.driver = Hooks.openAndQuitBrowser();
		dataFaker= FakerConfig.getFakerData();
	}
	@When("^Input to email textbox$")
	public void inputToEmailTextbox()  {
		waitToElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, dataFaker.getEmailAddress());

	}

	@When("^Click to submit$")
	public void clickToSubmit()  {
		waitToElementClickable(driver, RegisterPageUI.INPUT_SUBMIT);
		clickToElement(driver, RegisterPageUI.INPUT_SUBMIT);

	}

	@Then("^Get user and password infor$")
	public void getUserAndPasswordInfor()  {
		waitToElementVisible(driver, RegisterPageUI.USER_TEXT);
		waitToElementVisible(driver, RegisterPageUI.PASSWORD_TEXT);
		user = getElementText(driver, RegisterPageUI.USER_TEXT);
		password = getElementText(driver, RegisterPageUI.PASSWORD_TEXT);
	}

	@When("^Back to Login page$")
	public void backToLoginPage()  {
		openPageUrl(driver, LoginPageSteps.loginUrl);

	}


}
