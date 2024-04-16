# nopCommerce-Automation-Suite

### Video Output
https://user-images.githubusercontent.com/29010350/204713810-80648321-7087-4cbe-894a-eb922b235799.mp4

## Project Scenerio:

## Suppose we want to build an automation project that will execute every night at 12:00 AM, generate reports and then give us the reports. Right now we want to cover the following two features Registration and PlaceOrder.

### Here is the website link: [nopCommerce](https://demo.nopcommerce.com/)

- Please use two different test files Registration and PlaceOrder.

```gherkin
@registration
Feature: Nopcommerce registration feature Test

  @test-1
  Scenario Outline: User should be able to registration new account successfully
    Given User go to the NopCommerce Home page
    And User navigate to the Registration page
    When User select the <type> as gender
    And User set first name and last name
    And User set <dob> as date of birth
    And User set <dynamicEmail> as email
    And User set <companyName> as company details
    And User set Newsletter option as <status>
    And User set <password> as password and confirm password again
    And User click on the Register button
    Then Verify that the new account registration message <msg> is displayed
    Examples:
      | type     | dob          | dynamicEmail | companyName       | status      | password    | msg                           |
      | "Male"   | "20/05/1995" | ""           | "Brainstation-23" | "checked"   | "pass@1234" | "Your registration completed" |
      | "Female" | "9/05/1999"  | ""           | "Brainstation-23" | "unchecked" | "pass@1234" | "Your registration completed" |
      | "Female" | "3/05/2000"  | ""           | "Brainstation-23" | "unchecked" | "pass@1234" | "Your registration completed" |
      | "Male"   | "2/05/2001"  | ""           | "Brainstation-23" | "checked"   | "pass@1234" | "Your registration completed" |
      | "Female" | "10/05/1990" | ""           | "Brainstation-23" | "unchecked" | "pass@1234" | "Your registration completed" |
```

```gherkin
@placeOrder
Feature: Nopcommerce place order feature Test

  @test-2
  Scenario: User should be able to successfully place order as a guest user
    Given User go to the NopCommerce Home page
    When User click "Cell phones" option from "Electronics" category
    And User click on the "Nokia Lumia 1020" for product details
    And User set the quantity number 2 in the quantity field
    And User click on the "ADD TO CART" button
    And User go to the shipping cart page
    And User accept terms conditions and click checkout button
    And User click checkout as guest button
    And User input all the billing details and click continue
    And User select shipping method "Next Day Air" and click continue
    And User select payment method "Credit Card" and click continue
    And User select "Visa" card and input card information
    And User click confirm button to place the order
    Then Verify that the order place message "Your order has been successfully processed!" is displayed
```

## Additional functionalities, that may be covered:

- Automation projects should be capable of running on different OS platform
- Use any automation framework you preferred
- Use Java or other programming languages as you prefer
- Choose any framework that supports Page Object Modal(POM) design pattern
- You can feel free to use any test reporting tools(Ex. Extent Report, Allure report)
- You can feel free to use any data provider such as excel/CSV
- Use your imagination and write some additional tests if you feel you can cover other important functionalities
- The more, the better. Only if it makes sense


## Technology used:

- Selenium
- Cucumber
- Java
- Junit
- Maven
- Intellij IDEA

## How to run this project:

- Clone this project
- hit the following command: ```mvn clean test```


### Report
cucumber-report
![Screenshot (77)](https://github.com/zafir100100/nopCommerce-Automation-Suite/blob/master/assets/screenshots/cucumber-report.PNG)

### Report Link
https://drive.google.com/file/d/1ieXcll94QzJF5LXYMrtQ4Z57uh1F6N3M/view?usp=share_link
