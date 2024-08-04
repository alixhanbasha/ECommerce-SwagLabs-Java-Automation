package swag.pages;

import lombok.Getter;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import swag.lib.SwagPage;

@Getter
@DefaultUrl("https://www.saucedemo.com/")
/**
 * @author bashaalixhan@gmail.com
 * */
public class LoginPage extends SwagPage {

    private Target pageTitle = Target.the("the Swag Labs title")
            .locatedBy(".login_logo");

    private Target loginFormContainer = Target.the("the login form container")
            .locatedBy("#login_button_container");

    private Target usernameInputField = Target.the("the username input field")
            .locatedBy("#user-name");

    private Target passwordInputField = Target.the("the password input field")
            .locatedBy("#password");

    private Target loginButton = Target.the("the login button")
            .locatedBy("#login-button");

    private Target errorMessage = Target.the("the error message")
            .locatedBy("//h3[@data-test='error']");


    @Override
    public Performable ensurePageHasLoaded() {
        return Task.where(
                "Ensuring Login page is loaded properly",
                WaitUntil.angularRequestsHaveFinished(),
                Wait.until(() -> this.pageTitle.isVisibleFor(OnStage.theActorInTheSpotlight())),
                Ensure.that(TheWebPage.title()).containsIgnoringCase("Swag Labs"),
                Ensure.that(getPageTitle()).isDisplayed(),
                Ensure.that(getPageTitle()).hasTextContent("Swag Labs"),
                Ensure.that(getLoginFormContainer()).isDisplayed(),
                Ensure.that(getUsernameInputField()).isDisplayed(),
                Ensure.that(getPasswordInputField()).isDisplayed(),
                Ensure.that(getLoginButton()).isDisplayed()
        );
    }
}
