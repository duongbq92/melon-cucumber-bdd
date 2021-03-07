package bank.stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pageUIs.CommonPageUI;
import utilities.FakerConfig;

public class CommonPageSteps extends AbstractPage{
	WebDriver driver;
	FakerConfig dataFaker;
	String email;
	public CommonPageSteps() {
		this.driver = Hooks.openAndQuitBrowser();
		dataFaker =FakerConfig.getFakerData();
		email = dataFaker.getEmailAddress();
	}
	@Given("^Open \"([^\"]*)\" page$")
	public void openPage(String pageName) {
	    waitToElementClickable(driver,  CommonPageUI.DYNAMIC_LINK, pageName);
	    clickToElement(driver, CommonPageUI.DYNAMIC_LINK, pageName);
	    
	}

	@When("^Input to \"([^\"]*)\" textbox with value \"([^\"]*)\"$")
	public void inputToTextboxWithValue(String fieldName, String value) {
	    waitToElementVisible(driver, CommonPageUI.DYNAMIC_TEXTBOX, fieldName);
	    if(fieldName.equals("Date of Birth")) {
	    	removeAttributeInDOM(driver,  CommonPageUI.DYNAMIC_TEXTBOX, "type", fieldName);
	    	sleepInSecond(1);
	    }
	    else if(fieldName.equals("E-mail")) {
	    	sendkeyToElement(driver,  CommonPageUI.DYNAMIC_TEXTBOX,email, fieldName );
	    }
	    sendkeyToElement(driver,  CommonPageUI.DYNAMIC_TEXTBOX,value, fieldName );
	    
	}

	@When("^Click to \"([^\"]*)\" radio button$")
	public void clickToRadioButton(String radioBtnValue) {
	    waitToElementClickable(driver,CommonPageUI.DYNAMIC_RADIO_BUTTON,radioBtnValue);
	    clickToElement(driver,CommonPageUI.DYNAMIC_RADIO_BUTTON,radioBtnValue);
	    
	}

	@When("^Input to \"([^\"]*)\" textarea with value \"([^\"]*)\"$")
	public void inputToTextareaWithValue(String fieldName, String value) {
		waitToElementVisible(driver, CommonPageUI.DYNAMIC_TEXTAREA, fieldName);
	    sendkeyToElement(driver,  CommonPageUI.DYNAMIC_TEXTAREA,value, fieldName );
	    
	}

	@When("^Click to \"([^\"]*)\" button$")
	public void clickToButton(String buttonValue) {
		waitToElementClickable(driver,CommonPageUI.DYNAMIC_BUTTON,buttonValue);
	    clickToElement(driver,CommonPageUI.DYNAMIC_BUTTON,buttonValue);
	    
	}

	@Then("^Succes message display with \"([^\"]*)\"$")
	public void succesMessageDisplayWith(String expMessage) {
	    assertTrue(isElementDisplayed(driver,CommonPageUI.DYNAMIC_MESSAGE ,expMessage));
	    
	}

	@Then("^The valid value display at \"([^\"]*)\" with \"([^\"]*)\"$")
	public void theValidValueDisplayAtWith(String rowName, String expValue) {
	    waitToElementVisible(driver, CommonPageUI.DYNAMIC_VALUE_BY_ROW_NAME, rowName);
	    if(rowName.equals("Email")) {
	    	expValue = email;
	    }
	    assertEquals(getElementText(driver, CommonPageUI.DYNAMIC_VALUE_BY_ROW_NAME, rowName),expValue);
	    
	}

}
