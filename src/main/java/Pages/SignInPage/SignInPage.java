package Pages.SignInPage;

import Infrastructure.Selenium;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;


public class SignInPage {

    Selenium selenium = new Selenium();
    static final Logger log = LogManager.getLogger(SignInPage.class);

    private static final String submitBtn  = "//button[@type=\"submit\"]";
    private static final String errorMessage  = "//div[@class=\"error-holder\"]";
    private static final String errorPopUp  = "//div[@class=\"notification type-validation\"]";
    private static final String instructionsSentToEmail  = "//*[@id=\"__layout\"]//div[@class=\"notification type-email\"]";
    private static final String forgotEmailBtn = "//a[@class=\"forgot\"]";
    private static final String startFreeTrialBtn = "//a[@href=\"/sign/up\"]";


    public void clickOnSubmitBtn(){
        try {
            Thread.sleep(Duration.ofSeconds(1));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        selenium.click(By.xpath(submitBtn));
    }

    public void clickOnStartFreeTrialBtn(){
        try {
            Thread.sleep(Duration.ofSeconds(1));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        selenium.click(By.xpath(startFreeTrialBtn));
    }

    public String getTheUrlSignUp() {
        try {
            Thread.sleep(Duration.ofSeconds(2));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return selenium.getUrl();
    }

    public boolean checkSignInFailPopUp(){
        return  selenium.find(By.xpath(errorPopUp)).isDisplayed();
    }

    public boolean checkSignInInstructionsSentPopUp(){
        return  selenium.find(By.xpath(instructionsSentToEmail)).isDisplayed();
    }

    public String checkErrorField_Text(){
        return selenium.getTextFromElement(By.xpath(errorMessage));
    }

    public void clickOnForgotEmailBtn(){
        try {
            Thread.sleep(Duration.ofSeconds(1));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        selenium.click(By.xpath(forgotEmailBtn));
    }

    public boolean checkIfThunderBirdOpened() throws IOException {
        try {
            Thread.sleep(Duration.ofSeconds(2));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String[] cmd = { "bash", "-c", "lsof | awk '{print $1}' | sort | uniq -c | sort -rn | head" };
        Process process = Runtime.getRuntime().exec(cmd);
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                process.getInputStream()));
        String s;
        while ((s = reader.readLine()) != null) {
            if(s.contains("thunder")){
                return true;
            };
        }
        return false;
    }




}
