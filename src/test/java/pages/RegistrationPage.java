package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    @FindBy(id = "gender-male")
    WebElement genderMaleRadioButton;
    @FindBy(id = "gender-female")
    WebElement genderFemaleRadioButton;
    @FindBy(id = "FirstName")
    WebElement firstNameTextField;
    @FindBy(id = "LastName")
    WebElement lastNameTextField;
    @FindBy(name = "DateOfBirthDay")
    WebElement dayOfBirthSelect;
    @FindBy(name = "DateOfBirthMonth")
    WebElement monthOfBirthSelect;
    @FindBy(name = "DateOfBirthYear")
    WebElement yearOfBirthSelect;
    @FindBy(id = "Email")
    WebElement emailTextField;
    @FindBy(id = "Company")
    WebElement companyTextField;
    @FindBy(id = "Newsletter")
    WebElement newsletterCheckBox;
    @FindBy(id = "Password")
    WebElement passwordTextField;
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordTextField;
    @FindBy(id = "register-button")
    WebElement registerButton;

    private final WebDriverWait wait;

    public RegistrationPage(WebDriver driver){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public boolean setGender(String gender){
        try {
            WebElement genderRadioButton = "male".equalsIgnoreCase(gender) ? genderMaleRadioButton : genderFemaleRadioButton;
            wait.until(ExpectedConditions.elementToBeClickable(genderRadioButton));
            genderRadioButton.click();
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public boolean setFirstName(String firstName){
        try {
            wait.until(ExpectedConditions.visibilityOf(firstNameTextField));
            firstNameTextField.sendKeys(firstName);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public boolean setLastName(String lastName){
        try {
            wait.until(ExpectedConditions.visibilityOf(lastNameTextField));
            lastNameTextField.sendKeys(lastName);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public boolean setDob(String dob){
        try {
            String[] dobParts = dob.split("/");
            wait.until(ExpectedConditions.elementToBeClickable(dayOfBirthSelect));
            dayOfBirthSelect.sendKeys(dobParts[0]);

            wait.until(ExpectedConditions.elementToBeClickable(monthOfBirthSelect));
            monthOfBirthSelect.sendKeys(dobParts[1]);

            wait.until(ExpectedConditions.elementToBeClickable(yearOfBirthSelect));
            yearOfBirthSelect.sendKeys(dobParts[2]);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public boolean setEmail(String email){
        try {
            wait.until(ExpectedConditions.visibilityOf(emailTextField));
            emailTextField.sendKeys(email);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public boolean setCompany(String company){
        try {
            wait.until(ExpectedConditions.visibilityOf(companyTextField));
            companyTextField.sendKeys(company);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public boolean setNewsletterOption(String subscribeToNewsletter){
        try {
            wait.until(ExpectedConditions.visibilityOf(newsletterCheckBox));
            boolean newsletterCheckBoxState = "checked".equalsIgnoreCase(subscribeToNewsletter);
            if (newsletterCheckBox.isSelected() != newsletterCheckBoxState) {
                newsletterCheckBox.click();
            }
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public boolean setPassword(String password){
        try {
            wait.until(ExpectedConditions.visibilityOf(passwordTextField));
            passwordTextField.sendKeys(password);

            wait.until(ExpectedConditions.visibilityOf(confirmPasswordTextField));
            confirmPasswordTextField.sendKeys(password);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public boolean clickRegisterButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(registerButton));
            registerButton.click();
            wait.until(ExpectedConditions.invisibilityOf(registerButton));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
