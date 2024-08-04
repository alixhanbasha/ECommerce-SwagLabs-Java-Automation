package swag.pageactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.SilentTask;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import swag.pages.LoginPage;

/**
 * @author bashaalixhan@gmail.com
 * */
public class LoginActions extends UIInteractions {

	private LoginPage login = new LoginPage();

	@Step("Check that login page is present and displayed")
	public Performable ensureIsDisplayedProperly() {
		return login.ensurePageHasLoaded();
	}

	@Step("User attempts to login with correct credentials")
	public Performable enterCorrectCredentials() {
		return Task.where(
			"{0} logs in with correct credentials",
			Enter.theValue( "standard_user" ).into( login.getUsernameInputField() ),
			Enter.theValue( "secret_sauce" ).into( login.getPasswordInputField() ),
			Click.on( login.getLoginButton() )
		);
	}

	@Step("User attempts to login with incorrect credentials")
	public Performable enterIncorrectCredentials() {
		return Task.where(
			"{0} logs in with incorrect credentials",
			Enter.theValue( "locked_out_user" ).into( login.getUsernameInputField() ),
			Enter.theValue( "secret_sauce" ).into( login.getPasswordInputField() ),
			Click.on( login.getLoginButton() )
		);
	}

	@Step("User is presented with an error message")
	public Performable seeThatErrorMessageForIncorrectLoginIsDisplayed(){
		return Task.where(
			"{0} can see the error message 'Epic sadface: Sorry, this user has been locked out.'",
			Wait.until( () -> login.getErrorMessage().isVisibleFor( OnStage.theActorInTheSpotlight() ) ),
			Ensure.that( login.getErrorMessage() ).hasTextContent( "Epic sadface: Sorry, this user has been locked out."  )
		);
	}

	@Step("User is presented with an error message")
	public Performable seeThatErrorIsDisplayed(String message){
		return Task.where(
				"{0} can see the error message 'Epic sadface: " + message + "'",
				Wait.until( () -> login.getErrorMessage().isVisibleFor( OnStage.theActorInTheSpotlight() ) ),
				Ensure.that( login.getErrorMessage() ).hasTextContent( "Epic sadface: " + message  )
		);
	}

}
