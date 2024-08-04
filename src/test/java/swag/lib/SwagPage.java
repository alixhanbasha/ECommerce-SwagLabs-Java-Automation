package swag.lib;

import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.pages.PageObject;

public abstract class SwagPage extends PageObject {
    public abstract Performable ensurePageHasLoaded();
}
