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

public class CheckoutPage {
    public WebDriver driver;

    @FindBy(css = "[id=first-name]")
    private WebElement firstName;

    @FindBy(css = "[id=last-name]")
    private WebElement lastName;

    @FindBy(css = "[id=postal-code]")
    private WebElement postalCode;

    @FindBy(css = "[id=continue]")
    private WebElement submitBtn;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CheckoutPage Checkout(){

        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2)) //how often it will be checked for the presence of the element
                .ignoreAll(Collections.singleton(NoSuchElementException.class));

        fluentWait.until(ExpectedConditions.elementToBeClickable(firstName));
        firstName.click();
        firstName.sendKeys("Vesselin");

        fluentWait.until(ExpectedConditions.elementToBeClickable(lastName));
        lastName.click();
        lastName.sendKeys("Stoyanov");

        fluentWait.until(ExpectedConditions.elementToBeClickable(postalCode));
        postalCode.click();
        postalCode.sendKeys("1750");

        fluentWait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        submitBtn.click();

        return new CheckoutPage(driver);
    }
}
