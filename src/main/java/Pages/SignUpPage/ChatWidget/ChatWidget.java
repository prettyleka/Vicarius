package Pages.SignUpPage.ChatWidget;

import Infrastructure.Selenium;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.time.Duration;

public class ChatWidget {
    Selenium selenium = new Selenium();
    static final Logger log = LogManager.getLogger(ChatWidget.class);
    private static final String chatMessage = "//div[@data-test-id=\"quick-reply-group\"]//div[contains(.,\"%s\")]";
    private static final String vbotAnswer = "//div[contains(@aria-label, \"vbot says:\")]";
    private static final String startNewChat = "//a[contains(@data-test-id, \"start-new-thread-button\")]";

    public void selectMessage(String chatInnerMessage){
        try {
            Thread.sleep(Duration.ofSeconds(1));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        selenium.click(By.xpath(String.format(chatMessage, chatInnerMessage)));
    }

    public String getVbotAnswer(){
        try {
            Thread.sleep(Duration.ofSeconds(1));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return selenium.getTextFromElement(By.xpath(vbotAnswer));
    }

    public void startNewChat(){
        try {
            Thread.sleep(Duration.ofSeconds(2));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        selenium.click(By.xpath(startNewChat));
    }



}
