package com.test.saucelab.stepdefinitions;

import com.test.saucelab.pages.SauceLoginPage;
import com.test.saucelab.pages.SauceMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDef {
    WebDriver driver = new ChromeDriver();
    SauceLoginPage sauceLoginPage = new SauceLoginPage(driver);
    SauceMainPage sauceMainPage = new SauceMainPage(driver);
    @Given("User navigates to the website {string}")
    public void user_navigates_to_the_website(String url) {
        driver.get(url);

    }

    @When("User provides {string} and password {string} to the SauceLoginPage")
    public void user_provides_and_password_to_the_sauce_login_page(String username, String password) {
        sauceLoginPage.login(username,password);
    }

    @Then("User validates title {string} from SauceMainPage")
    public void user_validates_title_from_sauce_main_page(String title) {
        sauceMainPage.titleValidation(driver,title);
    }
}
