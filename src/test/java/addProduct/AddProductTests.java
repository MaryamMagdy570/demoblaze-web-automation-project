package addProduct;

import base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ProductPage;

import java.time.Duration;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddProductTests extends BaseTests {



    // test single product
    @Test
    public void testAddproduct (){
        // Replace with an actual element
        var productPage=homePage.clickProduct("Samsung galaxy s6");
        productPage.clickAddToCartButton();
        assertEquals(productPage.getAlertText(),"Product added","message is not correct");
        productPage.AcceptAlert();
        driver.findElement(By.partialLinkText("Home")).click();
    }


    @DataProvider (name = "products")
    public Object[][] orderDataProvider() {
        return new Object[][] {
                // Format: {number of products, products}
                {new String[] {"Samsung galaxy s6",} },
                {new String[] {"Samsung galaxy s6","Nokia lumia 1520"} },
                {new String[] {"Samsung galaxy s6","Nokia lumia 1520","Nexus 6"} }
        };
    }
    //TODO: comment: to use data provider we should clear cart before each test



    // test a configurable number of products
    @Test (dataProvider = "products")
    public void testAddMultipleProducts (){

        String[]productsAddedList = new String[] {"Samsung galaxy s6","Nokia lumia 1520","Nexus 6"};
        ProductPage productPage;
        for (String productItem: productsAddedList){
            productPage=homePage.clickProduct(productItem);
            productPage.clickAddToCartButton();
            assertEquals(productPage.getAlertText(),"Product added","message is not correct");
            productPage.AcceptAlert();
            driver.findElement(By.partialLinkText("Home")).click();
        }

        var cartPage = homePage.clickCart();
        String []productsList = cartPage.getProductsList();

        Arrays.sort(productsList);
        Arrays.sort(productsAddedList);

        assertTrue(Arrays.equals(productsList, productsAddedList),"missed products");

    }

    //TODO: testing delete button


}

