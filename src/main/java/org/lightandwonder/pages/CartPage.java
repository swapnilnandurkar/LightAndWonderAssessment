package org.lightandwonder.pages;

import org.lightandwonder.utils.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {
    WebDriver driver;
    ConfigFileReader configFileReader;
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        configFileReader= new ConfigFileReader();
    }

    public void navigateToHomePage() {
        driver.get(configFileReader.getApplicationUrl());
    }
}
