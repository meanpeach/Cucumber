package com.test.techtorialwork.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ClientsWorkPage {
    public ClientsWorkPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(@class,'btn-primary rounded')]")
    WebElement addClientButton;
    @FindBy(css = "#name")
    WebElement name;
    @FindBy(css = "#email")
    WebElement email;
    @FindBy(xpath = "//select[@id='country']")
    WebElement country;
    @FindBy(css = "#mobile")
    WebElement phoneNumber;
    @FindBy(css = "#company_name")
    WebElement companyName;
    @FindBy(css = "#website")
    WebElement website;
    @FindBy(css = "#office")
    WebElement officePhoneNumber;
    @FindBy(css = "#address")
    WebElement companyAddress;
    @FindBy(css = "#shipping_address")
    WebElement companyShippingAddress;
    @FindBy(xpath = "//button[@id='save-client-form']")
    WebElement saveButton;
    @FindBy(xpath = "//tbody//tr[@role='row']//td")
    List<WebElement> allInformation;
    @FindBy(xpath = "//input[@placeholder='Start typing to search']")
    WebElement searchBarField;
    @FindBy(css=".input-group-prepend")
    WebElement searchBarBtn;

    @FindBy(css=".text-darkest-grey")
    List<WebElement>names;
    @FindBy(xpath="//tr//td[contains(text(),'@')]")
    List<WebElement>emails;
    @FindBy(xpath="//button[@id='reset-filters']")
    WebElement clearBtn;

    @FindBy(css=".sorting_desc")
    WebElement upAndDownArrowBtn;
    @FindBy(css=".sorting_1")
    List <WebElement> all_IDs;

    public void clientInformation(String name,String email,String country,String mobile) throws InterruptedException {
        addClientButton.click();
        Thread.sleep(2000);
        this.name.sendKeys(name);
        this.email.sendKeys(email);
        BrowserUtils.selectBy(this.country,country,"text");
        phoneNumber.sendKeys(mobile);
    }
    public void companyInformation(String companyName,String companyWebsite,String officePhone) throws InterruptedException {
        this.companyName.sendKeys(companyName);
        this.website.sendKeys(companyWebsite);
        this.officePhoneNumber.sendKeys(officePhone);
    }

    public void addressInformation(String address,String shippingAddress) throws InterruptedException {
        this.companyAddress.sendKeys(address);
        this.companyShippingAddress.sendKeys(shippingAddress);
    }
    public void saveAndValidate(String expectedClientName,String expectedCompanyName,
                                String expectedEmail,String expectedStatus) throws InterruptedException {
        String currentDateGMT = LocalDateTime.now(ZoneId.of("GMT")).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        saveButton.click();
        Thread.sleep(2000);
        Assert.assertTrue(BrowserUtils.getText(allInformation.get(2)).contains(expectedClientName));
        Assert.assertTrue(BrowserUtils.getText(allInformation.get(2)).contains(expectedCompanyName));
        Assert.assertTrue(BrowserUtils.getText(allInformation.get(3)).contains(expectedEmail));
        Assert.assertEquals(expectedStatus,BrowserUtils.getText(allInformation.get(4)));
        Assert.assertEquals(BrowserUtils.getText(allInformation.get(5)),currentDateGMT);

    }

    public void searchName(String letters){
        searchBarField.sendKeys(letters);
        searchBarBtn.click();


    }
    public void searchNameValidation(String letters ){
        for(WebElement name : names){
            Assert.assertTrue(name.getText().toLowerCase().contains(letters));
        }

    }

    public void searchEmail(String word){
        searchBarField.sendKeys(word);
        searchBarBtn.click();
    }
    public void searchEmailValidation(String word ){
        for(WebElement email : emails){
            Assert.assertTrue(BrowserUtils.getText(email).contains(word));
        }
    }

    public void clear(){
        clearBtn.click();

    }
    public void sizeValidation(int size){
            Assert.assertTrue(names.size()>size);
    }

    public void sortingButton() throws InterruptedException {
        upAndDownArrowBtn.click();
        Thread.sleep(2000);

    }

    public void ascendingOrderValidation() throws InterruptedException {
        List<Integer> actualIDs = new ArrayList<>();
        for(WebElement id : all_IDs){
            actualIDs.add(Integer.parseInt(BrowserUtils.getText(id)));
        }
        List <Integer> expectedIDs = new ArrayList<>(actualIDs);
        Collections.sort(expectedIDs);


            Assert.assertEquals(actualIDs,expectedIDs);






    }

    }



