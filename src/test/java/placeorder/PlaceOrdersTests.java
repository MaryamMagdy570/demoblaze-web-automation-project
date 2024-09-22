package placeorder;


import base.BaseTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PlaceOrdersTests extends BaseTests {


    @DataProvider(name = "customerData")
    public Object[][] orderDataProvider() {
        return new Object[][] {
                // Format: {name, country, city, creditCard, month, year}
                {"Maryam", "Egypt", "Cairo", "0000111122223333", "9", "2024" },

        };
    }

    @Test(dataProvider = "customerData")
    public void testPlacingOrder(String name, String country, String city,
                                 String creditCard, String month, String year){
        var cartPage = homePage.clickCart();

        // GETTING AMOUNT OF ORDER
        var orderPrice = cartPage.getOrderPrice();

        var placeOrderModal = cartPage.clickPlaceOrderButton();
        placeOrderModal.setNameField(name);
        placeOrderModal.setCountryField(country);
        placeOrderModal.setCityField(city);
        placeOrderModal.setCreditCardField(creditCard);
        placeOrderModal.setMonthField(month);
        placeOrderModal.setYearField(year);


        var successfulOrder = placeOrderModal.clickPurchaseButton();


        // test successful order message
        softAssert.assertTrue(successfulOrder.getSuccessfulOrderMessage().contains("Thank you for your purchase"), "Wrong Message");

        // test id
        softAssert.assertTrue(successfulOrder.getOrderId().matches("\\d{7}"), " id is not a random number of 7 digits");

        // test Amount is the same of order price
        softAssert.assertEquals(successfulOrder.getOrderAmountInUSD(), orderPrice," order price is wrong");

        //test card number = the same entered
        softAssert.assertEquals(successfulOrder.getOrderCardNumber(),creditCard," wrong credit cart");


        //test Name on order is same as entered
        softAssert.assertEquals(successfulOrder.getOrderName(),name," wrong customer name");

        // test today date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        softAssert.assertEquals(LocalDate.parse(successfulOrder.getOrderDate(),formatter),
                        LocalDate.now(), "wrong date");

        // exit the modal
        successfulOrder.clickOkButton();

    }



}
