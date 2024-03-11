package org.lightandwonder.pages;

import org.lightandwonder.utils.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {
    WebDriver driver;
    ConfigFileReader configFileReader;
    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        configFileReader= new ConfigFileReader();
    }
}
