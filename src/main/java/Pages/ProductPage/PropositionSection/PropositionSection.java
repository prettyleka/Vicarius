package Pages.ProductPage.PropositionSection;

import Infrastructure.Selenium;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PropositionSection {
    Selenium selenium = new Selenium();
    static final Logger log = LogManager.getLogger(PropositionSection.class);
    private static final String section = "//section[contains(@class,\"section proposition\")]";
    private static final String sectionUseCases = section+"//div[@class=\"item use-case\"]";
    private static final String sectionHeaderText = section+"//p[contains(.,\"Never think twice about deploying a patch again. vRx’s proprietary Patchless Protection™ tool secures threats swiftly and safely by deploying a protective force field around high-risk vulnerable apps.\")]";
    private static final String sectionUseCasesTitles = sectionUseCases+"//h3";
    private static final String sectionUseCasesTexts = sectionUseCases+"//p";

    public boolean checkSectionHeaderText(){
        return selenium.isElementExist(By.xpath(sectionHeaderText));
    }

    public List<String> getSectionUseCasesTitles(){
        List<WebElement> titles = selenium.findAll(By.xpath(sectionUseCasesTitles));
        List<String> t = new ArrayList<>();
        int x=0;
        while(x<titles.size()){
            t.add(x, titles.get(x).getText());
            x++;
        }
        return t;
    }

    public List<String> getSectionUseCasesTexts(){
        List<WebElement> titles = selenium.findAll(By.xpath(sectionUseCasesTexts));
        List<String> t = new ArrayList<>();
        int x=0;
        while(x<titles.size()){
            t.add(x, titles.get(x).getText());
            x++;
        }
        return t;
    }



}
