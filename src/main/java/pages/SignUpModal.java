package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Random;
import java.time.Duration;

public class SignUpModal {

    private WebDriver driver;
    private By signUpModalTitle = By.linkText("Sign up");
    private By usernameInputField = By.cssSelector("#sign-username");
    private By passwordInputField = By.cssSelector("#sign-password");
    private By signUpButton = By.xpath("//button[contains(text(),'Sign up')]");
    private By closeButton = By.xpath("//body/div[@id='signInModal']/div[1]/div[1]/div[3]/button[1]");


    public SignUpModal(WebDriver driver) {
        this.driver = driver;
    }

    public String getSignUpModalTitle() {
        return driver.findElement(signUpModalTitle).getText();
    }

    public void setSignUpUsernameField(String username) {
        driver.findElement(usernameInputField).sendKeys(username);
    }

    public void setSignUpPasswordField(String password) {
        driver.findElement(passwordInputField).sendKeys(password);
    }

    public HomePage clickSignUpButton() {
        driver.findElement(signUpButton).click();
        return new HomePage(driver);
    }

    public void AcceptAlert() {
        driver.switchTo().alert().accept();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // wait.until(ExpectedConditions.ale());
    }

    public String getAlertText() {
        WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }


    public class RandomUtils {
        public static String getRandomString(int length) {
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
            StringBuilder randomString = new StringBuilder();
            Random random = new Random();

            for (int i = 0; i < length; i++) {
                randomString.append(characters.charAt(random.nextInt(characters.length())));
            }

            return randomString.toString();
        }
    }
}


