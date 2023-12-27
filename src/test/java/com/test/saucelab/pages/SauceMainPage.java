package com.test.saucelab.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceMainPage {
    public SauceMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void titleValidation(WebDriver driver, String expectedTitle){
        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }




}
