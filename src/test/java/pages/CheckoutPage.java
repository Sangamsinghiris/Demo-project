package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.ConfigReader;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterDetails() {

        driver.findElement(By.id("first-name")).sendKeys("Sangam");
        driver.findElement(By.id("last-name")).sendKeys("Singh");
        driver.findElement(By.id("postal-code")).sendKeys("201301");

        driver.findElement(By.id("continue")).click();
    }

    public void finishOrder() {
        driver.findElement(By.id("finish")).click();
    }
}

