package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.ConfigReader;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
    	this.driver = driver;
	}

    private By username = By.id("user-name");
       private By password = By.id("password");
       private By loginBtn = By.id("login-button");

       
       public void login() {
    	   
    	   driver.findElement(username).sendKeys(ConfigReader.get("username"));
    	   driver.findElement(password).sendKeys(ConfigReader.get("password"));
    	   driver.findElement(loginBtn).click();
       }
	
}



