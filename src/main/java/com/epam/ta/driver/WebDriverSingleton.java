package com.epam.ta.driver;

import com.epam.ta.config.Config;
import com.epam.ta.utils.Browser;
import com.epam.ta.utils.BrowserManager;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSingleton {

    private static WebDriver driver;
    private static final Logger logger = LogManager.getRootLogger();

    private static Browser browser = Config.getBrowser();

    private WebDriverSingleton() {

    }

    public static synchronized WebDriver getDriver() {
        if (driver == null) {
            switch (browser) {
                case CHROME:
                    ChromeDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(BrowserManager.getChromeOptions());
                    break;
                case FIREFOX:
                    FirefoxDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(BrowserManager.getFirefoxOptions());
                    break;
                default:
                    throw new NullPointerException("[No such browser. Please, use Chrome or Firefox.]");
            }
        }
        logger.info("Browser started");
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }

}
