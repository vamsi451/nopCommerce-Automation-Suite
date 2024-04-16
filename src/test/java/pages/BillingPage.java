package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BillingPage {

    private final WebDriverWait wait;

    public BillingPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public boolean setBillingData(String firstName, String lastName, String email, String company, String country, String state, String city,
                                  String address1, String address2, String zip, String phone, String fax) {
        try {

            String firstNameId = "BillingNewAddress_FirstName";
            String lastNameId = "BillingNewAddress_LastName";
            String emailId = "BillingNewAddress_Email";
            String companyId = "BillingNewAddress_Company";
            String countryId = "BillingNewAddress_CountryId";
            String stateLoadingProgressId = "states-loading-progress";
            String stateId = "BillingNewAddress_StateProvinceId";
            String cityId = "BillingNewAddress_City";
            String address1Id = "BillingNewAddress_Address1";
            String address2Id = "BillingNewAddress_Address2";
            String zipId = "BillingNewAddress_ZipPostalCode";
            String phoneId = "BillingNewAddress_PhoneNumber";
            String faxId = "BillingNewAddress_FaxNumber";
            String continueButtonXPath = "//div[@id='billing-buttons-container']//button[@type='button'][contains(text(),'Continue')]";


            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(firstNameId))).sendKeys(firstName);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(lastNameId))).sendKeys(lastName);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(emailId))).sendKeys(email);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(companyId))).sendKeys(company);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(countryId))).sendKeys(country);


            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(stateLoadingProgressId)));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(stateLoadingProgressId)));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(stateId))).sendKeys(state);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(cityId))).sendKeys(city);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(address1Id))).sendKeys(address1);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(address2Id))).sendKeys(address2);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(zipId))).sendKeys(zip);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(phoneId))).sendKeys(phone);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(faxId))).sendKeys(fax);


            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(continueButtonXPath))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(continueButtonXPath)));

            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean setShippingOption() {
        try {
            String shippingOptionXPath = "//input[@id='shippingoption_1']";
            String continueButtonXPath = "//div[@id='shipping-method-buttons-container']//button[@type='button'][contains(text(),'Continue')]";

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(shippingOptionXPath))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(continueButtonXPath))).click();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean setPaymentOption() {
        try {
            String paymentOptionXPath = "//input[@id='paymentmethod_1']";
            String continueButtonXPath = "//div[@id='payment-method-buttons-container']//button[@type='button'][contains(text(),'Continue')]";

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(paymentOptionXPath))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(continueButtonXPath))).click();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean setPaymentDetails(String cardholderName, String cardNumber, String cardType, String expireMonth, String expireYear, String cardCode) {
        try {
            String paymentMethodXPath = "//input[@id='paymentmethod_1']";
            String creditCardTypeXPath = "//select[@id='CreditCardType']";
            String cardholderNameXPath = "//input[@id='CardholderName']";
            String cardNumberXPath = "//input[@id='CardNumber']";
            String expireMonthXPath = "//select[@id='ExpireMonth']";
            String expireYearXPath = "//select[@id='ExpireYear']";
            String cardCodeXPath = "//input[@id='CardCode']";
            String continueButtonXPath = "//div[@id='payment-info-buttons-container']//button[@type='button'][contains(text(),'Continue')]";

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(paymentMethodXPath))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(creditCardTypeXPath))).sendKeys(cardType);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cardholderNameXPath))).sendKeys(cardholderName);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cardNumberXPath))).sendKeys(cardNumber);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(expireMonthXPath))).sendKeys(expireMonth);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(expireYearXPath))).sendKeys(expireYear);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cardCodeXPath))).sendKeys(cardCode);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(continueButtonXPath))).click();

            return true;
        } catch (Exception ex) {
            return false;
        }
    }


    public boolean confirmPurchase() {
        try {
            String confirmButtonXPath = "//button[contains(text(),'Confirm')]";

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(confirmButtonXPath))).click();

            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public String getOrderPlacementValidationText(){
        try {
            String validationTextXpath = "//strong[contains(text(),'Your order has been successfully processed!')]";

            return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(validationTextXpath))).getText();
        } catch (Exception ex) {
            return null;
        }
    }



}