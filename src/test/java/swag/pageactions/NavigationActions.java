package swag.pageactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.SilentTask;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.Wait;
import swag.components.NavigationMenu;
import swag.performables.FromElements;

public class NavigationActions extends UIInteractions {

	private NavigationMenu navigationMenu = new NavigationMenu();

	private Performable goToPageFromNavigation( String page ) {
		return SilentTask.where(
			Click.on( navigationMenu.getOpenMenu() ),

			Wait.until( () -> navigationMenu.getMenuContainer()
				.isVisibleFor( OnStage.theActorInTheSpotlight() ) ),

			FromElements.in( navigationMenu.getNavigationLinks().resolveAllFor( OnStage.theActorInTheSpotlight() ) )
				.select( page )
		);
	}

	@Step("Log out of swag labs")
	public Performable goToLogOut() {
		return Task.where( "Logging out of Swag Labs", this.goToPageFromNavigation( "Logout" ) );
	}

	@Step("Open All Items")
	public Performable goToAllItems() {
		return Task.where( "Showcasing all the items", this.goToPageFromNavigation( "All Items" ) );
	}

	@Step("Open About")
	public Performable goToAbouts() {
		return Task.where( "Redirecting to the About", this.goToPageFromNavigation( "About" ) );
	}

	@Step("Open About")
	public Performable clickResetAppState() {
		return Task.where( "Resenting app state", this.goToPageFromNavigation( "Reset App State" ) );
	}
}
