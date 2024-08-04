package swag.pages;

import lombok.Getter;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import swag.components.Footer;
import swag.components.Header;
import swag.components.InventoryItem;
import swag.lib.SwagPage;

@Getter
@DefaultUrl("https://www.saucedemo.com/inventory-item.html")
/**
 * @author bashaalixhan@gmail.com
 */
public class ProductPage extends SwagPage {

    private Header header = new Header();

    private Target backToProducts = Target.the("the back to products button")
            .locatedBy("#back-to-products");

    private InventoryItem item = new InventoryItem();

    private Footer footer = new Footer();

    @Override
    public Performable ensurePageHasLoaded() {
        return Task.where(
                "Checking that the product page is displayed properly",
                WaitUntil.angularRequestsHaveFinished(),
                this.header.ensureIsPresentAndDisplayed(),
                Ensure.that(this.backToProducts).isDisplayed(),
                this.item.ensureIsPresentAndDisplayed(),
                this.footer.ensureIsPresentAndDisplayed()
        );
    }
}
