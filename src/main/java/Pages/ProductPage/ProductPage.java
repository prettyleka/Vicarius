package Pages.ProductPage;

import Infrastructure.Selenium;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class ProductPage {
    Selenium selenium = new Selenium();
    static final Logger log = LogManager.getLogger(ProductPage.class);
    private static final String productsBtn = "//*[@id=\"__layout\"]//span[.=\"%s\"]";
    private static final String watchDemoBtn = "//span[.=\"Watch Demo\"]/parent::button";
    private static final String sections = "//section[contains(@class,\"section %s\")]";
    private static final String sectionsTitle = "//*[@id=\"__layout\"]//ul/li/h4[.=\"%s\" and @class=\"heading hover-only\"]";
    private static final String featureSectionsTitle = " //div[contains(text(), \"%s\")]/parent::div/ul";

    public void clickOnProductBtn(String product){
        selenium.click(By.xpath(String.format(productsBtn, product)));
    }

    public void clickOnWatchDemo(){
        selenium.click(By.xpath(watchDemoBtn));
    }

    public void scrollToSections(String section){
        selenium.scrollUntilTheElementExist(By.xpath(String.format(sections, section)));
    }

    public void scrollToFeaturesSectionTitles(String title){
        selenium.scrollUntilTheElementExist(By.xpath(String.format(featureSectionsTitle, title)));
    }
    public void checkTheTitle(String title){
        selenium.hoverWithMouse(By.xpath(String.format(sectionsTitle, title)));
    }


}
