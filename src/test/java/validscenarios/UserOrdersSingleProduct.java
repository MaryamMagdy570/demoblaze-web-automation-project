package validscenarios;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserOrdersSingleProduct extends BaseTests {

    @Test
    public void test(){
        var loginPage = homePage.clickLogin();
        String myUsername = "Maryam&Basant";
        String myPassword = "Maryam&Basant";
        loginPage.setUsernameField(myUsername);
        loginPage.setPasswordField(myPassword);
        String welcomeMessage = loginPage.clickLoginButton().getWelcomeMessage();
        assertEquals(welcomeMessage,"Welcome "+ myUsername,"Wrong login");


        var productPage=homePage.clickProduct("Samsung galaxy s6");
        productPage.clickAddToCartButton();
        assertTrue(productPage.getAlertText().contains("Product added"),"message is not correct");
        productPage.AcceptAlert();



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
