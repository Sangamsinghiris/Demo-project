package Testclasses;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest {

    @Test
    public void buyProductTest() {


test = extent.createTest("Buy Product Test");

        log.info("Starting test execution");

        LoginPage login = new LoginPage(driver);
        login.login();
        log.info("Login successful");
        
        
        ProductsPage product = new ProductsPage(driver);
        product.addProductToCart();
        product.goToCart();
        log.info("Product added to cart");
        

        CartPage cart = new CartPage(driver);
        cart.clickCheckout();
        log.info("Checkout started");
        
        

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.enterDetails();
        checkout.finishOrder();

log.info("Purchase completed successfully");

        test.pass("Purchase flow executed successfully");


        System.out.println("✅ Purchase Completed Successfully");
    }
}