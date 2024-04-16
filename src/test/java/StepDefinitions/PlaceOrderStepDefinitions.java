package StepDefinitions;

import Setup.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;

public class PlaceOrderStepDefinitions extends Setup {
    LandingPage landingPage;
    CategoryPage categoryPage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    BillingPage billingPage;

    @Given("User go to the NopCommerce Home page for test 2")
    public void user_visited_the_portal() {
        landingPage = new LandingPage(driver);
        landingPage.gotoLandingPage();
    }

    @When("User click \"Cell phones\" option from \"Electronics\" category")
    public void user_click_Cell_phones_option_from_Electronics_category() {
        landingPage = new LandingPage(driver);
        landingPage.hoverElectronicsTab();
        landingPage.clickCellPhoneTab();
    }

    @And("User click on the \"Nokia Lumia 1020\" for product details")
    public void user_click_on_the_Nokia_Lumia_1020_for_product_details() {
        categoryPage = new CategoryPage(driver);
        categoryPage.clickNokiaLumiaLink();
    }

    @And("User set the quantity number 2 in the quantity field")
    public void user_set_the_quantity_number_2_in_the_quantity_field() {
        productPage = new ProductPage(driver);
        productPage.setQuantity(2);
    }

    @And("User click on the \"ADD TO CART\" button")
    public void User_click_on_the_ADD_TO_CART_button() {
        productPage = new ProductPage(driver);
        productPage.clickAddToCart();
        productPage.clickCloseModal();
    }

    @And("User go to the shipping cart page")
    public void User_go_to_the_shipping_cart_page() {
        productPage = new ProductPage(driver);
        productPage.clickCartPageLink();
    }

    @And("User accept terms conditions and click checkout button")
    public void user_accept_terms_conditions_and_click_checkout_button() {
        cartPage = new CartPage(driver);
        cartPage.clickTermsAndConditionsCheckbox();
        cartPage.clickCheckoutButton();
    }

    @And("User click checkout as guest button")
    public void user_click_checkout_as_guest_button() {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCheckoutAsGuest();
    }

    @And("User input all the billing details and click continue")
    public void user_input_all_the_billing_details_and_click_continue() {
        billingPage = new BillingPage(driver);
        billingPage.setBillingData(
                "John" + (int)(Math.random() * 100),
                "Doe" + (int)(Math.random() * 100),
                "john.doe" + (int)(Math.random() * 1000) + "@example.com",
                "Company" + (int)(Math.random() * 100),
                "Bangladesh",
                "Other",
                "City" + (int)(Math.random() * 100),
                "Address1-" + (int)(Math.random() * 1000),
                "Suite " + (int)(Math.random() * 10),
                "ZIP" + (int)(Math.random() * 9000 + 1000),
                "555-" + (int)(Math.random() * 900 + 100) + "-" + (int)(Math.random() * 9000 + 1000),
                "Fax" + (int)(Math.random() * 900 + 100) + "-" + (int)(Math.random() * 9000 + 1000)
        );
    }

    @And("User select shipping method \"Next Day Air\" and click continue")
    public void select_next_day_air_and_click_continue() {
        billingPage = new BillingPage(driver);
        billingPage.setShippingOption();
    }

    @And("User select payment method \"Credit Card\" and click continue")
    public void select_credit_card_and_click_continue() {
        billingPage = new BillingPage(driver);
        billingPage.setPaymentOption();
    }

    @And("User select \"Visa\" card and input card information")
    public void select_visa_and_input_card_information() {
        billingPage = new BillingPage(driver);
        billingPage.setPaymentDetails(
                "Clark Krajcik",
                "4929101329286351",
                "Visa",
                "02",
                "28",
                "525"
        );
    }

    @And("User click confirm button to place the order")
    public void click_confirm_button_to_place_order() {
        billingPage = new BillingPage(driver);
        billingPage.confirmPurchase();
    }

    @Then("Verify that the order place message \"Your order has been successfully processed!\" is displayed")
    public void verify_that_the_order_has_been_successfully_processed() {
        billingPage = new BillingPage(driver);
        Assert.assertEquals(billingPage.getOrderPlacementValidationText(), "Your order has been successfully processed!");
    }
}
