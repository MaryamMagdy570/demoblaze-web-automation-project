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
    }
}
