package org.lightandwonder.pages;

import org.lightandwonder.utils.ConfigFileReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(id = "twotabsearchtextbox")
            private WebElement searchBox;

    @FindBy(css = ".a-link-normal.s-no-outline img")
            private List<WebElement> products;
    ConfigFileReader configFileReader;
    public HomePage(){
        PageFactory.initElements(driver, this);
        configFileReader= new ConfigFileReader();
    }

    public void search(String text){
        searchBox.sendKeys(text);
        searchBox.sendKeys(Keys.ENTER);
    }

    public void selectProductByIndex(int index){
        products.get(index).click();
    }
}
