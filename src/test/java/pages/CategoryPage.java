package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategoryPage {
    @FindBy(xpath = "//a[contains(text(),'Nokia Lumia 1020')]")
    WebElement nokiaLumiaLink;

    private final WebDriver driver;
    private final WebDriverWait wait;

    public CategoryPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public boolean clickNokiaLumiaLink(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(nokiaLumiaLink));
            nokiaLumiaLink.click();
            wait.until(ExpectedConditions.invisibilityOf(nokiaLumiaLink));
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
