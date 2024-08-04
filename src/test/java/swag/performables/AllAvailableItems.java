package swag.performables;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import swag.lib.TestExecutionFailedException;
import swag.models.SwagItem;

import java.io.IOException;
import java.util.stream.IntStream;

/**
 * @author bashaalixhan@gmail.com
 */
public class AllAvailableItems implements Performable {

    private ListOfWebElementFacades listOfWebElementFacades;

    public AllAvailableItems(ListOfWebElementFacades listOfWebElementFacades) {
        this.listOfWebElementFacades = listOfWebElementFacades;
    }

    public static AllAvailableItems ensure(ListOfWebElementFacades listOfWebElementFacades) {
        return Tasks.instrumented(AllAvailableItems.class, listOfWebElementFacades);
    }

    public AllAvailableItems areDisplayed() {
        return this;
    }

    @Override
    @Step("Ensure that all the elements in the list are displayed and valid")
    public <T extends Actor> void performAs(T t) {
        IntStream.range(0, listOfWebElementFacades.size()).forEach(index -> {
            Wait.until(() -> listOfWebElementFacades.get(index).isDisplayed())
                    .performAs(t);

            Ensure.that(listOfWebElementFacades.get(index).isDisplayed()).isTrue()
                    .performAs(t);

            try {
                SwagItem item = SwagItem.getItemFromDataStore(listOfWebElementFacades.get(index).getText());

                // Get the item defined in the list, navigate to the parent that holds all the data
                // then ensure that the data present in the UI matches what is defined in the items.json
                WebElement inventoryItemDescription = listOfWebElementFacades.get(index)
                        .findElement(By.xpath("../..")); // <div class="inventory_item_description" data-test="inventory-item-description">

                // get the item description element, and validate the content
                Ensure.that(inventoryItemDescription.findElement(By.xpath("div[@class='inventory_item_label']/div")).getText())
                        .containsIgnoringCase(item.getDescription())
                        .performAs(t);

                // get the item price element, and validate the content
                Ensure.that(inventoryItemDescription.findElement(By.xpath("div[@class='pricebar']/div")).getText())
                        .containsIgnoringCase(item.getPrice())
                        .performAs(t);

                // get the "Add to cart" button, and validate that its present
                Ensure.that(inventoryItemDescription.findElement(By.xpath("div[@class='pricebar']/button")).isDisplayed())
                        .isTrue()
                        .performAs(t);

            } catch (IOException e) {
                throw new TestExecutionFailedException("Failed to validate item content. " + e);
            }
        });
    }

    @Override
    public Performable then(Performable nextPerformable) {
        return Performable.super.then(nextPerformable);
    }
}
