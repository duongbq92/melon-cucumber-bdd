package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/bank/features",
        glue = "bank.stepDefinitions",
//		dryRun = true,
		monochrome = true,
		plugin = {"pretty" ,"html:target/site/cucumber-report-default","json:target/stie/cucumber.json"},
		snippets = SnippetType.CAMELCASE,
		tags = {"@register"}
		)
public class BankTestRunner {

}
