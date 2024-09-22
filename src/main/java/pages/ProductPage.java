package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

    public class ProductPage {

        private WebDriver driver;
        private By AddCart =By.linkText("Add to cart");

        public ProductPage(WebDriver driver) {
            this.driver = driver;

        }

        public void clickAddToCartButton(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(AddCart));
            driver.findElement(AddCart).click();

        }

        public void AcceptAlert (){
            driver.switchTo().alert().accept();
        }

        public String getAlertText(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            return driver.switchTo().alert().getText();
        }

    }


