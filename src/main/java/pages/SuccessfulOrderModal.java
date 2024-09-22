package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SuccessfulOrderModal{

    private WebDriver driver;
    private By successfulOrderMessage = By.xpath("/html[1]/body[1]/div[10]/h2[1]");
    private By successfulOrderDetails = By.xpath("//body/div[10]/p[1]");
    private By okButton = By.xpath("//button[contains(text(),'OK')]");

    public SuccessfulOrderModal(WebDriver driver) {
        this.driver = driver;
    }

    public String getSuccessfulOrderMessage(){
        return driver.findElement(successfulOrderMessage).getText();
    }

    private String[] getSuccessfulOrderDetails(){
        String OrderDetails = driver.findElement(successfulOrderDetails).getText();
        return OrderDetails.split("\\n");
    }

    public String getOrderId(){
        String id =  getSuccessfulOrderDetails()[0];
        return id.replace("Id: ","").trim();
    }

    public String getOrderAmountInUSD(){
        String amount =  getSuccessfulOrderDetails()[1];
        return amount.replace("Amount: ","").trim()
                .replace(" USD","").trim();
    }

    public String getOrderCardNumber(){
        String cardNumber = getSuccessfulOrderDetails()[2];
        return cardNumber.replace("Card Number: ","").trim();
    }

    public String getOrderName(){
        String name = getSuccessfulOrderDetails()[3];
        return name.replace("Name: ","").trim();
    }

    public String getOrderDate(){
        String Date = getSuccessfulOrderDetails()[4];
        return Date.replace("Date: ", "").trim();

    }

    public CartPage clickOkButton(){
        driver.findElement(okButton).click();
        return new CartPage(driver);
    }


}
