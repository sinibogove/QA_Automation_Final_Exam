package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CompleteOrderPage {
    protected WebDriver driver;

    @FindBy(xpath = "//*[text()='THANK YOU FOR YOUR ORDER']")
    private WebElement thanksMessage;

    public CompleteOrderPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void displayThankYouForYourOrderMessage (){
        Assert.assertTrue(thanksMessage.isDisplayed());
    }
}
