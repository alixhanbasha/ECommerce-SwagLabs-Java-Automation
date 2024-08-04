package swag.performables;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.Wait;

import java.util.stream.IntStream;

/**
 * @author bashaalixhan@gmail.com
 */
public class ListElements implements Performable {

    private ListOfWebElementFacades listOfWebElementFacades;

    public ListElements(ListOfWebElementFacades listOfWebElementFacades) {
        this.listOfWebElementFacades = listOfWebElementFacades;
    }

    public static ListElements ensure(ListOfWebElementFacades listOfWebElementFacades) {
        return Tasks.instrumented(ListElements.class, listOfWebElementFacades);
    }

    public ListElements areDisplayed() {
        return this;
    }

    @Override
    @Step("Ensure that all the elements in the list are displayed")
    public <T extends Actor> void performAs(T t) {
        IntStream.range(0, listOfWebElementFacades.size()).forEach(index -> {
            Wait.until(() -> listOfWebElementFacades.get(index).isDisplayed())
                    .performAs(t);

            Ensure.that(listOfWebElementFacades.get(index).isDisplayed()).isTrue()
                    .performAs(t);
        });
    }

    @Override
    public Performable then(Performable nextPerformable) {
        return Performable.super.then(nextPerformable);
    }
}
