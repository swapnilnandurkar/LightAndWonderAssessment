package org.lightandwonder.pages;

import org.lightandwonder.managers.WebDriverManager;
import org.lightandwonder.utils.ConfigFileReader;
import org.openqa.selenium.WebDriver;

public class BasePage {

    WebDriver driver;
    ConfigFileReader configFileReader;
    public BasePage() {
        configFileReader= new ConfigFileReader();
        WebDriverManager driverManager = new WebDriverManager();
        this.driver = driverManager.getDriver();
        driver.get(configFileReader.getApplicationUrl());
    }
    public void quitDriver(){
        driver.quit();
    }

}
