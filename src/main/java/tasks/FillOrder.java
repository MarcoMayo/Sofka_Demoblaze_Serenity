package tasks;

import data.DataUser;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import userinterface.ShoppingCartPage;

public class FillOrder implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        DataUser dataUser = new DataUser();
        User user = dataUser.newUser();


        actor.attemptsTo(
                SendKeys.of(user.getName()).into(ShoppingCartPage.NAME),
                SendKeys.of(user.getCountry()).into(ShoppingCartPage.COUNTRY),
                SendKeys.of(user.getCity()).into(ShoppingCartPage.CITY),
                SendKeys.of(user.getCreditCard()).into(ShoppingCartPage.CREDIT_CARD),
                SendKeys.of(user.getMonth()).into(ShoppingCartPage.MONTH),
                SendKeys.of(user.getYear()).into(ShoppingCartPage.YEAR),
                Click.on(ShoppingCartPage.PURCHASE_BUTTON)
        );
    }

    public static FillOrder data(){
        return Tasks.instrumented(FillOrder.class);
    }

}
