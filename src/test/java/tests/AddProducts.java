package tests;

import base.TestUtils;
import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utils.CsvHelper;

import java.io.IOException;

public class AddProducts extends TestUtils {

    @DataProvider(name = "Products")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/Products.csv");
    }

    @Test(dataProvider = "Products")
    public void AddProductsIntoShoppingCart(String userName, String password, String product1, String product2) {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login(userName, password);

        productsPage.addItemToTheCart(product1);
        productsPage.addItemToTheCart(product2);
        productsPage.getItemsInTheCart();

        Assert.assertEquals(productsPage.getItemsInTheCart(), 2,
                ("Because we have to add two products in the cart."));
    }
}
