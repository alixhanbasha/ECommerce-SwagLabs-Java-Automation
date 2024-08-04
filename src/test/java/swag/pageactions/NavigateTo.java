package swag.pageactions;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.SilentTask;
import net.serenitybdd.screenplay.actions.Browser;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.Dimension;
import swag.models.Device;
import swag.pages.LoginPage;

import static swag.stepdefinitions.Hooks.CONFIG;

@Slf4j
/**
 * @author bashaalixhan@gmail.com
 * */
public class NavigateTo {
	public static Performable theLoginPage() {
		Device currentDevice = CONFIG.getDeviceConfigurator().getDevice();
		Dimension deviceDimensions = new Dimension( currentDevice.getWidth(), currentDevice.getHeight() + 30 );

		if ( System.getProperty( "orientation" ) != null && System.getProperty( "orientation" ).equals( "horizontal" ) ) {
			deviceDimensions = new Dimension( currentDevice.getHeight(), currentDevice.getWidth() + 30 );
		}

		log.debug( "Using device => {}", currentDevice );
		return SilentTask.where(
			Browser.setSize( deviceDimensions ),
			Open.browserOn().the( LoginPage.class )
		);
	}
}
