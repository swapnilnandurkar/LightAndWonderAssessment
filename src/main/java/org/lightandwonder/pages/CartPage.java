package org.lightandwonder.pages;

import org.lightandwonder.utils.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {
    ConfigFileReader configFileReader;
    WebDriver driver;

    @FindBy(css = "#sc-subtotal-amount-buybox span.currencyINR")
    private WebElement subTotal;

    @FindBy(css = "div.sc-badge-price div > span")
    private WebElement productPrice;
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        configFileReader= new ConfigFileReader();
    }

    public void navigateToHomePage() {
        driver.get(configFileReader.getApplicationUrl());
    }

    public String getProductPrice(){
        return productPrice.getText();
    }

    public String getProductSubTotal(){
        return subTotal.getText();
    }
}
