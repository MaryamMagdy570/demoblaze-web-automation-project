package placeorder;


import base.BaseTests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.CartPage;

import static org.testng.Assert.assertEquals;

public class PlaceOrdersTests extends BaseTests {


    @Test
    public void testPlacingOrder(){
        var cartPage = homePage.clickCart();
        var placeOrderModal = cartPage.clickPlaceOrderButton();
        placeOrderModal.setNameField("Maryam");
        placeOrderModal.setCountryField("Eqyot");
        placeOrderModal.setCityField("Cairo");
        placeOrderModal.setCreditCardField("0000111122223333");
        placeOrderModal.setMonthField("September");
        placeOrderModal.setYearField("2024");
        var successfulOrder = placeOrderModal.clickPurchaseButton();
        assertEquals(successfulOrder.getSuccessfulOrderMessage(),"Thank you for your purchase!","Wrong Message");
        successfulOrder.clickOkButton();

    }

}
