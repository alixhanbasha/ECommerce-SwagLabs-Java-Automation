package swag.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import swag.pageactions.ShoppingCartActions;

public class ShoppingCartStepDefinitions {

    @Steps
    private ShoppingCartActions shoppingCart;


    @Then( "{actor} adds the {string} to the cart" )
    public void actorAddsTheProductToCart(Actor actor, String product ){
        // if the session variable that holds the amount of expected products is defined
        // it means that we used this method before, so all we do is increment the product by one
        if( Serenity.hasASessionVariableCalled("expected_products") ) {
            int numberOfProducts = Integer.parseInt(Serenity.sessionVariableCalled("expected_products").toString()) + 1;
            Serenity.setSessionVariable("expected_products")
                    .to(numberOfProducts);
        }
        // if the session variable is not defined, then we set its value to 1 since
        // there will only be one product in the cart
        else
            Serenity.setSessionVariable("expected_products").to(1);

        actor.wasAbleTo(
                shoppingCart.addProductToCart(product)
        );
    }

    @Then( "{actor} adds the following products to the cart" )
    public void actorAddsMultipleProductsToCart(Actor actor, DataTable products){
        products.asList().forEach(item -> this.actorAddsTheProductToCart(actor, item));
    }

}
