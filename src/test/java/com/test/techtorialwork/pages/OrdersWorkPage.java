package com.test.techtorialwork.pages;

import io.cucumber.java.bs.A;
import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.beans.Visibility;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class OrdersWorkPage {
    public OrdersWorkPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@class, 'btn-primary')]")
    WebElement addNewOrderBtn;
    @FindBy(xpath = "//a[contains(@class, 'toggle-product')]")
    WebElement filterByCategoryBtn;
    @FindBy(xpath = "//div[contains(text(), 'Select Product Category')]")
    WebElement selectByCategoryField;
    @FindBy(xpath = "//p[@id='client_billing_address']")
    WebElement billingAddressText;
    @FindBy(xpath = "//p[@id='client_shipping_address']")
    WebElement addShippingAddressBtn;
    @FindBy(xpath = "//div[@id='alertMessage']")
    WebElement alertMsgText;
    @FindBy(xpath="//select[@name='client_id']")
    WebElement clientSelect ;
    @FindBy(xpath="//select[@title='Select Product']")
    WebElement productSelect;
    @FindBy(xpath = "//span[@class='total']")
    WebElement total ;

    @FindBy(css="#note")
    WebElement clientNote ;

    @FindBy(xpath="//button[@id='createOrder']")
    WebElement submitBtn;

    @FindBy(xpath = "//td")
    List<WebElement> submittedOrders;
    @FindBy(xpath = "//span[.='Orders']")
    WebElement ordersBtn;




    public void clickAddNewOrderBtn() {
        addNewOrderBtn.click();
    }
    public void clickFilterByCategory(){
        filterByCategoryBtn.click();
    }
    public void selectProductValidation (String selectProduct){
        Assert.assertEquals(BrowserUtils.getText(selectByCategoryField),selectProduct);
    }

    public void  billingAddressTextValidation(String billingText){
        Assert.assertEquals(BrowserUtils.getText(billingAddressText),billingText);

    }
    public void  addShippingAddressValidation (String shippingText){
        Assert.assertEquals(BrowserUtils.getText(addShippingAddressBtn),shippingText);

    }
    public void  alertTextValidation (String alertText){
        Assert.assertEquals(BrowserUtils.getText(alertMsgText),alertText);

    }
    public void  clientSelect (String name){
        BrowserUtils.selectBy(clientSelect,name,"text");

    }
    public void  billingAddressClientValidation(String billingText) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(BrowserUtils.getText(billingAddressText),billingText);

    }
    public void  shippingAddressClientValidation (String shippingText){
        Assert.assertEquals(BrowserUtils.getText(addShippingAddressBtn),shippingText);

    }
    public void productSelect(String productSelect){
        BrowserUtils.selectBy(this.productSelect,productSelect,"text");
    }

    public void totalValidation(String expectedTotal) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(BrowserUtils.getText(total),expectedTotal);
    }

    public void clientNoteInput(String clientNote){
        this.clientNote.sendKeys(clientNote);
    }

    public void submit() throws InterruptedException {
        Thread.sleep(2000);
        submitBtn.click();
    }

    public void orderValidation (String expectedClientName,String expectedTotal ,String expectedDate, String expectedStatus  ) throws InterruptedException {
        expectedDate= new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        Thread.sleep(5000);
        ordersBtn.click();
        List <String> expectedOrderInfo = Arrays.asList(expectedClientName,expectedTotal,expectedDate,expectedStatus);
        Thread.sleep(2000);
        for(int i =0;i<3;i++){
            Assert.assertEquals(BrowserUtils.getText(submittedOrders.get(i)),expectedOrderInfo.get(i));
        }

    }








}
