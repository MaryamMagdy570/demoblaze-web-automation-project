package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessfulOrderModal{

    private WebDriver driver;
    private By successfulOrderMessage = By.xpath("//h2[contains(text(),'Thank you for your purchase!')]");
    private By okButtuon = By.xpath("//button[contains(text(),'OK')]");

    public SuccessfulOrderModal(WebDriver driver) {
        this.driver = driver;
    }

    public String getSuccessfulOrderMessage(){
        return driver.findElement(successfulOrderMessage).getText();
    }

    public CartPage clickOkButton(){
        driver.findElement(okButtuon).click();
        return new CartPage(driver);
    }


}
