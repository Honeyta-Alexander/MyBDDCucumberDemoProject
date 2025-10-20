package hooks;

import Utilities.ConfigReader;
import Utilities.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Apphooks {

    private DriverFactory driverFactory;
    private WebDriver driver;

    @Before
    public void launchBrowser() {
        driverFactory = new DriverFactory();
        String browserName = ConfigReader.getProperty("browser");
        driver = driverFactory.init_driver(browserName);
    }

    @After(order = 0)
    public void quitBrowser() {
        driverFactory.quitDriver();
    }

    @After(order = 1)
    public void takeScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replace(" ", "_");
            byte[] source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(source, "image/png", screenshotName);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
