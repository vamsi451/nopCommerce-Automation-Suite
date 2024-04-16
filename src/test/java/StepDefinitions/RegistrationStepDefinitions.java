package StepDefinitions;

import Setup.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LandingPage;
import pages.RegistrationCompletePage;
import pages.RegistrationPage;

import java.util.Random;

public class RegistrationStepDefinitions extends Setup {
    LandingPage landingPage;
    RegistrationPage registrationPage;
    RegistrationCompletePage registrationCompletePage;

    @Given("User go to the NopCommerce Home page")
    public void user_visited_the_portal() {
        landingPage = new LandingPage(driver);
        landingPage.gotoLandingPage();
    }

    @And("User navigate to the Registration page")
    public void user_clicked_the_registration_link() {
        landingPage = new LandingPage(driver);
        landingPage.gotoRegistrationPage();
    }

    @When("User select the {string} as gender")
    public void user_selects_the_gender(String gender) {
        registrationPage = new RegistrationPage(driver);
        registrationPage.setGender(gender);
    }

    @And("User set first name and last name")
    public void user_sets_the_first_name_and_last_name() {
        registrationPage = new RegistrationPage(driver);

        Random rand = new Random();
        int randomNumForFirstName = rand.nextInt(1000);
        int randomNumForLastName = rand.nextInt(1000);

        String firstName = "firstName" + randomNumForFirstName;
        String lastName = "lastName" + randomNumForLastName;
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
    }

    @And("User set {string} as date of birth")
    public void user_sets_the_date_of_birth(String dob) {
        registrationPage = new RegistrationPage(driver);
        registrationPage.setDob(dob);
    }

    @And("User set {string} as email")
    public void user_sets_the_email(String email) {
        registrationPage = new RegistrationPage(driver);
        registrationPage.setEmail(email);
    }

    @And("User set {string} as company details")
    public void user_sets_the_company_details(String companyName) {
        registrationPage = new RegistrationPage(driver);
        registrationPage.setCompany(companyName);
    }

    @And("User set Newsletter option as {string}")
    public void user_sets_the_newsletter_option(String status) {
        registrationPage = new RegistrationPage(driver);
        registrationPage.setNewsletterOption(status);
    }

    @And("User set {string} as password and confirm password again")
    public void user_sets_the_password_and_confirm_password(String password) {
        registrationPage = new RegistrationPage(driver);
        registrationPage.setPassword(password);
    }

    @And("User click on the Register button")
    public void user_clicks_the_register_button() {
        registrationPage = new RegistrationPage(driver);
        registrationPage.clickRegisterButton();
    }

    @Then("Verify that the new account registration message {string} is displayed")
    public void user_verifies_the_registration_message(String msg) {
        registrationCompletePage = new RegistrationCompletePage(driver);
        Assert.assertEquals(registrationCompletePage.getRegistrationStatus(), msg);
    }
}
