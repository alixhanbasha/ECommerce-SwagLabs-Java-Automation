package swag.components;

import lombok.Getter;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import swag.lib.SwagComponent;

@Getter
/**
 * <p>
 *    The cart component present in the header
 * </p>
 * @author bashaalixhan@gmail.com
 * */
public class Cart extends SwagComponent {

    private Target shoppingCartContainer = Target.the( "the shopping cart container" )
            .locatedBy( "#shopping_cart_container" );

    private Target shoppingCartLink = Target.the( "the shopping cart link" )
            .locatedBy( ".shopping_cart_link" );

    private Target shoppingCartLinkBadge = Target.the( "the shopping cart link badge" )
            .locatedBy( ".shopping_cart_link > span.shopping_cart_badge" );

    public Performable shouldHaveItems(String numberOfItems){
        if( Integer.parseInt(numberOfItems) <= 0 )
            return Task.where("There should be no items in the cart");

        return Task.where(
                "There should be " + numberOfItems + " item/s in the shopping cart",
                Ensure.that(this.shoppingCartLinkBadge).isDisplayed(),
                Ensure.that(this.shoppingCartLinkBadge).hasText(numberOfItems)
        );
    }

    @Override
    public Performable ensureIsPresentAndDisplayed() {
        return Task.where(
                "Ensuring that the Shopping Cart component is present and displayed",
                Ensure.that(this.shoppingCartContainer).isDisplayed(),
                Ensure.that(this.shoppingCartLink).isDisplayed()
        );
    }
}
