package swag.stepdefinitions;

import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.screenplay.Actor;
import swag.pageactions.NavigationActions;
import swag.pageactions.ProductActions;

import java.io.IOException;

public class ProductStepDefinitions {

    @Steps
    private ProductActions product = new ProductActions();

    @Steps
    private NavigationActions navigation;

    @Then( "{actor} is redirected to the product page" )
    public void actorIsRedirectedToTheProductPage(Actor actor) throws IOException {
        actor.wasAbleTo(
                product.ensureProductIsDisplayedAndValidated()
        );
    }

}
