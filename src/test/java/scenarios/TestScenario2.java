package scenarios;

import base.BaseTests;
import login.LoginTests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.prefs.BackingStoreException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestScenario2 extends BaseTests {

    @Test
    public void test() {
        var loginPage = homePage.clickLogin();
        String myUsername = "Maryam&Basant";
        String myPassword = "Maryam&Basant";
        loginPage.setUsernameField(myUsername);
        loginPage.setPasswordField(myPassword);
        String welcomeMessage = loginPage.clickLoginButton().getWelcomeMessage();
        assertEquals(welcomeMessage ,"Welcome " + myUsername ,"Wrong login");


        var productPage=homePage.clickProduct("Samsung galaxy s6");
        productPage.clickAddToCartButton();
        assertTrue(productPage.getAlertText().contains("Product added"),"message is not correct");
        productPage.AcceptAlert();
        driver.findElement(By.partialLinkText("Home")).click();
        productPage=homePage.clickProduct("Nokia lumia 1520");
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
        assertEquals(successfulOrder.getSuccessfulOrderMessage() ,"Thank you for your purchase!" ,"Wrong Message");
        successfulOrder.clickOkButton();

    }
}