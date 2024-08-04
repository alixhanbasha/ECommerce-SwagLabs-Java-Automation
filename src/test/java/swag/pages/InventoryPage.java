package swag.pages;

import lombok.Getter;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import swag.components.Footer;
import swag.components.Header;
import swag.lib.SwagPage;
import swag.performables.ListElements;

@Getter
/**
 * @author bashaalixhan@gmail.com
 * */
public class InventoryPage extends SwagPage {

    private Header header = new Header();

    private Footer footer = new Footer();

    private ListOfWebElementFacades products = Target.the("the list of products")
            .locatedBy("//div[@class='inventory_item_label']/a")
            .resolveAllFor(OnStage.theActorInTheSpotlight());

    @Override
    public Performable ensurePageHasLoaded() {
        return Task.where(
                "Ensuring that the inventory page is present and displayed",
                WaitUntil.angularRequestsHaveFinished(),
                this.header.ensureIsPresentAndDisplayed(),
                ListElements.ensure(products).areDisplayed(),
                this.footer.ensureIsPresentAndDisplayed()
        );
    }
}
