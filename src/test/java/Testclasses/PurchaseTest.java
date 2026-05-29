package Testclasses;

import org.testng.annotations.Test;

import Base.BasePage;
import pages.*;

public class PurchaseTest extends BasePage {

    @Test
    public void buyProductTest() {

        test = extent.createTest("Buy Product Test");

        // ===== Step 1: Login =====
        test.info("Step 1: Login to application");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        test.pass("Login successful");

        // ===== Step 2: Add product =====
        test.info("Step 2: Add product to cart");
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addProductToCart();
        test.pass("Product added");

        // ===== Step 3: Go to cart =====
        test.info("Step 3: Open cart");
        productsPage.goToCart();
        test.pass("Cart opened");

        // ===== Step 4: Checkout =====
        test.info("Step 4: Start checkout");
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();
        test.pass("Checkout started");

        // ===== Step 5: Enter details =====
        test.info("Step 5: Enter user details");
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterDetails();
        test.pass("Details entered");

        // ===== Step 6: Finish order =====
        test.info("Step 6: Complete order");
        checkoutPage.finishOrder();
        test.pass("Order completed");

        // ===== Step 7: Logout =====
        test.info("Step 7: Logout");
        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.logout();
        test.pass("Logout successful");

        // ===== Final =====
        test.pass("Test completed successfully ✅");
    }
}
