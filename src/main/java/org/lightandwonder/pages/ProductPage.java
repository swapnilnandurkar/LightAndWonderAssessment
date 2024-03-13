package org.lightandwonder.pages;

import org.lightandwonder.utils.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {
    ConfigFileReader configFileReader;
    public ProductPage(){
        PageFactory.initElements(driver, this);
        configFileReader= new ConfigFileReader();
    }
}
