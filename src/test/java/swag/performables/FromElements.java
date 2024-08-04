package swag.performables;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.Wait;
import org.openqa.selenium.By;

import java.util.function.Function;

/**
 * @author bashaalixhan@gmail.com
 */
public class FromElements implements Performable {

    private String textContent;
    private ListOfWebElementFacades listOfWebElementFacades;

    public FromElements(ListOfWebElementFacades listOfWebElementFacades, String textContent) {
        this.listOfWebElementFacades = listOfWebElementFacades;
        this.textContent = textContent;
    }

    public static FromElements in(ListOfWebElementFacades elements) {
        return Tasks.instrumented(FromElements.class, elements, null);
    }

    public FromElements select(String containing) {
        this.textContent = containing;
        return this;
    }

    @Override
    @Step("{0} selects the element containing '#textContent'")
    public <T extends Actor> void performAs(T t) {
        WebElementFacade element = this.listOfWebElementFacades
                .filter(webElementFacade -> {
                    Wait.until(webElementFacade::isDisplayed).performAs(t);
                    return webElementFacade.containsText(this.textContent);
                })
                .getFirst();

        Scroll.to(element).performAs(t);
        Click.on(element).performAs(t);
    }

    @Override
    public Performable then(Performable nextPerformable) {
        return Performable.super.then(nextPerformable);
    }
}