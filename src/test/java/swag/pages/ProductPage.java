package swag.pages;

import lombok.Getter;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import swag.components.Header;
import swag.components.InventoryItem;
import swag.lib.SwagPage;

@Getter
public class ProductPage extends SwagPage {

    private Header header = new Header();

    private InventoryItem item = new InventoryItem();

    @Override
    public Performable ensurePageHasLoaded() {
        return Task.where(
                "Checking that the product page is displayed properly",
                WaitUntil.angularRequestsHaveFinished(),
                header.ensureIsPresentAndDisplayed(),
                item.ensureIsPresentAndDisplayed()
        );
    }
}
