package swag.components;

import lombok.Getter;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import swag.lib.SwagComponent;

@Getter
/**
 * <p>
 *    The header component for Swag Labs
 * </p>
 * @author bashaalixhan@gmail.com
 * */
public class Header extends SwagComponent {

	private Target headerContainer = Target.the( "the header container" )
		.locatedBy( "#header_container" );

	private Target primaryHeader = Target.the( "the primary header" )
		.locatedBy( ".primary_header" );

	private Target appLogo = Target.the( "the app logo" )
		.locatedBy( ".app_logo" );

	private Cart shoppingCart = new Cart();

	private NavigationMenu navigationMenu = new NavigationMenu();

	@Override
	public Performable ensureIsPresentAndDisplayed() {
		return Task.where(
			"Ensure that the header is present and displayed",
			Ensure.that( headerContainer ).isDisplayed(),
			Ensure.that( primaryHeader ).isDisplayed(),
			Ensure.that( appLogo ).isDisplayed(),
			shoppingCart.ensureIsPresentAndDisplayed(),
			navigationMenu.ensureIsPresentAndDisplayed()
		);
	}
}
