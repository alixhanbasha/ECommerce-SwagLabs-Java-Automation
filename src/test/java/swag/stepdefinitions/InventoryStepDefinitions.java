package swag.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import swag.pageactions.InventoryActions;
import swag.pageactions.NavigateTo;
import swag.pageactions.NavigationActions;

/**
 * @author bashaalixhan@gmail.com
 */
public class InventoryStepDefinitions {
    @Steps
    private InventoryActions inventory;

    @Steps
    private NavigationActions navigation;

    @Given("{actor} navigates to the Inventory page without logging in")
    public void actorNavigatesToTheInventoryPageWithoutLoggingIn(Actor actor) {
        actor.attemptsTo(NavigateTo.theInventoryPage());
    }


    @Then("{actor} can view the Inventory page")
    public void actorCanViewTheInventoryPage(Actor actor) {
        actor.wasAbleTo(
                inventory.ensureIsDisplayedProperly()
        );
    }

    @When("{actor} selects the product {string}")
    public void actorSelectsAProduct(Actor actor, String product) {
        Serenity.setSessionVariable("selected_product").to(product);
        actor.attemptsTo(
                inventory.selectAProduct(product)
        );
    }

}
