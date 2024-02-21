package Infrastructure;

import Infrastructure.Utils.ConfigurationsReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.util.Arrays;
import java.util.logging.Level;

public class DriverCreation {
    private static final ConfigurationsReader configuration = new ConfigurationsReader();
    static final Logger log = LogManager.getLogger(DriverCreation.class);
    private static final LoggingPreferences loggingPreferences = new LoggingPreferences();
    public static WebDriver driver;

    public static WebDriver createDriver() {
        String browser = String.valueOf(configuration.getBrowser());
        Arrays.asList(LogType.PERFORMANCE, LogType.BROWSER, LogType.DRIVER).forEach(s -> loggingPreferences.enable(s, Level.ALL));
        log.info("Create local driver: " + browser);
        switch (browser) {
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                driver.manage().window().maximize();
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = new EdgeDriver(edgeOptions);
                driver.manage().window().maximize();
                break;

            default:
                LoggingPreferences logPref= new LoggingPreferences();
                logPref.enable(LogType.BROWSER, Level.ALL);
                ChromeOptions optionsCH = new ChromeOptions();
                optionsCH.addArguments("--incognito");
                optionsCH.addArguments("--start-maximized");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(optionsCH);
                driver.manage().window().maximize();
                break;
        }
        java.util.logging.Logger.getLogger("org.openqa.selenium");
        return driver;
    }

}
