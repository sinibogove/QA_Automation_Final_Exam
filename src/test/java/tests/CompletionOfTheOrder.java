package tests;

import base.TestUtils;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import utils.CsvHelper;
import java.io.IOException;

public class CompletionOfTheOrder extends TestUtils {

    @DataProvider(name = "clientData")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/clientData.csv");
    }
    @Test(dataProvider = "clientData")
    public void completeTheOrder(String userName, String password, String product1, String product2, String firstName, String lastName, String postCode){

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login(userName, password);
        productsPage.addItemToTheCart(product1);
        productsPage.addItemToTheCart(product2);
        YourCartPage yourCartPage = productsPage.moveToYourCartPage();
        YourDataInfoPage yourDataInfoPage = yourCartPage.checkout();
        CheckoutOverviewPage checkoutOverviewPage = yourDataInfoPage.fillYourData(firstName,lastName,postCode);
        CompleteOrderPage completeOrderPage = checkoutOverviewPage.finishOrder();
        completeOrderPage.displayThankYouForYourOrderMessage();
    }
}
