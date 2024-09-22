package contact;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ContactModalTests extends BaseTests {

    @Test
    public void testContact(){
        var contactModal = homePage.clickContact();
        String email = "Basant@Maryam";
        String name = "Basant";
        String message="Basant&Maryam are Beautiful girls";


        String ContactMessage = contactModal.getContactModalMessage();
        assertEquals(ContactMessage,"New message","Wrong message");

        contactModal.setEmail(email);
        contactModal.setName(name);
        contactModal.setContactMessage(message);
        contactModal.clickSendMessage();

        assertTrue(contactModal.getAlertText().contains("Thanks for the message"),"wrong Alert Message");
        contactModal.AcceptAlert();

    }
}
