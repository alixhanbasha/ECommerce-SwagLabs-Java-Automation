package swag.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import swag.pageactions.InventoryActions;
import swag.pageactions.NavigationActions;
import swag.performables.FromElements;

/**
 * @author bashaalixhan@gmail.com
 * */
public class InventoryStepDefinitions {
	@Steps
	private InventoryActions inventory;

	@Steps
	private NavigationActions navigation;


	@Then( "{actor} can view the Inventory page" )
	public void actorCanViewTheInventoryPage( Actor actor ){
		actor.wasAbleTo(
			inventory.ensureIsDisplayedProperly()
		);
	}

	@When( "{actor} selects the product {string}" )
	public void actorSelectsAProduct(Actor actor, String product){
		Serenity.setSessionVariable("selected_product").to(product);
		actor.attemptsTo(
			inventory.selectAProduct( product )
		);
	}

	@Then( "{actor} adds the {string} to the cart" )
	public void actorAddsTheProductToCart( Actor actor, String product ){
		actor.wasAbleTo(
				inventory.addProductToCart(product)
		);
	}

	@Then( "{actor} adds the following products to the cart" )
	public void actorAddsMultipleProductsToCart( Actor actor, String product ){
		actor.wasAbleTo(
				inventory.addProductToCart(product)
		);
	}

}
