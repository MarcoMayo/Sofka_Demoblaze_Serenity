package stepsdefinitions;

import interactions.AlertAccept;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tasks.AddProduct;
import tasks.FillOrder;
import tasks.OpenPlaceOrder;
import userinterface.HomePage;
import userinterface.ShoppingCartPage;

public class ShoppingCartStepDefinition {


    private Actor UserQA;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        UserQA = OnStage.theActorCalled("Usuario QA");
    }
    @Given("the user is on the main page")
    public void theUserIsOnTheMainPage() {
        UserQA.attemptsTo(
                Open.url("https://www.demoblaze.com/index.html")
        );
    }
    @When("he add a product to the the shopping cart {string}")
    public void heAddAProductToTheTheShoppingCart(String product) {
        UserQA.attemptsTo(
                AddProduct.byName(product),
                AlertAccept.ok()
        );
    }
    @Then("he should see the product {string}")
    public void heShouldSeeTheProduct(String product) {
        UserQA.attemptsTo(
                Click.on(HomePage.CART_BUTTON),
                Ensure.that(ShoppingCartPage.PRODUCTS).text().contains(product)
        );
    }
    @When("he add multiple products to the cart {string} and {string}")
    public void heAddMultipleProductsToTheCartAnd(String product1, String product2) {
        UserQA.attemptsTo(
                AddProduct.byName(product1),
                AlertAccept.ok(),
                Click.on(HomePage.HOME_BUTTON),
                AddProduct.byName(product2),
                AlertAccept.ok()
        );
    }
    @When("he navigate to the shopping cart with no products")
    public void heNavigateToTheShoppingCartWithNoProducts() {
        UserQA.attemptsTo(
                Click.on(HomePage.CART_BUTTON)
        );
    }
    @Then("he can see that the cart is empty")
    public void heCanSeeThatTheCartIsEmpty() {
        UserQA.attemptsTo(
                WaitUntil.the(ExpectedConditions.invisibilityOf(ShoppingCartPage.PRODUCTS.resolveFor(UserQA))),
                Ensure.that(ShoppingCartPage.PRODUCTS).isNotDisplayed()
        );
    }
    @When("he remove a product from the cart")
    public void heRemoveAProductFromTheCart() {
        UserQA.attemptsTo(
                Click.on(HomePage.CART_BUTTON),
                Click.on(ShoppingCartPage.PRODUCT_DELETE)
        );
    }

    @When("he navigate to the shopping cart")
    public void heNavigateToTheShoppingCart() {
        UserQA.attemptsTo(
                Click.on(HomePage.CART_BUTTON)
        );
    }

    @Then("he should see the total {string}")
    public void heShouldSeeTheTotal(String total) {
        UserQA.attemptsTo(
                WaitUntil.the(ExpectedConditions.visibilityOf(ShoppingCartPage.TOTAL.resolveFor(UserQA))),
                Ensure.that(ShoppingCartPage.TOTAL).text().isEqualTo(total)
        );
    }

    @And("complete the purchase form")
    public void completeThePurchaseForm() {
        UserQA.attemptsTo(
                OpenPlaceOrder.forData(),
                FillOrder.data()
        );
    }

    @Then("he can see your successful order")
    public void heCanSeeYourSuccessfulOrder() {
        UserQA.attemptsTo(
                Ensure.that(ShoppingCartPage.DATA_ORDER).textContent().contains("1140")
        );
    }
}
