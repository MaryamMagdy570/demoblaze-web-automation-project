package signUp;

import base.BaseTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SignUpModal;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SignUpTests extends BaseTests {


    @Test
    public void testingSignUpWithRegisteredUser (){
        var signUpModal=homePage.clickSignUp();
        String Username="Maryam&Basant";  //already registered
        String Password="Maryam&Basant";  //already registered

        signUpModal.setSignUpUsernameField(Username);
        signUpModal.setSignUpPasswordField(Password);
        signUpModal.clickSignUpButton();
        assertTrue(signUpModal.getAlertText().contains("This user already exist"),"message is not correct");
        signUpModal.AcceptAlert();

    }

    @DataProvider(name = "testSignUPFunctionality")
    public Object[][] signUPDataProvider() {
        return new Object[][] {
                // Format: {name, country, city, creditCard, month, year}
                {7, 6},
                {7,2},



        };
    }

    @Test(dataProvider = "signUPDataProvider")
    public void testSignUPFunctionality(int usernameSize,int passwordSize){
        var signUpModal=homePage.clickSignUp();
        String Username= SignUpModal.RandomUtils.getRandomString(usernameSize);
        String Password=SignUpModal.RandomUtils.getRandomString(passwordSize);

        signUpModal.setSignUpUsernameField(Username);
        signUpModal.setSignUpPasswordField(Password);
        signUpModal.clickSignUpButton();
        assertTrue(signUpModal.getAlertText().contains("Sign up successful."),"message is not correct");
        signUpModal.AcceptAlert();
    }
}
