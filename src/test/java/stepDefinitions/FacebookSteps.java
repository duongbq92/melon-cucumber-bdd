package stepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookSteps {
	WebDriver driver;
	
	@Before("@parameter")
	public void openFacebook()  {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	@Given("^Open Facebook application$")
	public void openFacebookApplication()  {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	}
	
	@After("@parameter")
	public void closeBrowser()  {
		driver.quit();
		
	}
	@And("Close application$")
	public void closeApplication()  {
		driver.quit();
	    
	}

	@Then("^Verify email textbox is displayed$")
	public void verifyEmailTextboxIsDisplayed()  {
	    Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());
	    
	}

	@And("^Verify password textbox is displayed$")
	public void verifyPasswordTextboxIsDisplayed()  {
		Assert.assertTrue(driver.findElement(By.id("pass")).isDisplayed());
	    
	}
	@When("^Input email textbox with \"([^\"]*)\"$")
	public void inputEmailTextboxWith(String emailTxt)  {
		driver.findElement(By.id("email")).sendKeys(emailTxt);
	}

	@When("^Input password textbox with \"([^\"]*)\"$")
	public void inputPasswordTextboxWith(String password)  {
		driver.findElement(By.id("pass")).sendKeys(password);
	}
	@When("^Input email textbox with ([^\"]*)$")
	public void inputEmailTextbox(String emailTxt)  {
		driver.findElement(By.id("email")).sendKeys(emailTxt);
	}

	@When("^Input password textbox with ([^\"]*)$")
	public void inputPasswordTextbox(String password)  {
		driver.findElement(By.id("pass")).sendKeys(password);
	}
	@When("^Click to Submit button$")
	public void clickToSubmitButton()  {
		driver.findElement(By.name("login")).click();
	}
	
	
	@When("^Input email and pass textbox$")
	public void inputEmailAndPassTextbox(DataTable table)  {
	    List<Map<String, String>> myList = table.asMaps(String.class, String.class);
//	    driver.findElement(By.id("email")).clear();
//	    driver.findElement(By.id("email")).sendKeys(myList.get(0).get("Username"));
//	    
//	    driver.findElement(By.id("pass")).clear();
//	    driver.findElement(By.id("pass")).sendKeys(myList.get(0).get("Password"));
	    for (Map<String, String> map : myList) {
	    	driver.findElement(By.id("email")).clear();
		    driver.findElement(By.id("email")).sendKeys(map.get("Username"));
		    
		    driver.findElement(By.id("pass")).clear();
		    driver.findElement(By.id("pass")).sendKeys(map.get("Password"));
		}
	}

}
