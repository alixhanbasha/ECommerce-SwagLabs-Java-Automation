package swag.pageactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
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

    public Performable goBackToInventoryPage(){
        return Task.where(
                "Going back to the Inventory Page",
                Click.on(this.product.getBackToProducts()),
                WaitUntil.angularRequestsHaveFinished()
        );
    }

}
