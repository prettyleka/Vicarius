package Pages.DemoPage;

import Infrastructure.Selenium;
import Pages.ProductPage.Video.VideoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class DemoPage {

    Selenium selenium = new Selenium();
    VideoPage videoPage = new VideoPage();


    private static final String nextBtn = "//div[@class=\"overlay-next\"]";
    private static final String playBtn = "//div[@class=\"list-outer\"]//div[contains(@class, \"video\")]//span[contains(@class, \"btn-play\")]";

    public void clickNextBtn(){
        selenium.click(By.xpath(nextBtn));
        try {
            Thread.sleep(Duration.ofSeconds(1));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void playAllVideos(){
        List<WebElement> videos = selenium.findAll(By.xpath(playBtn));
        int x=0;
        while(x<videos.size()){
            if(x%2!=0){
                videos.get(x).click();
                videoPage.checkVideoPopUp();
                videoPage.closeVideo();
                x++;
                clickNextBtn();
            }
            else{
                videos.get(x).click();
                videoPage.checkVideoPopUp();
                videoPage.closeVideo();
                x++;
            }
        }
    }

}
