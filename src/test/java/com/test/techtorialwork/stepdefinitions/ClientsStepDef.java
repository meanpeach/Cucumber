package com.test.techtorialwork.stepdefinitions;

import com.test.techtorialwork.pages.ClientsWorkPage;
import com.test.techtorialwork.pages.MainWorkPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class ClientsStepDef {

    WebDriver driver = DriverHelper.getDriver();
    MainWorkPage mainWorkPage = new MainWorkPage(driver);
    ClientsWorkPage clientsWorkPage = new ClientsWorkPage(driver);


    @When("User clicks Clients button")
    public void user_clicks_clients_button() {
        mainWorkPage.clickClientsBtn();
    }
    @When("User clicks add client and provides {string}, {string},{string},{string} for ClientPage")
    public void user_clicks_add_client_and_provides_for_client_page(String name, String email, String country, String mobile) throws InterruptedException {
        clientsWorkPage.clientInformation(name,email,country,mobile);

    }
    @When("User provides company information {string},{string},{string}")
    public void user_provides_company_information(String companyName, String companyWebsite, String officePhone) throws InterruptedException {
        clientsWorkPage.companyInformation(companyName,companyWebsite,officePhone);

    }
    @When("User provides address information {string},{string}")
    public void user_provides_address_information(String companyAddress, String shippingAddress) throws InterruptedException {
        clientsWorkPage.addressInformation(companyAddress,shippingAddress);

    }
    @Then("User clicks save button and validates {string},{string},{string},{string} from table.")
    public void user_clicks_save_button_and_validates_from_table(String expectedName, String expectedCompanyName,
                                                                 String expectedEmail, String expectedStatus) throws InterruptedException {
        clientsWorkPage.saveAndValidate(expectedName,expectedCompanyName,expectedEmail,expectedStatus);
    }



    @When("User provides {string} in the search bar in the clientsPage")
    public void user_provides_in_the_search_bar_in_the_clients_page(String letters) throws InterruptedException {
        clientsWorkPage.searchName(letters);
    }
    @Then("User validates all the names contain {string} in the search result")
    public void user_validates_all_the_names_contain_in_the_search_result(String letters) {
        clientsWorkPage.searchNameValidation(letters);
    }
    @When("User provides a word {string} in the search bar in the clientsPage")
    public void user_provides_a_word_in_the_search_bar_in_the_clients_page(String word) {
       clientsWorkPage.searchEmail(word);
    }

    @Then("User validates all the emails contain {string} in the search result")
    public void user_validates_all_the_emails_contain_in_the_search_result(String word) {
        clientsWorkPage.searchEmailValidation(word);

    }

    @When("User clears the text in the search bar")
    public void user_clears_the_text_in_the_search_bar() {
        clientsWorkPage.clear();


    }
    @Then("User validates the size of the list is bigger than {int}")
    public void user_validates_the_size_of_the_list_is_bigger_than(int size) {
        clientsWorkPage.sizeValidation(size);


    }

    @When("User clicks UpAndDown arrow next to the ID column on the Client list")
    public void user_clicks_up_and_down_arrow_next_to_the_id_column_on_the_client_list() throws InterruptedException {
        clientsWorkPage.sortingButton();

    }
    @Then("User validates that all the IDs are listed in Ascending Order")
    public void user_validates_that_all_the_i_ds_are_listed_in_ascending_order() throws InterruptedException {
        clientsWorkPage.ascendingOrderValidation();


    }






}
