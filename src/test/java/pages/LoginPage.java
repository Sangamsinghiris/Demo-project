package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ConfigReader;
import Utils.WaitUtils;

public class LoginPage {

    WebDriver driver;
    WaitUtils wait;

    @FindBy(id = "user-name")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void login() {
        wait.waitForElementVisible(usernameField)
            .sendKeys(ConfigReader.get("username"));

        wait.waitForElementVisible(passwordField)
            .sendKeys(ConfigReader.get("password"));

        wait.waitForElementClickable(loginButton).click();
    }
}
