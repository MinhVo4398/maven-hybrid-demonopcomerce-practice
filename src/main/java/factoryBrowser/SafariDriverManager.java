package factoryBrowser;

import exception.BrowserNotSupportedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC;

public class SafariDriverManager implements BrowserFactory {

    @Override
    public WebDriver getBrowserDriver() {
        // Safari chi chay tren MAC
        if (!IS_OS_MAC) {
            throw new BrowserNotSupportedException("Edge is not supported on" + System.getProperty("os.name"));

        }
        SafariOptions options = new SafariOptions();
        options.setCapability("safari.cleanSession", true);
        return new SafariDriver(options);
    }
}