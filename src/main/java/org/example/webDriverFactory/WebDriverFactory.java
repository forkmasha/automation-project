package org.example.webDriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Objects;

public class WebDriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return getDriver(getBrowserType());
    }

    public static WebDriver getDriver(BrowserType browser) {
        if (driver.get() == null) {
            WebDriver webDriver;
            switch (browser) {
                case CHROME:
                    webDriver = getChromeDriver();
                    break;
                case EDGE:
                    webDriver = getEdgeDriver();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + browser);
            }
            driver.set(Objects.requireNonNull(webDriver));
        }
        return driver.get();
    }

    private static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        return new HighlightingChromeDriver(options);
    }

    private static WebDriver getEdgeDriver() {
        System.setProperty("webdriver.edge.driver", "src/main/resources/drivers/msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        return new HighlightingEdgeDriver(options);
    }

    private static BrowserType getBrowserType() {
        String browser = System.getProperty("browser", "CHROME");
        BrowserType browserType = BrowserType.valueOf(browser.toUpperCase());
        return browserType;
    }

    public static void closeBrowser() {
        if (driver.get() != null) {
            getDriver().close();
            getDriver().quit();
            driver.remove();
        }
    }
}