package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.lightandwonder.pages.HomePage;

public class addToCartDefinition {
    HomePage homePage;

    @Given("User is on amazon home page")
    public void user_is_on_amazon_home_page() {
        homePage = new HomePage();
    }

    @When("Search for an item monitor")
    public void search_for_an_item_monitor() {
        homePage.search("monitor");
    }

    @And("Adds the first item from the list")
    public void adds_the_first_item_from_the_list() {
        homePage.selectProductByIndex(1);

    }

    @And("Open Cart from the top-right")
    public void open_cart_from_the_top_right() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @Then("Verify that the price is identical to the product page")
    public void verify_that_the_price_is_identical_to_the_product_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @And("Verify that the sub total is identical to the product page")
    public void verify_that_the_sub_total_is_identical_to_the_product_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
}
