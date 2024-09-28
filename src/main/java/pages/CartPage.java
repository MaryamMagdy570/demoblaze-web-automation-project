package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

    private WebDriver driver;
    private By placeOrderButton = By.xpath("//button[contains(text(),'Place Order')]");

    private By orderPrice = By.xpath("//h3[@id='totalp']");

    private By tableOfProducts = By.cssSelector("#tbodyid");
    private By products = By.xpath("//tbody[@id='tbodyid']/tr");


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
        String totalAmount =  driver.findElement(orderPrice).getText();
        return (totalAmount == null || totalAmount.isEmpty()) ? "0" : totalAmount;
    }

    public String[] getProductsList() {

        WebElement tableBody = driver.findElement(tableOfProducts);

        WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(products));

        List<WebElement> productRows = tableBody.findElements(products);

        String[] productsNamesList = new String[productRows.size()];
        for (int i = 0; i < productRows.size(); i++) {
            List<WebElement> productDetails = productRows.get(i).findElements(By.tagName("td"));
            productsNamesList[i] = productDetails.get(1).getText().toString();
        }
        return productsNamesList;
    }

}
