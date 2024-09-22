package addProduct;

import base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class AddProductTests extends BaseTests {

    @Test
    public void testAddproduct (){
        // Replace with an actual element
        var productPage=homePage.clickProduct("Samsung galaxy s6");
        productPage.clickAddToCartButton();
        assertEquals(productPage.getAlertText(),"Product added","message is not correct");
        productPage.AcceptAlert();
        driver.findElement(By.partialLinkText("Home")).click();
    }

    @Test
    public void testAddMultipleProducts (){
        var productPage=homePage.clickProduct("Samsung galaxy s6");
        productPage.clickAddToCartButton();
        assertEquals(productPage.getAlertText(),"Product added","message is not correct");
        productPage.AcceptAlert();
        driver.findElement(By.partialLinkText("Home")).click();
         productPage=homePage.clickProduct("Nokia lumia 1520");
        productPage.clickAddToCartButton();
        assertEquals(productPage.getAlertText() ,"Product added" ,"message is not correct");
        productPage.AcceptAlert();
    }


}
