package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ShoppingCartPage {

    public static final Target PRODUCTS = Target.the("Products in the shopping cart").locatedBy("//*[@id='tbodyid']/tr");
    public static final Target PRODUCT_DELETE = Target.the("Delete product").locatedBy("//*[@id='tbodyid']/tr//a[text()='Delete']");
    public static final Target TOTAL = Target.the("Total").located(By.id("totalp"));
    public static final Target PLACE_ORDER_BUTTON = Target.the("Place order").locatedBy("//*[@class='btn btn-success']");
    public static final Target NAME = Target.the("Name").located(By.id("name"));
    public static final Target COUNTRY = Target.the("Country").located(By.id("country"));
    public static final Target CITY = Target.the("City").located(By.id("city"));
    public static final Target CREDIT_CARD = Target.the("Credit card").located(By.id("card"));
    public static final Target MONTH = Target.the("Month").located(By.id("month"));
    public static final Target YEAR = Target.the("Year").located(By.id("year"));
    public static final Target PURCHASE_BUTTON = Target.the("Purchase").locatedBy("//*[@class='btn btn-primary' and contains(text(),'Purchase')]");
    public static final Target DATA_ORDER = Target.the("Data order").locatedBy("//*[@class='lead text-muted ']");

}
