package swag.performables;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;

import java.util.List;
import java.util.stream.IntStream;

/**
 * @author bashaalixhan@gmail.com
 * */
public class ListValidator implements Performable {

	private List<String> listOfStrings;
	private Target elements;

	public ListValidator( List<String> listOfStrings, Target listOfWebElementFacades ) {
		this.listOfStrings = listOfStrings;
		this.elements = listOfWebElementFacades;
	}

	public static ListValidator match( List<String> listOfStrings ) {
		return Tasks.instrumented( ListValidator.class, listOfStrings, null );
	}

	public ListValidator against( Target listOfWebElementFacades){
		this.elements = listOfWebElementFacades;
		return this;
	}

	@Override
	@Step("{0} validates that the list of web-elements matches #listOfStrings")
	public <T extends Actor> void performAs( T t ) {
		ListOfWebElementFacades listOfWebElementFacades = this.elements.resolveAllFor(t);

		IntStream.range( 0, listOfWebElementFacades.size() ).forEach( (index ) -> {
			Wait.until( () -> listOfWebElementFacades.get( index )
					.isDisplayed() ).performAs(t);
			Ensure.that( listOfWebElementFacades.get( index ).getText() )
					.containsIgnoringCase( listOfStrings.get( index ) ).performAs(t);
		} );
	}

	@Override
	public Performable then( Performable nextPerformable ) {
		return Performable.super.then( nextPerformable );
	}
}