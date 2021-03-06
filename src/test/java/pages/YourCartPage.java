package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.Collections;

public class YourCartPage {
    protected WebDriver driver;

    @FindBy(css = "[id=checkout]")
    private WebElement checkout;

    public YourCartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public YourDataInfoPage checkout(){

        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoreAll(Collections.singleton(NoSuchElementException.class));

        fluentWait.until(ExpectedConditions.elementToBeClickable(checkout));
        checkout.click();

        return new YourDataInfoPage(driver);
    }
}
