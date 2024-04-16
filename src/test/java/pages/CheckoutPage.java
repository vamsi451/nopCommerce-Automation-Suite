package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    @FindBy(xpath = "//button[contains(text(),'Checkout as Guest')]")
    WebElement checkoutAsGuestButton;

    private final WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public boolean clickCheckoutAsGuest() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(checkoutAsGuestButton));
            checkoutAsGuestButton.click();
            wait.until(ExpectedConditions.invisibilityOf(checkoutAsGuestButton));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}