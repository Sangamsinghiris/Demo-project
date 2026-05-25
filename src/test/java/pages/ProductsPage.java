package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.ConfigReader;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    public void goToCart() {
        driver.findElement(By.xpath("//a[@class=\"shopping_cart_link\"]")).click();
    }
}
