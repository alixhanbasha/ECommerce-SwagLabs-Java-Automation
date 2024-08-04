package swag.performables;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RemoveFromCart implements Performable {

    private String item;

    public RemoveFromCart(String item) {
        this.item = item;
    }

    public static RemoveFromCart theItem(String item) {
        return Tasks.instrumented(RemoveFromCart.class, item);
    }

    @Override
    @Step("{0} removes the item '#textContent' from cart")
    public <T extends Actor> void performAs(T t) {
        String lowercaseItemNameAsASlug = String.join("-", this.item.toLowerCase().split(" "));
        WebElement btn = Serenity.getDriver()
                .findElement(By.xpath("//button[@id='remove'] | //button[@id='remove-" + lowercaseItemNameAsASlug + "']"));
        Wait.until(btn::isDisplayed).performAs(t);
        Scroll.to(btn).performAs(t);
        btn.click();
    }

    @Override
    public Performable then(Performable nextPerformable) {
        return Performable.super.then(nextPerformable);
    }
}