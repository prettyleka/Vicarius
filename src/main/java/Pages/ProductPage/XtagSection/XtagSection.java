package Pages.ProductPage.XtagSection;

import Infrastructure.Selenium;
import Pages.ProductPage.ProtectionSection.ProtectionSection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class XtagSection {
    Selenium selenium = new Selenium();
    static final Logger log = LogManager.getLogger(XtagSection.class);
    private static final String section = "//section[contains(@class,\"section xtags\")]";
    private static final String sectionHeaderTitle = section+"//h2";
    private static final String sectionHeaderText = sectionHeaderTitle+"/parent::div/p";
    private static final String movingRow ="//div[contains(@class, \"hover-only\")]//div[contains(@class, \"item-holder\")]//h4";

    public String getSectionHeaderText(){
        return selenium.getTextFromElement(By.xpath(sectionHeaderText));
    }
    public String getSectionHeaderTitle(){
        return selenium.getTextFromElement(By.xpath(sectionHeaderTitle));
    }

    public void hoverOverMovingRow(){
        List<WebElement> row = selenium.findAll(By.xpath(movingRow));
        int x=0;
        while(x<row.size()){
            selenium.hoverWithMouse_Element(row.get(x));
            x++;
        }
    }
}

