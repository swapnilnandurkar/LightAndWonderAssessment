package org.lightandwonder.managers;

import org.lightandwonder.pages.CartPage;
import org.lightandwonder.pages.HomePage;
import org.lightandwonder.pages.ProductPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	private WebDriver driver;
	private HomePage homePage;
	private CartPage cartPage;
	private ProductPage productPage;
	public PageObjectManager(WebDriver driver) {

		this.driver = driver;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

	public CartPage getProductPage() {

		return (cartPage == null) ? cartPage = new CartPage(driver) : cartPage;
	}

	public ProductPage getCartPage() {
		return
				(productPage == null) ? productPage = new ProductPage(driver) : productPage;
	}

}
