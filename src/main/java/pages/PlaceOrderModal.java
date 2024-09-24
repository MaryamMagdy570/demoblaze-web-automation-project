package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlaceOrderModal{

    private WebDriver driver;
    private By nameField = By.id("name");
    private By countryField = By.id("country");
    private By cityField = By.id("city");
    private By creditCardField = By.id("card");
    private By monthField = By.id("month");
    private By yearField = By.id("year");
    private By purchaseButton = By.xpath("//button[contains(text(),'Purchase')]");


    public PlaceOrderModal(WebDriver driver) {
        this.driver = driver;
    }

    public void setNameField(String name){
        driver.findElement(nameField).sendKeys(name);
    }

    public void setCountryField(String country){
        driver.findElement(countryField).sendKeys(country);
    }


    public void setCityField(String city){
        driver.findElement(cityField).sendKeys(city);
    }

    public void setCreditCardField(String creditCard){
        driver.findElement(creditCardField).sendKeys(creditCard);
    }

    public void setMonthField(String month){
        driver.findElement(monthField).sendKeys(month);
    }
    public void setYearField(String year){
        driver.findElement(yearField).sendKeys(year);
    }

    public SuccessfulOrderModal clickPurchaseButton(){
        driver.findElement(purchaseButton).click();
        return new SuccessfulOrderModal(driver);
    }



}
