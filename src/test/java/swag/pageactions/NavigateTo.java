package swag.pageactions;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.SilentTask;
import net.serenitybdd.screenplay.actions.Browser;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.Dimension;
import swag.models.Device;
import swag.pages.InventoryPage;
import swag.pages.LoginPage;
import swag.pages.ProductPage;

import static swag.stepdefinitions.Hooks.CONFIG;

@Slf4j
/**
 * @author bashaalixhan@gmail.com
 * */
public class NavigateTo {

    private static void setupBrowser() {
        Device currentDevice = CONFIG.getDeviceConfigurator().getDevice();
        Dimension deviceDimensions = new Dimension(currentDevice.getWidth(), currentDevice.getHeight() + 30);

        if (System.getProperty("orientation") != null && System.getProperty("orientation").equals("horizontal")) {
            deviceDimensions = new Dimension(currentDevice.getHeight(), currentDevice.getWidth() + 30);
        }

        log.debug("Using device => {}", currentDevice);
        Browser.setSize(deviceDimensions).performAs(OnStage.theActorInTheSpotlight());
    }

    public static Performable theLoginPage() {
        setupBrowser();
        return SilentTask.where(
                Open.browserOn().the(LoginPage.class)
        );
    }

    public static Performable theInventoryPage() {
        setupBrowser();
        Serenity.setSessionVariable("unauthorized").to(Boolean.TRUE);
        return SilentTask.where(
                Open.browserOn().the(InventoryPage.class)
        );
    }

    public static Performable theProductPage() {
        setupBrowser();
        Serenity.setSessionVariable("unauthorized").to(Boolean.TRUE);
        return SilentTask.where(
                Open.browserOn().the(ProductPage.class)
        );
    }
}
