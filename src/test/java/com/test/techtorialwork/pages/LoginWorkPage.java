package com.test.techtorialwork.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.beans.Visibility;
import java.time.Duration;
import java.util.function.Function;

public class LoginWorkPage {

    public LoginWorkPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#email")
    WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//button[@id='submit-login']")
    WebElement loginButton;

    @FindBy(css = ".invalid-feedback")
    WebElement errorMessage;

    public void login(String username,String password) throws InterruptedException {
        email.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
        Thread.sleep(2000);


    }
    public boolean isLoginVisible(){
        return loginButton.isDisplayed();
    }

    public void errorMessageAndColor(String expectedMessage,String expectedColor){
        Assert.assertEquals(expectedMessage, BrowserUtils.getText(errorMessage));
        Assert.assertEquals(expectedColor,errorMessage.getCssValue("color"));
    }

}

