package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import userinterface.HomePage;
import userinterface.ShoppingCartPage;

public class OpenPlaceOrder implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.CART_BUTTON),
                Click.on(ShoppingCartPage.PLACE_ORDER_BUTTON)
        );
    }

    public static OpenPlaceOrder forData(){
        return Tasks.instrumented(OpenPlaceOrder.class);
    }

}
