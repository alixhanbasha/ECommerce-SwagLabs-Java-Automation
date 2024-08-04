package swag.components;

import lombok.Getter;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;
import swag.lib.SwagComponent;
import swag.performables.ListValidator;

import java.util.Arrays;
import java.util.List;

@Getter
/**
 * @author bashaalixhan@gmail.com
 * */
public class NavigationMenu extends SwagComponent {

    private static final List<String> NAVBAR_LINKS = Arrays.asList(
            "All Items", "About", "Logout", "Reset App State"
    );

    private Target openMenu = Target.the("the menu toggle button")
            .locatedBy("#react-burger-menu-btn");

    private Target closeMenu = Target.the("the X button")
            .locatedBy("#react-burger-cross-btn");

    private Target menuContainer = Target.the("the menu container")
            .locatedBy(".bm-menu-wrap");

    // ListOfWebElementFacade
    private Target navigationLinks = Target.the("the navigation links")
            .locatedBy("//nav/a");

    @Override
    public Performable ensureIsPresentAndDisplayed() {
        return Task.where(
                "Ensure that the navigation menu is present and displayed",
                Ensure.that(openMenu).isDisplayed(),
                Click.on(openMenu),
                Wait.until(() -> menuContainer.isVisibleFor(OnStage.theActorInTheSpotlight())),
                ListValidator.match(NAVBAR_LINKS).against(navigationLinks),
                Click.on(closeMenu)
        );
    }
}