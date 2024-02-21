package Pages.ProductPage.ProtectionSection;

import Infrastructure.Selenium;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.time.Duration;

public class ProtectionSection {
    Selenium selenium = new Selenium();
    static final Logger log = LogManager.getLogger(ProtectionSection.class);
    private static final String section = "//section[contains(@class,\"section protection\")]";
    private static final String sectionHeaderTitle = section+"//h2";
    private static final String sectionSubheaderTitle  = section+"//h4";
    private static final String sectionText  = section+"//p";
    private static final String learnMoreBtn  = "//div[@class=\"actions\"]/a";

    public String getSectionSubheaderText(){
        return selenium.getTextFromElement(By.xpath(sectionSubheaderTitle));
    }
    public String getSectionHeaderTitle(){
        return selenium.getTextFromElement(By.xpath(sectionHeaderTitle));
    }

    public String getSectionText(){
        return selenium.getTextFromElement(By.xpath(sectionText));
    }

    public void clickLearnMoreBtn(){
        selenium.click(By.xpath(learnMoreBtn));
    }

    public String getLearnMoreUrl(){
        try {
            Thread.sleep(Duration.ofSeconds(2));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return selenium.getUrl();
    }

    public void moveBack(){
        selenium.moveBack();
        try {
            Thread.sleep(Duration.ofSeconds(2));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
