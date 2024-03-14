package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.lightandwonder.managers.WebDriverManager;
import org.lightandwonder.pages.CartPage;
import org.lightandwonder.pages.HomePage;
import org.lightandwonder.pages.ProductPage;
import org.lightandwonder.utils.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class addToCartDefinition {
    HomePage homePage;
    ProductPage productPage;
    ConfigFileReader configFileReader;
    WebDriver driver;
    String productPriceOnProductPage;
    String priceOnCartPage;
    String subTotalOnCartPage;


    @Before
    public void launchBrowser(){
        configFileReader= new ConfigFileReader();
        WebDriverManager driverManager = new WebDriverManager();
        this.driver = driverManager.getDriver();
        driver.get(configFileReader.getApplicationUrl());
    }

    @Given("User is on amazon home page")
    public void user_is_on_amazon_home_page() {
        homePage = new HomePage(driver);
    }

    @When("Search for an item monitor")
    public void search_for_an_item_monitor() {
        homePage.search("monitor");
    }

    @And("Adds the first item from the list")
    public void adds_the_first_item_from_the_list() {
        homePage.selectProductByIndex(1);
        productPage = new ProductPage(driver);
        productPriceOnProductPage = productPage.getProductPrice();
        productPage.addProductToCart();
        //productPage.closeWindowByIcon();
    }

    @And("Open Cart from the top-right")
    public void open_cart_from_the_top_right() {
        homePage.goToCart();
        CartPage cartPage = new CartPage(driver);
        priceOnCartPage = cartPage.getProductPrice();
        subTotalOnCartPage = cartPage.getProductSubTotal();
    }

    @Then("Verify that the price is identical to the product page")
    public void verify_that_the_price_is_identical_to_the_product_page() {
        Assert.assertTrue(priceOnCartPage.contains(productPriceOnProductPage));
    }

    @And("Verify that the sub total is identical to the product page")
    public void verify_that_the_sub_total_is_identical_to_the_product_page() {
        Assert.assertTrue(subTotalOnCartPage.contains(priceOnCartPage));
    }
}
