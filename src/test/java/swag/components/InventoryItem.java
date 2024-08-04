package swag.components;

import lombok.Data;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import swag.lib.SwagComponent;
import swag.lib.TestExecutionFailedException;
import swag.models.SwagItem;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

@Data
public class InventoryItem extends SwagComponent {

    private Target itemContainer = Target.the("the item container")
            .locatedBy("//div[@data-test='inventory-item']");

    private Target itemImage = Target.the("the item image asset")
            .locatedBy(".inventory_details_img_container > img");

    private Target itemTitle = Target.the("the item title")
            .locatedBy("//div[@data-test='inventory-item-name']");

    private Target itemDescription = Target.the("the item description")
            .locatedBy("//div[@data-test='inventory-item-desc']");

    private Target itemPrice = Target.the("the item price")
            .locatedBy("//div[@data-test='inventory-item-price']");

    private Target addToCartButton = Target.the("the 'Add to cart' button")
            .locatedBy("#add-to-cart");

    private SwagItem itemDetails;


    @Override
    public Performable ensureIsPresentAndDisplayed() {
        if( this.itemDetails == null )
            throw new TestExecutionFailedException("You need to specify the item details. The details are required in order to assert values");

        return Task.where(
                "Ensuring that the product is displayed properly",
                WaitUntil.angularRequestsHaveFinished(),
                Wait.until(() -> this.itemImage.isVisibleFor(theActorInTheSpotlight())),
                Ensure.that(itemContainer).isDisplayed(),
                Ensure.that(this.itemTitle).textContent().containsIgnoringCase(this.itemDetails.getTitle()),
                Ensure.that(this.itemDescription).textContent().containsIgnoringCase(this.itemDetails.getDescription()),
                Ensure.that(this.itemPrice).textContent().contains(this.itemDetails.getPrice())
        );
    }
}
