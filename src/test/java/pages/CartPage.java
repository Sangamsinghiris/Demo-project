package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.WaitUtils;

public class CartPage {

    WebDriver driver;
    WaitUtils wait;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickCheckout() {
        wait.waitForElementClickable(checkoutButton).click();
    }
}