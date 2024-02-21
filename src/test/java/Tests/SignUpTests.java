package Tests;

import Infrastructure.Selenium;
import Infrastructure.Utils.ConfigurationsReader;
import Pages.LandingPage.LandingPage;
import Pages.LandingPage.SignBtn;
import Pages.SignUpPage.ErrorMessage;
import Pages.SignUpPage.SignUpForm;
import Pages.SignUpPage.SignUpPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class Tests {
    Selenium selenium = new Selenium();
    LandingPage landingPage = new LandingPage();
    SignUpPage signUpPage = new SignUpPage();
    ErrorMessage errorMessage = new ErrorMessage();
    ConfigurationsReader cr = new ConfigurationsReader();
    static final Logger log = LogManager.getLogger(Tests.class);

    @Test
    public void SignUpTest(){
        log.debug("STARTING SIGN UP TEST");
        selenium.moveToUrl(cr.getUrl());
        log.debug("Entered to the site");
        landingPage.clickOnSignBtn(SignBtn.up.toString());
        log.debug("Clicked on sign up btn");

        log.debug("Click on continue btn without filling fields");
        signUpPage.clickOnSubmitBtn();
        log.debug("Check the sign up error pop up");
        signUpPage.checkSignUpFailPopUp();
        log.debug("Check error message in all fields");
        signUpPage.checkErrorField(SignUpForm.First.toString());
        Assert.assertEquals(signUpPage.checkErrorField_Text(SignUpForm.First.toString()), errorMessage.isRequired());
        signUpPage.checkErrorField(SignUpForm.Last.toString());
        Assert.assertEquals(signUpPage.checkErrorField_Text(SignUpForm.Last.toString()), errorMessage.isRequired());
        signUpPage.checkErrorField(SignUpForm.Work.toString());
        Assert.assertEquals(signUpPage.checkErrorField_Text(SignUpForm.Work.toString()), errorMessage.isRequired());
        signUpPage.checkErrorField(SignUpForm.Company.toString());
        Assert.assertEquals(signUpPage.checkErrorField_Text(SignUpForm.Company.toString()), errorMessage.isRequired());

        log.debug("Refresh the page");
        selenium.refreshPage();

        log.debug("Set all fields empty");
        signUpPage.setEmptyFormInputs(SignUpForm.First.toString(), SignUpForm.Last.toString());
        signUpPage.setEmptyFormInputs(SignUpForm.Work.toString(), SignUpForm.Company.toString());
        signUpPage.clickOnHeader();
        log.debug("Check error message in all fields");
        signUpPage.checkErrorField(SignUpForm.First.toString());
        Assert.assertEquals(signUpPage.checkErrorField_Text(SignUpForm.First.toString()), errorMessage.isRequired());
        signUpPage.checkErrorField(SignUpForm.Last.toString());
        Assert.assertEquals(signUpPage.checkErrorField_Text(SignUpForm.Last.toString()), errorMessage.isRequired());
        signUpPage.checkErrorField(SignUpForm.Work.toString());
        Assert.assertEquals(signUpPage.checkErrorField_Text(SignUpForm.Work.toString()), errorMessage.isRequired());
        signUpPage.checkErrorField(SignUpForm.Company.toString());
        Assert.assertEquals(signUpPage.checkErrorField_Text(SignUpForm.Company.toString()), errorMessage.isRequired());

        log.debug("Send only letter to the email field");
        signUpPage.setFormInputs(SignUpForm.Work.toString(), cr.getWrongEmailLetter());
        log.debug("Check valid email message in the field");
        Assert.assertEquals(signUpPage.checkErrorField_Text(SignUpForm.Work.toString()), errorMessage.validEmail());

        log.debug("Fill all fields with valid values besides email field");
        signUpPage.setFormInputs(SignUpForm.First.toString(), cr.getFirstName());
        signUpPage.setFormInputs(SignUpForm.Last.toString(), cr.getLastName());
        signUpPage.setFormInputs(SignUpForm.Company.toString(), cr.getCompanyName());
        signUpPage.clearField(SignUpForm.Work.toString());
        log.debug("Send only symbol to the email field");
        signUpPage.setFormInputs(SignUpForm.Work.toString(), cr.getWrongEmailSymbol());
        log.debug("Check valid email message in the field");
        Assert.assertEquals(signUpPage.checkErrorField_Text(SignUpForm.Work.toString()), errorMessage.validEmail());
        log.debug("Send valid email to the email field");
        signUpPage.clearField(SignUpForm.Work.toString());
        signUpPage.setFormInputs(SignUpForm.Company.toString(), cr.getEmail());

    }

    @AfterTest
    public void After(){
        selenium.driverDown();
    }
}

