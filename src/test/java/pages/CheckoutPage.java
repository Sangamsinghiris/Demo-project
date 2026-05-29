package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.WaitUtils;

public class CheckoutPage {

    WebDriver driver;
    WaitUtils wait;

    @FindBy(id = "first-name")
    WebElement firstNameField;

    @FindBy(id = "last-name")
    WebElement lastNameField;

    @FindBy(id = "postal-code")
    WebElement postalCodeField;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(id = "finish")
    WebElement finishButton;

    @FindBy(id = "back-to-products")
    WebElement backhomebtn;
    
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterDetails() {
        wait.waitForElementVisible(firstNameField).sendKeys("Sangam");
        wait.waitForElementVisible(lastNameField).sendKeys("Singh");
        wait.waitForElementVisible(postalCodeField).sendKeys("201301");

        wait.waitForElementClickable(continueButton).click();
    }

    public void finishOrder() {
        wait.waitForElementClickable(finishButton).click();
    }
    public void backhome() {
    	backhomebtn.click();
    }
}
