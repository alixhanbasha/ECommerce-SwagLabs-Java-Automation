package swag.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.actors.OnStage;
import swag.config.ProjectConfigurator;
import swag.models.SwagItem;
import swag.pageactions.NavigationActions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
/**
 * @author bashaalixhan@gmail.com
 * */
public class Hooks {
	public static final ProjectConfigurator CONFIG = new ProjectConfigurator(
		"src/test/resources/project_configuration.json"
	);

	@BeforeAll
	public static void willRunBeforeAll() throws IOException {
		log.debug( "Initializing config..." );
		CONFIG.useDevice(
			System.getProperty( "device" ) != null
				? System.getProperty( "device" )
				: "iPhone 11 Pro" // use this by default
		);
		CONFIG.initialize();
	}

	@After
	public static void willRunAfterTheScenario(){
		new NavigationActions().clickResetAppState().performAs(OnStage.theActorInTheSpotlight());
	}

}
