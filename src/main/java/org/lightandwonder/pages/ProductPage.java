package org.lightandwonder.pages;

import org.lightandwonder.utils.CommonUtils;
import org.lightandwonder.utils.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage {
    ConfigFileReader configFileReader;
    WebDriver driver;

    @FindBy(css = "#add-to-cart-button")
    private WebElement addToCartButton;

    @FindBy(css = "#attach-close_sideSheet-link")
    private WebElement closeWindowIcon;

    @FindBy(css = ".a-button-inner span#attachSiNoCoverage-announce")
    private WebElement skipButton;

    @FindBy(css = "span.a-price.aok-align-center.reinventPricePriceToPayMargin.priceToPay > span:nth-child(2) > span.a-price-whole")
    private WebElement productPrice;
    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        configFileReader= new ConfigFileReader();
    }

    public void addProductToCart(){
        addToCartButton.click();
    }

    public void closeWindowByIcon(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if (wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".a-button-inner span#attachSiNoCoverage-announce"))) != null) {
            new CommonUtils(driver).handleElementNotIntractableException(".a-button-inner span#attachSiNoCoverage-announce");
        } else {
            // If the element is not present, click on another element
            closeWindowIcon.click();
        }
    }

    public String getProductPrice(){
        return productPrice.getText();
    }
}
