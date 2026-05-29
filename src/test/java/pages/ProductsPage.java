package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.WaitUtils;

public class ProductsPage {

    WebDriver driver;
    WaitUtils wait;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartButton;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement cartIcon;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void addProductToCart() {
        wait.waitForElementClickable(addToCartButton).click();
    }

    public void goToCart() {
        wait.waitForElementClickable(cartIcon).click();
    }
}
