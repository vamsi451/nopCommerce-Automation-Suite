package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    @FindBy(id = "product_enteredQuantity_20")
    WebElement productQuantityTextField;
    @FindBy(id = "add-to-cart-button-20")
    WebElement addToCartButton;
//    @FindBy(className = "close")
//    WebElement modalCloseButton;
    @FindBy(className = "cart-label")
    WebElement cartPageLink;

    private final WebDriver driver;
    private final WebDriverWait wait;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public boolean setQuantity(int quantity){
        try {
            wait.until(ExpectedConditions.visibilityOf(productQuantityTextField));
            productQuantityTextField.clear();
            productQuantityTextField.sendKeys(String.valueOf(quantity));
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public boolean clickAddToCart() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
            addToCartButton.click();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean clickCloseModal() {
        try {
            WebElement modalCloseButton = driver.findElement(By.className("close"));
            wait.until(ExpectedConditions.elementToBeClickable(modalCloseButton));
            modalCloseButton.click();
            wait.until(ExpectedConditions.invisibilityOf(modalCloseButton));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean clickCartPageLink() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cartPageLink));
            cartPageLink.click();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
