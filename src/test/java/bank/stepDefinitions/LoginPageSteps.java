package bank.stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pageUIs.LoginPageUI;

public class LoginPageSteps extends AbstractPage{
	WebDriver driver;
	static String loginUrl;
	public LoginPageSteps() {
		this.driver = Hooks.openAndQuitBrowser();
	}
	@Given("^Get login page URL$")
	public void getLoginPageURL() {
		loginUrl = getCurrentPageUrl(driver);
	}
	@Given("^Open Register page$")
	public void openRegisterPage() {
		waitToElementClickable(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
	}
	@When("^Submit vaid infor to login form$")
	public void submitVaidInforToLoginForm()  {
		waitToElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX, RegisterPageSteps.user);
		
		waitToElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, RegisterPageSteps.password);
		
		waitToElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);

	}

}
