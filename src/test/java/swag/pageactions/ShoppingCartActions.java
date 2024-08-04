package swag.pageactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import swag.components.Cart;
import swag.performables.ShoppingCart;

/**
 * @author bashaalixhan@gmail.com
 */
public class ShoppingCartActions extends UIInteractions {

    public Performable openCart(){
        return Task.where(
                "Opening shopping cart",
                Click.on(new Cart().getShoppingCartLink()),
                WaitUntil.angularRequestsHaveFinished()
        );
    }

    public Performable addProductToCart(String product) {
        return Task.where(
                "Adding a product to the cart, and validating that the amount is valid",
                ShoppingCart.addItem(product),
                new Cart().shouldHaveItems(
                        Serenity.sessionVariableCalled("expected_products").toString()
                )
        );
    }

    public Performable removeProductFromCart(String product) {
        return ShoppingCart.removeItem(product);
    }

}