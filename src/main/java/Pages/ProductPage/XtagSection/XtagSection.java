package Pages.ProductPage.XtagsSection;

import Infrastructure.Selenium;
import Pages.ProductPage.ProtectionSection.ProtectionSection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class XtagsSection {
    Selenium selenium = new Selenium();
    static final Logger log = LogManager.getLogger(ProtectionSection.class);
    private static final String section = "//section[contains(@class,\"section xtags\")]";
    private static final String sectionHeaderTitle = section+"//h2";
    private static final String sectionHeaderText = sectionHeaderTitle+"/parent::div/p";
}
