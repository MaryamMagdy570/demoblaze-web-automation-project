package login;

import base.BaseTests;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTests {



    @Test
    public void testLogin(){
        var loginPage = homePage.clickLogin();
        String myUsername = "Maryam&Basant";
        String myPassword = "Maryam&Basant";
        loginPage.setUsernameField(myUsername);
        loginPage.setPasswordField(myPassword);
        String welcomeMessage = loginPage.clickLoginButton().getWelcomeMessage();
        assertEquals(welcomeMessage,"Welcome "+ myUsername,"Wrong login");
    }

}
