package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    //constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * interact with Login Modal
     *
     * @return a class of type LoginModal
     */
    public LoginModal clickLogin() {
        clickLink("Log in");
        By modalId = By.id("logInModal");
        WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(modalId)));
        return new LoginModal(driver);
    }

    /**
     * reading welcome message for user after login
     *
     * @return the welcome message
     */
    public String getWelcomeMessage() {
        WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
        return driver.findElement(By.id("nameofuser")).getText();
    }


    public CartPage clickCart() {
        clickLink("Cart");
        return new CartPage(driver);
    }


    public ProductPage clickProduct(String productLink) {
        clickLink(productLink);
        return new ProductPage(driver);
    }


    private void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }


}
