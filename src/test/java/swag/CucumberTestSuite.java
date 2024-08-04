package swag;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * @author bashaalixhan@gmail.com
 * */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
	plugin = {
		"pretty",
		"html:target/cucumber.html",
		"json:target/cucumber.json"
	},
	glue = "classpath:swag.stepdefinitions",
	features = "src/test/resources/features",
	tags = "not @wip"
)
public class CucumberTestSuite {}
