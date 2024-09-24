package signUp;

import base.BaseTests;
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

    @Test
    public void testSignUPFunctionality(){
        var signUpModal=homePage.clickSignUp();
        String Username= SignUpModal.RandomUtils.getRandomString(8);
        String Password=SignUpModal.RandomUtils.getRandomString(10);

        signUpModal.setSignUpUsernameField(Username);
        signUpModal.setSignUpPasswordField(Password);
        signUpModal.clickSignUpButton();
        assertTrue(signUpModal.getAlertText().contains("Sign up successful."),"message is not correct");
        signUpModal.AcceptAlert();
    }
}
