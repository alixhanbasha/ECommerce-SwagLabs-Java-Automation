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
import swag.components.Cart;

public class ShoppingCart implements Performable {

    private String item;
    private String condition;
    private Cart shoppingCart;

    public ShoppingCart(String item, String condition) {
        this.shoppingCart = new Cart();
        this.item = item;
        this.condition = condition;
    }

    @Step("{0} adds the item '#textContent' to cart")
    public static ShoppingCart addItem(String item) {
        return Tasks.instrumented(ShoppingCart.class, item, "add");
    }

    @Step("{0} remove the item '#textContent' from cart")
    public static ShoppingCart removeItem(String item) {
        return Tasks.instrumented(ShoppingCart.class, item, "remove");
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        String id = this.condition.equals("add")
            ? "add-to-cart"
            : "remove";
        String lowercaseItemName = String.join("-", this.item.toLowerCase().split(" "));

        WebElement btn = Serenity.getDriver()
                .findElement(By.xpath("//button[@id='" + id + "'] | //button[@id='" + id + "-" + lowercaseItemName + "']"));
        Wait.until(btn::isDisplayed).performAs(t);
        Scroll.to(btn).performAs(t);
        btn.click();
    }

    @Override
    public Performable then(Performable nextPerformable) {
        return Performable.super.then(nextPerformable);
    }
}