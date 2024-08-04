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

    @Override
    public Performable ensureIsPresentAndDisplayed() {
        return Task.where(
                "Ensuring that the Shopping Cart component is present and displayed",
                Ensure.that(this.shoppingCartContainer).isDisplayed(),
                Ensure.that(this.shoppingCartLink).isDisplayed()
        );
    }
}
