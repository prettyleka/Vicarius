package Tests;

import Infrastructure.Selenium;
import Infrastructure.Utils.ConfigurationsReader;
import Pages.LandingPage.LandingPage;
import Pages.LandingPage.SignBtn;
import Pages.SignInPage.SignInPage;
import Pages.SignInPage.ErrorMessage;
import Pages.SignUpPage.SignUpForm.SignUpForm;
import Pages.SignUpPage.SignUpPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class SignInTests {
    private final Selenium selenium = new Selenium();
    private final LandingPage landingPage = new LandingPage();
    private final ConfigurationsReader cr = new ConfigurationsReader();
    private final SignInPage signInPage = new SignInPage();
    private final SignUpPage signUpPage = new SignUpPage();
    private final ErrorMessage errorMessage = new ErrorMessage();
    static final Logger log = LogManager.getLogger(SignInTests.class);


    @Test(singleThreaded = true)
    public void SignInTest() throws IOException {
        log.info("Click on Login btn without filling fields");
        signInPage.clickOnSubmitBtn();
        log.info("Check the login error message");
        Assert.assertEquals(signInPage.checkErrorField_Text(), errorMessage.invalidAddress());
        log.info("Check the login error pop up");
        signInPage.checkSignInFailPopUp();
        log.info("Send only letter to the email field");
        signUpPage.setFormInputs(SignUpForm.Work.toString(), cr.getWrongEmailLetter());
        log.info("Check invalid address message in the field");
        Assert.assertEquals(signInPage.checkErrorField_Text(), errorMessage.invalidAddress());

        signUpPage.clearField(SignUpForm.Work.toString());
        log.info("Send only symbol to the email field");
        signUpPage.setFormInputs(SignUpForm.Work.toString(), cr.getWrongEmailSymbol());
        log.info("Check invalid address message in the field");
        Assert.assertEquals(signInPage.checkErrorField_Text(), errorMessage.invalidAddress());

        signUpPage.clearField(SignUpForm.Work.toString());
        log.info("Send valid email address to the field");
        signUpPage.setFormInputs(SignUpForm.Work.toString(), cr.getEmail());
        log.info("Click on Login btn");
        signInPage.clickOnSubmitBtn();
        log.info("Check the login error pop up");
        signInPage.checkSignInInstructionsSentPopUp();

        log.info("Click on forgot email btn");
        signInPage.clickOnForgotEmailBtn();
        log.info("Check if Thunderbird opened");
        Assert.assertTrue (signInPage.checkIfThunderBirdOpened());

        log.info("Click on start free tiral link");
        signInPage.clickOnStartFreeTrialBtn();
        log.info("Check the link");
        Assert.assertEquals(signInPage.getTheUrlSignUp(), "https://www.vicarius.io/sign/up");
    }


    @BeforeMethod
    public void Before(){
        log.info("STARTING SIGN UP TEST");
        selenium.moveToUrl(cr.getUrl());
        log.info("Entered to the site");
        landingPage.clickOnSignBtn(SignBtn.in.toString());
        log.info("Clicked on sign in btn");
    }

    @AfterMethod
    public void After(){
        selenium.driverDown();
    }

}
