package Infrastructure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterSuite;

import java.time.Duration;
import java.util.List;

import static java.time.Duration.ofSeconds;

public class Selenium {
    static final Logger log = LogManager.getLogger(Selenium.class);
    public static final WebDriver driver = DriverCreation.createDriver();


    /** Wait for specific ExpectedCondition for the given Duration */
    public void waitFor(ExpectedCondition<WebElement> condition, Duration timeOut) {
        timeOut = timeOut != null ? timeOut : ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(condition);
    }

    /**
     * Wait for given number of seconds for element with given locator to be visible
     * on the page
     */
    protected void waitForVisibilityOf(By locator, Duration... timeOut) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        (timeOut.length > 0 ? timeOut[0] : null));
                break;
            } catch (StaleElementReferenceException ignored) {
            }
            attempts++;
        }
    }


    /** Open page with given URL
     * @param url - link for move to
     * */
    public void moveToUrl(String url) {
        driver.get(url);
        log.info(String.format("Opened page with %s",url));
    }

    /** Find element using given locator
     * @param locator - locator to find the element
     * @return WebElement
     * */
    public WebElement find(By locator) {
        waitForVisibilityOf(locator, ofSeconds(10));
        log.info(String.format("Find element using given locator %s",locator));
        return driver.findElement(locator);
    }

    /** Check if element displayed using given locator
     * @param locator - locator to find the element
     * @return boolean
     * */
    public boolean isElementExist(By locator) {
        log.info(String.format("Check if element displayed using given locator %s",locator));
        return find(locator).isDisplayed();
    }


    /** Find all elements using given locator
     * @param locator - locator to find the elements
     * @return List.of(WebElement)
     * */
    public List<WebElement> findAll(By locator) {
        log.info(String.format("Find all elements using given locator %s",locator));
        return driver.findElements(locator);
    }

    /**
     * Click on element with given locator when its visible
     * @param locator - locator to find the element for clicking
     */
    public void click(By locator) {
        waitFor(ExpectedConditions.visibilityOfElementLocated(locator), Duration.ofSeconds(30));
        find(locator).click();
        log.info(String.format("Clicked on element using given locator %s",locator));
    }

    /** Type given text into element with given locator
     * @param locator - locator to find the element for typing
     * @param text - text for typing
     * */
    public void sendKeys(By locator, String text) {
        waitForVisibilityOf(locator, Duration.ofSeconds(5));
        find(locator).sendKeys(text);
        log.info(String.format("Text sent to element using given locator: %s",text, locator));
    }

    /** Delete text from element with given locator
     * @param locator - locator to find the element for typing
     * */
    public void clearField(By locator) {
        waitForVisibilityOf(locator, Duration.ofSeconds(5));
        find(locator).clear();
        log.info(String.format("Text deleted from element using given locator: %s", locator));
    }


    /** Get text from element with given locator
     * @param locator - locator to find the element
     * @return  String - text from element
     * */
    public String getTextFromElement(By locator) {
        waitForVisibilityOf(locator, Duration.ofSeconds(5));
        return find(locator).getText();
    }

    /** Refresh page
     * */
    public void refreshPage() {
        driver.navigate().refresh();
    }

    /** Method to scroll page to particular element
     * @param locator : locator to find the element
     */
    public void scrollUntilTheElementExist(By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));;
    }


    /** Method to hover with mouse over the element
     * @param locator : locator to find the element
     */
    public void hoverWithMouse(By locator){
        Actions actions = new Actions(driver);
        WebElement el = find(locator);
        actions.moveToElement(el).moveToElement(driver.findElement(locator)).click().build().perform();
        try {
            Thread.sleep(Duration.ofSeconds(1));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /** Method to hover with mouse over the element
     * @param el : WebElement for hover
     */
    public void hoverWithMouse_Element(WebElement el){
        Actions actions = new Actions(driver);
        actions.moveToElement(el).moveToElement(el).click().build().perform();
        try {
            Thread.sleep(Duration.ofSeconds(1));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    /** Method for switch the iframe
     * @param iframePath : locator to find the iframe
     */
    public void switchIFrame(By iframePath){
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframePath));
    }

    /** Method to get the url of the present page
     */
    public String getUrl(){
        return driver.getCurrentUrl();
    }


    /** Method to move back to the previous page in the browser
     */
    public void moveBack(){
        driver.navigate().back();
    }


    /**
     * Close driver
     */
    public void driverDown() {
        if (driver == null) {
            driver.quit();
            log.info(String.format("Driver closed"));
            try {
                Thread.sleep(Duration.ofSeconds(1));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Quit driver
     */
    @AfterGroups
    public void driverQuit() {
        driver.quit();
        log.info(String.format("Driver closed"));
        try {
            Thread.sleep(Duration.ofSeconds(1));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
