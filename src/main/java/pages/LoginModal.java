package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginModal {
    private WebDriver driver;
    private By loginModalTitle = By.id("logInModalLabel");
    private By usernameInputField = By.id("loginusername");
    private By passwordInputField = By.id("loginpassword");
    private By loginButton = By.xpath("//button[contains(text(),'Log in')]");


    public LoginModal(WebDriver driver) {
        this.driver = driver;
    }

    public String getLoginModalTitle(){
        return driver.findElement(loginModalTitle).getText();
    }

    public void setUsernameField(String username){
        driver.findElement(usernameInputField).sendKeys(username);
    }

    public void setPasswordField(String password){
        driver.findElement(passwordInputField).sendKeys(password);
    }

    public HomePage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }

}
