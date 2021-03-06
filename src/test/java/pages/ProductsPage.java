package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.Collections;

public class ProductsPage {
    protected WebDriver driver;
    private static final String ADD_TO_CART_LOCATOR = "//button[@id='add-to-cart-sauce-labs-%s']";

    @FindBy (className = "shopping_cart_badge")
    private WebElement shoppingCartCounter;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement reactBurgerMenuButton;

    @FindBy(css = "[class=shopping_cart_link]")
    private WebElement shoppingCart;

    public ProductsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void reactBurgerMenuButton (){

        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoreAll(Collections.singleton(NoSuchElementException.class));

        fluentWait.until(ExpectedConditions.elementToBeClickable(reactBurgerMenuButton));
        Assert.assertTrue(reactBurgerMenuButton.isDisplayed());
    }

    public void addItemToTheCart(String productName){

        String xpathOfElementToBeAdded = String.format(ADD_TO_CART_LOCATOR, productName);
        WebElement addToCartButton = driver.findElement(By.xpath(xpathOfElementToBeAdded));

        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoreAll(Collections.singleton(NoSuchElementException.class));

        fluentWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathOfElementToBeAdded)));
        fluentWait.until(ExpectedConditions.elementToBeClickable(addToCartButton));

        addToCartButton.click();
    }

    public int getItemsInTheCart(){

        return Integer.parseInt(shoppingCartCounter.getText());
    }
    public YourCartPage moveToYourCartPage(){

        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoreAll(Collections.singleton(NoSuchElementException.class));
        fluentWait.until(ExpectedConditions.elementToBeClickable(shoppingCart));
        shoppingCart.click();

        return new YourCartPage(driver);
    }
}
