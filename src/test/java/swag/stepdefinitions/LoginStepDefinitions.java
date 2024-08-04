package swag.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.screenplay.Actor;
import swag.pageactions.LoginActions;
import swag.pageactions.NavigateTo;

/**
 * @author bashaalixhan@gmail.com
 */
public class LoginStepDefinitions {

	@Steps
	private LoginActions login;

	@Given("{actor} is a user of Swag Labs")
	public void actorIsAUserOfSwagLabs( Actor actor ) {
		actor.wasAbleTo(
			NavigateTo.theLoginPage(),
			login.ensureIsDisplayedProperly()
		);
	}

	@When("{actor} logs in using correct credentials")
	public void actorLogsInWithCorrectCredentials( Actor actor ) {
		actor.attemptsTo(
			login.enterCorrectCredentials()
		);
	}

	@Given("{actor} has logged in")
	public void actorHasLoggedIn( Actor actor ) {
		actor.wasAbleTo(
			NavigateTo.theLoginPage(),
			login.ensureIsDisplayedProperly(),
			login.enterCorrectCredentials()
		);
	}

	@When("{actor} logs in using incorrect credentials")
	public void actorLogsInWithIncorrectCredentials( Actor actor ) {
		actor.attemptsTo(
			login.enterIncorrectCredentials()
		);
	}

	@Then("{actor} can see an error message")
	public void actorCanSeeAnErrorMessage( Actor actor ) {
		actor.wasAbleTo(
			login.seeThatErrorMessageForIncorrectLoginIsDisplayed()
		);
	}

}
