package factoryEnvironment;

import commons.GlobalConstants;
import factoryBrowser.BrowserList;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GridFactory {
    private WebDriver driver;
    private String browserName;
    private String ipAddress;
    private String portNumber;

    public GridFactory(String browserName, String ipAddress, String portNumber) {
        this.browserName = browserName;
        this.ipAddress = ipAddress;
        this.portNumber = portNumber;
    }

    public WebDriver createDriver() {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        DesiredCapabilities capabilitity = null;

        if (browserList == BrowserList.FIREFOX) {
          // capabilitity = DesiredCapabilities.firefox();
            capabilitity.setBrowserName("firefox");
            capabilitity.setPlatform(Platform.ANY);

            FirefoxOptions options = new FirefoxOptions();
            options.merge(capabilitity);

        } else if (browserList == BrowserList.CHROME) {
          //  capabilitity = DesiredCapabilities.();
            capabilitity.setBrowserName("chrome");
            capabilitity.setPlatform(Platform.ANY);

            ChromeOptions options = new ChromeOptions();
            options.merge(capabilitity);

        } else if (browserList == BrowserList.EDGE_CHROMIUM) {
            driver = new EdgeDriver();
        } else if (browserList == BrowserList.COCOC) {
            // Cốc Cốc browser trừ đi 5-6 version ra ChromeDriver

            ChromeOptions options = new ChromeOptions();
            if (GlobalConstants.OS_NAME.startsWith("Window")) {
                options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
            } else {
                options.setBinary("...");
            }
            driver = new ChromeDriver(options);

        } else if (browserList == BrowserList.BRAVE) {
            // Brave browser version nào dùng chromedriver version đó
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
            driver = new ChromeDriver(options);

        } else {
            throw new RuntimeException("Please enter correct browser name!");
        }
        try {
            driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, portNumber)), capabilitity);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}