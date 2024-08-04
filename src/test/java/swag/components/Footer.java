package swag.components;

import lombok.Getter;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import swag.lib.SwagComponent;
import swag.performables.ListValidator;

import java.util.Arrays;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

@Getter
/**
 * <p>
 *    The footer component for Swag Labs
 * </p>
 * @author bashaalixhan@gmail.com
 * */

public class Footer extends SwagComponent {

    private Target footer = Target.the("the swag labs footer")
            .locatedBy("//footer");

    private Target footerCopy = Target.the("the footer copy")
            .locatedBy("//div[@data-test='footer-copy']");

    private Target socialLinks = Target.the("the social links in the footer")
            .locatedBy("//a[contains(concat('', normalize-space(@data-test)), 'social')]");

    @Override
    public Performable ensureIsPresentAndDisplayed() {
        return Task.where(
                "Ensuring the footer is present and displayed",
                Ensure.that(this.footer).isDisplayed(),
                Ensure.that(this.footerCopy).isDisplayed(),
                Ensure.that(this.footerCopy).textContent().containsIgnoringCase("© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy"),
                ListValidator.match(Arrays.asList("Twitter", "Facebook", "LinkedIn")).against(socialLinks)
        );
    }
}
