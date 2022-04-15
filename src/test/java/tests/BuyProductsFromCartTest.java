package tests;

import base.TestUtils;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import utils.CsvHelper;

import java.io.IOException;

public class BuyProductsFromCartTest extends TestUtils {

    @DataProvider(name = "products")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/products.csv");
    }

    @Test(dataProvider = "products")
    public void BuyProductsFromCart(String userName, String password, String product1, String product2){

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login(userName, password);

        YourCartPage cartPage = new YourCartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(driver);
        CompleteOrderPage completeOrderPage = new CompleteOrderPage(driver);

        productsPage.addItemToTheCart(product1);
        productsPage.addItemToTheCart(product2);
        productsPage.MoveToCheckoutPage();
        cartPage.Checkout();
        checkoutPage.Checkout();
        overviewPage.Checkout();
        completeOrderPage.thanksMessage();

    }

}
