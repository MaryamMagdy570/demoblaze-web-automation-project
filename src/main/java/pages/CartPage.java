package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private WebDriver driver;
    private By placeOrderButton = By.xpath("//button[contains(text(),'Place Order')]");

    private By orderPrice = By.xpath("//h3[@id='totalp']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public PlaceOrderModal clickPlaceOrderButton(){
        driver.findElement(placeOrderButton).click();
        By modalId = By.id("orderModal");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(modalId)));
        return new PlaceOrderModal(driver);
    }

    public String getOrderPrice(){
        return driver.findElement(orderPrice).getText();
    }



}
