package swag.pageactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Performable;
import swag.models.SwagItem;
import swag.pages.ProductPage;

import java.io.IOException;

public class ProductActions extends UIInteractions {

    private ProductPage product = new ProductPage();

    public Performable ensureProductIsDisplayedAndValidated() throws IOException {
        product.getItem().setItemDetails(
                SwagItem.getItemFromDataStore(Serenity.sessionVariableCalled("selected_product"))
        );
        return product.ensurePageHasLoaded();
    }

}
