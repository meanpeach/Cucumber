package com.test.techtorialwork.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class WorkHook {

    public WebDriver driver;

    @Before //

        public void setup(){
            driver= DriverHelper.getDriver();
            driver.get(ConfigReader.readProperty("work_url"));
        }

    @After
    public void tearDown(Scenario scenario){
        BrowserUtils.getScreenShotWithCucumber(driver,scenario);
      driver.quit();
    }
    }

