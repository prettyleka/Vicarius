package Pages.LandingPage;

import Infrastructure.Selenium;
import org.openqa.selenium.By;

public class LandingPage {
    Selenium selenium = new Selenium();


    private static final String signBtn = "//div[@class=\"d-flex\"]//a[contains(@href, \"sign/%s\")]";
    private static final String productBtn = "//*[@id=\"__layout\"]//button[contains(., \"Product\")]";

    public void clickOnSignBtn(String nameOfTab){
        selenium.click(By.xpath(String.format(signBtn,nameOfTab)));
    }

    public void clickOnProductBtn(){
        selenium.click(By.xpath(productBtn));
    }


}
