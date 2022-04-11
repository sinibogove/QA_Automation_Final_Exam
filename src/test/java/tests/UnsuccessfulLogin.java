package tests;

import base.TestUtils;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.CsvHelper;

import java.io.IOException;

public class UnsuccessfulLogin extends TestUtils {
    @DataProvider(name = "invalidUsers")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/invalidUsers.csv");
    }

    @Test(dataProvider = "invalidUsers")
    public void UnsuccessfulLogin(String userName, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName, password);
        loginPage.errorLoginLabel();
    }
}

