package Tests;

import Infrastructure.Selenium;
import Infrastructure.Utils.ConfigurationsReader;
import Pages.LandingPage.LandingPage;
import Pages.LandingPage.SignBtn;
import Pages.SignUpPage.ChatWidget.ChatMessages;
import Pages.SignUpPage.ChatWidget.ChatWidget;
import Pages.SignUpPage.ChatWidget.VbotAnwsers;
import Pages.SignUpPage.SignUpForm.ErrorMessage;
import Pages.SignUpPage.SignUpForm.SignUpForm;
import Pages.SignUpPage.SignUpPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;


public class SignUpTests {
    private final Selenium selenium = new Selenium();
    private final LandingPage landingPage = new LandingPage();
    private final SignUpPage signUpPage = new SignUpPage();
    private final ErrorMessage errorMessage = new ErrorMessage();
    private final ConfigurationsReader cr = new ConfigurationsReader();
    private final ChatWidget chatWidget = new ChatWidget();
    private final ChatMessages chatMessages = new ChatMessages();
    private final VbotAnwsers vbotAnwsers = new VbotAnwsers();
    static final Logger log = LogManager.getLogger(SignUpTests.class);

    @Test()
    public void SignUpTest(){
        log.info("Click on continue btn without filling fields");
        signUpPage.clickOnSubmitBtn();
        log.info("Check the sign up error pop up");
        signUpPage.checkSignUpFailPopUp();
        log.info("Check error message in all fields");
        signUpPage.checkErrorField(SignUpForm.First.toString());
        Assert.assertEquals(signUpPage.checkErrorField_Text(SignUpForm.First.toString()), errorMessage.isRequired());
        signUpPage.checkErrorField(SignUpForm.Last.toString());
        Assert.assertEquals(signUpPage.checkErrorField_Text(SignUpForm.Last.toString()), errorMessage.isRequired());
        signUpPage.checkErrorField(SignUpForm.Work.toString());
        Assert.assertEquals(signUpPage.checkErrorField_Text(SignUpForm.Work.toString()), errorMessage.isRequired());
        signUpPage.checkErrorField(SignUpForm.Company.toString());
        Assert.assertEquals(signUpPage.checkErrorField_Text(SignUpForm.Company.toString()), errorMessage.isRequired());

        log.info("Refresh the page");
        selenium.refreshPage();

        log.info("Set all fields empty");
        signUpPage.setEmptyFormInputs(SignUpForm.First.toString(), SignUpForm.Last.toString());
        signUpPage.setEmptyFormInputs(SignUpForm.Work.toString(), SignUpForm.Company.toString());
        signUpPage.clickOnHeader();
        log.info("Check error message in all fields");
        signUpPage.checkErrorField(SignUpForm.First.toString());
        Assert.assertEquals(signUpPage.checkErrorField_Text(SignUpForm.First.toString()), errorMessage.isRequired());
        signUpPage.checkErrorField(SignUpForm.Last.toString());
        Assert.assertEquals(signUpPage.checkErrorField_Text(SignUpForm.Last.toString()), errorMessage.isRequired());
        signUpPage.checkErrorField(SignUpForm.Work.toString());
        Assert.assertEquals(signUpPage.checkErrorField_Text(SignUpForm.Work.toString()), errorMessage.isRequired());
        signUpPage.checkErrorField(SignUpForm.Company.toString());
        Assert.assertEquals(signUpPage.checkErrorField_Text(SignUpForm.Company.toString()), errorMessage.isRequired());

        log.info("Send only letter to the email field");
        signUpPage.setFormInputs(SignUpForm.Work.toString(), cr.getWrongEmailLetter());
        log.info("Check valid email message in the field");
        Assert.assertEquals(signUpPage.checkErrorField_Text(SignUpForm.Work.toString()), errorMessage.validEmail());

        log.info("Fill all fields with valid values besides email field");
        signUpPage.setFormInputs(SignUpForm.First.toString(), cr.getFirstName());
        signUpPage.setFormInputs(SignUpForm.Last.toString(), cr.getLastName());
        signUpPage.setFormInputs(SignUpForm.Company.toString(), cr.getCompanyName());
        signUpPage.clearField(SignUpForm.Work.toString());
        log.info("Send only symbol to the email field");
        signUpPage.setFormInputs(SignUpForm.Work.toString(), cr.getWrongEmailSymbol());
        log.info("Check valid email message in the field");
        Assert.assertEquals(signUpPage.checkErrorField_Text(SignUpForm.Work.toString()), errorMessage.validEmail());
        log.info("Send valid email to the email field");
        signUpPage.clearField(SignUpForm.Work.toString());
        signUpPage.setFormInputs(SignUpForm.Company.toString(), cr.getEmail());

    }


    @Test()
    public void ChatTest(){
        log.info("Clicked on chat widget btn");
        signUpPage.clickOnChatBtn();
        log.info("Select the message about free trial");
        chatWidget.selectMessage(chatMessages.freeTrial().toString());
        log.info("Check the vbot answer");
        Assert.assertEquals(chatWidget.getVbotAnswer(), vbotAnwsers.freeTrial().toString());
        log.info("Start new chat");
        chatWidget.startNewChat();

        log.info("Select the message about demo");
        chatWidget.selectMessage(chatMessages.demo().toString());
        log.info("Check the vbot answer");
        Assert.assertEquals(chatWidget.getVbotAnswer(), vbotAnwsers.demo().toString());
        log.info("Start new chat");
        chatWidget.startNewChat();

        log.info("Select the message about talk with team");
        chatWidget.selectMessage(chatMessages.talk().toString());
        log.info("Check the vbot answer");
        Assert.assertEquals(chatWidget.getVbotAnswer(), vbotAnwsers.talk().toString());
        log.info("Clicked on chat widget btn, close");
        signUpPage.closeChat();
    }

    @Test(singleThreaded = true)
    public void FrequentlyAskedQuestionsTest(){
        log.info("Click on Frequently Asked Questions link");
        signUpPage.clickFrequentlyAskedQuestions();
        log.info("Check the link in the new opened tab");
        Assert.assertEquals(signUpPage.getTheUrlFAQ(), "https://customer-portal.vicarius.io/");
    }


    @BeforeMethod
    public void Before(){
        log.info("STARTING SIGN UP TEST");
        selenium.moveToUrl(cr.getUrl());
        log.info("Entered to the site");
        landingPage.clickOnSignBtn(SignBtn.up.toString());
        log.info("Clicked on sign up btn");
    }

    @AfterMethod(alwaysRun = true)
    public void After(){
        selenium.driverDown();
    }
}

