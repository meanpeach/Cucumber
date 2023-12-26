package com.test.techtorialwork.stepdefinitions;

import com.test.techtorialwork.pages.MainWorkPage;
import com.test.techtorialwork.pages.OrdersWorkPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class OrdersStepDef {

    WebDriver driver = DriverHelper.getDriver();
    MainWorkPage mainWorkPage = new MainWorkPage(driver);
    OrdersWorkPage ordersWorkPage = new OrdersWorkPage(driver);

    @When("User clicks Orders button on the left side")
    public void user_clicks_orders_button_on_the_left_side() {
        mainWorkPage.clickOrdersBtn();

    }

    @When("User clicks AddNewOrder button in the Order page")
    public void user_clicks_add_new_order_button_in_the_order_page() {
        ordersWorkPage.clickAddNewOrderBtn();

    }

    @When("User clicks FilterByCategory button in between SelectProduct and Add fields")
    public void user_clicks_filter_by_category_button_in_between_select_product_and_add_fields() {
        ordersWorkPage.clickFilterByCategory();

    }

    @Then("User validates {string},{string} are displayed")
    public void user_validates_are_displayed(String selectProduct, String billingText) {
        ordersWorkPage.selectProductValidation(selectProduct);
        ordersWorkPage.billingAddressTextValidation(billingText);

    }

    @Then("User validates {string} button and {string} are displayed")
    public void user_validates_button_and_are_displayed(String shippingText, String alertText) {
        ordersWorkPage.addShippingAddressValidation(shippingText);
        ordersWorkPage.alertTextValidation(alertText);

    }

    @Given("User validates {string} is displayed")
    public void user_validates_is_displayed(String billingText) {
        ordersWorkPage.billingAddressTextValidation(billingText);

    }

    @Given("User validates {string} button is displayed")
    public void user_validates_button_is_displayed(String shippingText) {
        ordersWorkPage.addShippingAddressValidation(shippingText);

    }

    @When("User selects client {string}")
    public void user_selects_client(String name) {
        ordersWorkPage.clientSelect(name);


    }

    @Then("User validates Billing Address is {string}")
    public void user_validates_billing_address_is(String billingText) throws InterruptedException {
        ordersWorkPage.billingAddressClientValidation(billingText);

    }

    @Then("User validates Shipping Address is {string}")
    public void user_validates_shipping_address_is(String shippingText) {
        ordersWorkPage.shippingAddressClientValidation(shippingText);

    }

    @When("User selects product {string}")
    public void user_selects_product(String productName) {
        ordersWorkPage.productSelect(productName);

    }

    @Then("User validates Total {string}")
    public void user_validates_total(String expectedTotal) throws InterruptedException {
        ordersWorkPage.totalValidation(expectedTotal);

    }

    @When("User inputs Client Note {string}")
    public void user_inputs_client_note(String clientNote) {
        ordersWorkPage.clientNoteInput(clientNote);

    }

    @When("User clicks Submit button")
    public void user_clicks_submit_button() throws InterruptedException {
        ordersWorkPage.submit();


    }

    @Then("User validates the order is for {string} with {string} on {string} status is {string}")
    public void user_validates_the_order_is_added_to_the_order_page(String expectedClientName,String expectedTotal ,String expectedDate,String expectedStatus ) throws InterruptedException {
        ordersWorkPage.orderValidation(expectedClientName,expectedTotal,expectedDate,expectedStatus);
    }
}