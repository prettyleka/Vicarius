package Tests;

import Infrastructure.Selenium;
import Infrastructure.Utils.ConfigurationsReader;
import Pages.DemoPage.DemoPage;
import Pages.LandingPage.LandingPage;
import Pages.ProductPage.FeaturesTitles;
import Pages.ProductPage.ProductPage;
import Pages.ProductPage.Products;
import Pages.ProductPage.PropositionSection.PropositionSection;
import Pages.ProductPage.PropositionSection.UseCaseText;
import Pages.ProductPage.ProtectionSection.ProtectionSection;
import Pages.ProductPage.ProtectionSection.ProtectionSectionTexts;
import Pages.ProductPage.XtagSection.XtagHeaderText;
import Pages.ProductPage.XtagSection.XtagSection;
import Pages.ProductPage.Sections;
import Pages.ProductPage.Video.Titles;
import Pages.ProductPage.Video.VideoPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import static Pages.ProductPage.PropositionSection.UseCaseTitle.*;

public class ProductTests {
    private final Selenium selenium = new Selenium();
    private final LandingPage landingPage = new LandingPage();
    private final ProductPage productPage = new ProductPage();
    private final PropositionSection propositionSection = new PropositionSection();
    private final Products products = new Products();
    private final VideoPage videoPage = new VideoPage();
    private final Sections sections = new Sections();
    private final Titles titles = new Titles();
    private final UseCaseText useCaseText = new UseCaseText();
    private final FeaturesTitles featuresTitles = new FeaturesTitles();
    private final XtagSection xtagSection = new XtagSection();
    private final XtagHeaderText xtagHeaderText = new XtagHeaderText();
    private final ProtectionSection protectionSection = new ProtectionSection();
    private final ProtectionSectionTexts protectionSectionTexts = new ProtectionSectionTexts();
    private final DemoPage demoPage = new DemoPage();
    private final ConfigurationsReader cr = new ConfigurationsReader();
    static final Logger log = LogManager.getLogger(ProductPage.class);



    @Test(singleThreaded = true)
    public void ProductTest(){
        log.info("Move to the overview section");
        productPage.clickOnProductBtn(products.overview());
        log.info("Click on watch demo btn");
        productPage.clickOnWatchDemo();
        log.info("Check the video pop up");
        videoPage.checkVideoPopUp();
        log.info("Close the video pop up");
        videoPage.closeVideo();
        log.info("Scroll to the Features section");
        productPage.scrollToSections(sections.features());
        log.info("Hover with mouse over the titles of ANALYZE part of features section");
        productPage.checkTheTitle(titles.cve());
        productPage.checkTheTitle(titles.asset());
        productPage.checkTheTitle(titles.app());
        productPage.checkTheTitle(titles.dashboard());

        log.info("Hover with mouse over the titles of PRIORITIZE part of features section");
        productPage.scrollToFeaturesSectionTitles(featuresTitles.PRIORITIZE());
        productPage.checkTheTitle(titles.prioritization());
        productPage.checkTheTitle(titles.x_tag());
        productPage.checkTheTitle(titles.risk());
        productPage.checkTheTitle(titles.mapping());

        log.info("Hover with mouse over the titles of ACT part of features section");
        productPage.scrollToFeaturesSectionTitles(featuresTitles.ACT());
        productPage.checkTheTitle(titles.eliminate());
        productPage.checkTheTitle(titles.engine());
        productPage.checkTheTitle(titles.patch());
        productPage.checkTheTitle(titles.patchless());

        log.info("Scroll to the Proposition section");
        productPage.scrollToSections(sections.proposition());
        log.info("Check the header test part");
        Assert.assertTrue(propositionSection.checkSectionHeaderText());
        log.info("Check the titles of use cases");
        List<String> titles = propositionSection.getSectionUseCasesTitles();
        assert (titles.contains(Analyze.toString()));
        assert (titles.contains(Monitor.toString()));
        assert (titles.contains(Protect.toString()));

        log.info("Check texts of use cases");
        List<String> texts = propositionSection.getSectionUseCasesTexts();
        assert (texts.contains(useCaseText.Analyze()));
        assert (texts.contains(useCaseText.Monitor()));
        assert (texts.contains(useCaseText.Protect()));

        log.info("Scroll to the Xtag section");
        productPage.scrollToSections(sections.xtags());
        log.info("Check the text in the header");
        Assert.assertEquals(xtagSection.getSectionHeaderText(), xtagHeaderText.headerText());
        log.info("Check the text in the title");
        Assert.assertEquals(xtagSection.getSectionHeaderTitle(), xtagHeaderText.headerTitle());
        log.info("Hover with mouse over the moving row of blocks");
        xtagSection.hoverOverMovingRow();

        log.info("Scroll to the Protection section");
        productPage.scrollToSections(sections.protection());
        log.info("Check text in the subheader");
        Assert.assertEquals(protectionSection.getSectionSubheaderText(), protectionSectionTexts.subheaderTitle());
        log.info("Check text in the header title");
        Assert.assertEquals(protectionSection.getSectionHeaderTitle(), protectionSectionTexts.headerTitle());
        log.info("Check text in the header title");
        Assert.assertEquals(protectionSection.getSectionText(), protectionSectionTexts.headerText());
        log.info("Click on learn more btn");
        protectionSection.clickLearnMoreBtn();
        log.info("Check the url of learn more page");
        Assert.assertEquals(protectionSection.getLearnMoreUrl(), "https://www.vicarius.io/product/0-day-detection");
        log.info("Move back to the product page");
        protectionSection.moveBack();

        log.info("Scroll to the Demos section");
        productPage.scrollToSections(sections.demos());
        log.info("Play the all videos in the section");
        demoPage.playAllVideos();
    }




    @BeforeMethod
    public void Before(){
        log.info("STARTING SIGN UP TEST");
        selenium.moveToUrl(cr.getUrl());
        log.info("Entered to the site");
        landingPage.clickOnProductBtn();
        log.info("Clicked on product btn");
    }

    @AfterMethod
    public void After(){
        selenium.driverDown();
    }
}
