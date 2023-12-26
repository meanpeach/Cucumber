package com.test.techtorialwork.stepdefinitions;

import com.test.techtorialwork.pages.MainWorkPage;
import com.test.techtorialwork.pages.ProductsWorkPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class ProductFilterStepDef {

    WebDriver driver = DriverHelper.getDriver();

    MainWorkPage mainWorkPage = new MainWorkPage(driver);
    ProductsWorkPage productsWorkPage = new ProductsWorkPage(driver);

    @When("User clicks Products Button on the left side")
    public void user_clicks_products_button_on_the_left_side() {
        mainWorkPage.clickProductsBtn();

    }
    @When("User selects {string} and {string} for categories")
    public void user_selects_and_for_categories(String category, String subCategory) {
        productsWorkPage.filterCategories(category,subCategory);
    }


    @When("User clicks three dots for the first product and view button")
    public void user_clicks_three_dots_for_the_first_product_and_clicks_button() {
        productsWorkPage.clickActionAndViewButton();

    }
    @Then("User validates {string} and {string} are matching")
    public void user_validates_and_are_matching(String expectedCategory, String expectedSubCategory) {
        productsWorkPage.categoryInformation(expectedCategory,expectedSubCategory);


    }



}
