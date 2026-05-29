package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.WaitUtils;

public class LogoutPage {

    WebDriver driver;
    WaitUtils wait;

    // ☰ menu button (top-left)
    @FindBy(id = "react-burger-menu-btn")
    WebElement menuButton;

    // Logout link inside menu
    @FindBy(id = "logout_sidebar_link")
    WebElement logoutLink;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void logout() {

        // Open menu
    	menuButton.click();

        // Click logout
    	logoutLink.click();
    }
}
