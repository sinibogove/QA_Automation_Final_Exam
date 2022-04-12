package tests;

import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import pages.LoginPage;
import pages.ProductsPage;
import utils.CsvHelper;

import java.io.IOException;

public class AddProductsInCart extends LoginPage {
    public AddProductsInCart(WebDriver driver) {
        super(driver);
    }
    @DataProvider(name = "validUser")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/validUser.csv");
    }
    @BeforeTest
    public ProductsPage login(String username, String password){
        return new ProductsPage(driver);
    }
}

