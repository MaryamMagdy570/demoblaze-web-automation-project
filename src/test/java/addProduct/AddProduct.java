package addProduct;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddProduct extends BaseTests {

    @Test
    public void testAddproduct (){
        var productPage=homePage.clickProduct("Samsung galaxy s6");
       // productPage.clickButton();
      //  assertEquals(productPage.getAlertText(),"Product added.","message is not correct");
       // productPage.AcceptAlert();
    }
}
