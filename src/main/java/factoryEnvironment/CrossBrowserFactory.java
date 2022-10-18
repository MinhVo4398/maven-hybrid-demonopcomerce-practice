package factoryEnvironment;

import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class CrossBrowserFactory {
    private WebDriver driver;
    private String browserName;
    private String osName;

    public CrossBrowserFactory(String browserName, String osName) {
        this.browserName = browserName;
        this.osName = osName;
    }

    public WebDriver createDriver() {
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("browserName", browserName);
        capability.setCapability("platform", osName);
        if (osName.contains("Windows")) {
            capability.setCapability("screenResolution", "1920x1080");
        } else {
            capability.setCapability("screenResolution", "2560x1600");

        }

        capability.setCapability("name", "Run on " + osName + " | " + browserName);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.CORSS_URRL), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}