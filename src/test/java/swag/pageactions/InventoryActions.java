package swag.pageactions;

import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Performable;
import swag.pages.InventoryPage;
import swag.performables.FromElements;

/**
 * @author bashaalixhan@gmail.com
 */
public class InventoryActions extends UIInteractions {
    private InventoryPage inventory = new InventoryPage();

    public Performable ensureIsDisplayedProperly() {
        return inventory.ensurePageHasLoaded();
    }

    public Performable selectAProduct(String product) {
        return FromElements.in(inventory.getProducts()).select(product);
    }

}
