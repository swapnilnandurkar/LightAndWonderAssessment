package org.lightandwonder.pages;

import org.lightandwonder.utils.CommonUtils;
import org.lightandwonder.utils.ConfigFileReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    @FindBy(id = "twotabsearchtextbox")
            private WebElement searchBox;

    @FindBy(css = ".a-link-normal.s-no-outline img")
            private List<WebElement> products;
    @FindBy(id = "nav-cart-count")
    private WebElement cartIcon;

    public String getCurrentWindowHandles() {
        return currentWindowHandles;
    }

    private String currentWindowHandles;
    ConfigFileReader configFileReader;
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        configFileReader= new ConfigFileReader();
    }

    public void search(String text){
        searchBox.sendKeys(text);
        searchBox.sendKeys(Keys.ENTER);
    }

    public void selectProductByIndex(int index){
        currentWindowHandles = driver.getWindowHandle();
        products.get(index).click();
        new CommonUtils(driver).switchToNewWindow(currentWindowHandles);
    }

    public void goToCart(){
        cartIcon.click();
    }
}
