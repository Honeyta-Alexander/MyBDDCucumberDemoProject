package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.time.Duration;

public class DriverFactory {
    private static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();

    public WebDriver init_driver(String browserName) {
        System.out.println("Launching browser: " + browserName);


        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                tldriver.set(new ChromeDriver());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                tldriver.set(new FirefoxDriver());
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                tldriver.set(new EdgeDriver());
                break;
            case "safari":
                // SafariOptions can be used if needed
                tldriver.set(new SafariDriver());
                getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browserName);
        }

        getDriver().manage().deleteAllCookies();
        return tldriver.get();
    }

    public static WebDriver getDriver() {
        return tldriver.get();
    }

    public void quitDriver() {
        if (tldriver.get() != null) {
            tldriver.get().quit();
            tldriver.remove();
        }
    }
}
