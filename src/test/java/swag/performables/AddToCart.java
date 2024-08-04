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

public class AddToCart implements Performable {

    private String item;

    public AddToCart(String item) {
        this.item = item;
    }

    public static AddToCart theItem(String item) {
        return Tasks.instrumented(AddToCart.class, item);
    }

    @Override
    @Step("{0} adds the item '#textContent' to cart")
    public <T extends Actor> void performAs(T t) {
        String lowercaseItemName = String.join("-", this.item.toLowerCase().split(" "));
        WebElement btn = Serenity.getDriver()
                .findElement(By.xpath("//button[@id='add-to-cart'] | //button[@id='add-to-cart-" + lowercaseItemName + "']"));
        Wait.until(btn::isDisplayed).performAs(t);
        Scroll.to(btn).performAs(t);
        btn.click();
    }

    @Override
    public Performable then(Performable nextPerformable) {
        return Performable.super.then(nextPerformable);
    }
}