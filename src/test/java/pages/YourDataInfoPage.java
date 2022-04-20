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

public class YourDataInfoPage {
    protected WebDriver driver;

    @FindBy(css = "[id=first-name]")
    private WebElement firstNameInput;

    @FindBy(css = "[id=last-name]")
    private WebElement lastNameInput;

    @FindBy(css = "[id=postal-code]")
    private WebElement postCodeInput;

    @FindBy(css = "[id=continue]")
    private WebElement submitBtn;

    public YourDataInfoPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public CheckoutOverviewPage fillYourData(String firstName, String lastName, String postCode){

        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoreAll(Collections.singleton(NoSuchElementException.class));

        fluentWait.until(ExpectedConditions.elementToBeClickable(firstNameInput));
        firstNameInput.click();
        firstNameInput.sendKeys(firstName);

        fluentWait.until(ExpectedConditions.elementToBeClickable(lastNameInput));
        lastNameInput.click();
        lastNameInput.sendKeys(lastName);

        fluentWait.until(ExpectedConditions.elementToBeClickable(postCodeInput));
        postCodeInput.click();
        postCodeInput.sendKeys(postCode);

        fluentWait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        submitBtn.click();

        return new CheckoutOverviewPage(driver);
    }
}
