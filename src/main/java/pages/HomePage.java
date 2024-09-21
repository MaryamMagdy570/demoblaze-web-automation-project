package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;


    //constructor
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public LoginModal clickLogin(){
        clickLink("Log in");
        By modalId = By.id("logInModal");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(modalId)));
        return new LoginModal(driver);
    }

    public String getWelcomeMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
        return driver.findElement(By.id("nameofuser")).getText();
    }


}
