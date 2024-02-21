package Pages.SignUpPage;

import Infrastructure.Selenium;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Infrastructure.DriverCreation.driver;


public class SignUpPage {
    Selenium selenium = new Selenium();
    static final Logger log = LogManager.getLogger(SignUpPage.class);

    private static final String formInputs = "//*[contains(@placeholder, \"%s\")]";
    private static final String formInputsError = formInputs+"/parent::div/following-sibling::div[@class=\"error\"]";
    private static final String Header = "//h2";
    private static final String submitBtn  = "//button[@type=\"submit\"]";
    private static final String signUpFailPopUp  = "//*[@class=\"notification type-validation\"]";
    private static final String chatLauncherBtn = "//button[contains(@class, \"IconLauncher\")]";
    private static final String iframe = "//iframe[@id=\"hubspot-conversations-iframe\"]";
    private static final String faqBtn = "//*[@id=\"__layout\"]//div[@class=\"faq\"]/a";
    private static final String closeChatBtn = "//button[@aria-label=\"Close live chat\"]";

    public void setFormInputs(String placeholder, String input){
        selenium.sendKeys(By.xpath(String.format(formInputs,placeholder)), input);
    }

    public void setEmptyFormInputs(String placeholder, String nextPlaceholder){
        clickOnField(placeholder);
        clickOnField(nextPlaceholder);
    }

    public void checkErrorField(String placeholder){
        selenium.find(By.xpath(String.format(formInputsError,placeholder)));
    }

    public String checkErrorField_Text(String placeholder){
        return selenium.getTextFromElement(By.xpath(String.format(formInputsError,placeholder)));
    }

    public void clickOnField(String placeholder){
        selenium.click(By.xpath(String.format(formInputs,placeholder)));
    }

    public void clearField(String placeholder){
        selenium.clearField(By.xpath(String.format(formInputs,placeholder)));
    }

    public void clickOnHeader(){
        selenium.click(By.xpath(Header));
    }

    public void clickOnSubmitBtn(){
        try {
            Thread.sleep(Duration.ofSeconds(1));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        selenium.click(By.xpath(submitBtn));
    }

    public boolean checkSignUpFailPopUp(){
        return  selenium.find(By.xpath(signUpFailPopUp)).isDisplayed();
    }

    public void clickOnChatBtn(){
        selenium.switchIFrame(By.xpath(iframe));
        selenium.click(By.xpath(chatLauncherBtn));
    }

    public void closeChat(){
        try {
            Thread.sleep(Duration.ofSeconds(1));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        selenium.click(By.xpath(closeChatBtn));
    }

    public void clickFrequentlyAskedQuestions(){
        try {
            Thread.sleep(Duration.ofSeconds(2));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.xpath(faqBtn))).click();        ;
    }

    public String getTheUrlFAQ() {
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
       return selenium.getUrl();
    }
}
