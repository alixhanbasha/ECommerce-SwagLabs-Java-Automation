package swag.lib;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Performable;

/**
 * @author bashaalixhan@gmail.com
 * */
public abstract class SwagComponent extends PageObject {
	public abstract Performable ensureIsPresentAndDisplayed();
}
