package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationCompletePage {
    @FindBy(className = "result")
    WebElement registrationResultText;

    private final WebDriverWait wait;

    public RegistrationCompletePage(WebDriver driver){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public String getRegistrationStatus(){
        try {
            wait.until(ExpectedConditions.visibilityOf(registrationResultText));
            return registrationResultText.getText();
        }catch (Exception ex){
            return null;
        }
    }
}
