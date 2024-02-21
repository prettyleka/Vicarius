package Pages.ProductPage.Video;

import Infrastructure.Selenium;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class VideoPage {
    Selenium selenium = new Selenium();
    static final Logger log = LogManager.getLogger(VideoPage.class);
    private static final String videoIFrame = "//div[@class=\"popup-video-inner\"]/iframe";
    private static final String videoPopUp = "//div[@class=\"popup-video-inner\"]";
    private static final String closeBtn = "//button[@class=\"btn-close\"]";


    public void checkVideoPopUp(){
        try {
            Thread.sleep(Duration.ofSeconds(1));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertTrue(selenium.isElementExist(By.xpath(videoPopUp)));
    }

    public void closeVideo(){

        selenium.click(By.xpath(closeBtn));
        try {
            Thread.sleep(Duration.ofSeconds(1));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
