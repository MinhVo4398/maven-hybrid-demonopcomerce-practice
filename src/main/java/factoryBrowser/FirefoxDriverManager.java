package factoryBrowser;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager implements BrowserFactory {
    @Override
    public WebDriver getBrowserDriver() {
        WebDriverManager.firefoxdriver().setup();
        /* FirefoxOptions options = new FirefoxOptions();*/
        /*System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, GlobalConstants.BROWSER_LOG_PATH + "FirefoxLog.log");*/

     /*   options.addPreference("browser.download.folderList",2);
        options.addPreference("browser.download.dir", GlobalConstants.DOWNLOAD_FILE_PATH);
        options.addPreference("browser.download.useDownloadDir", true);
        options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
        options.addPreference("pdfjs.disabled", true);*/

        // private (an danh)
        // options.addArguments("-private");
        /*  return new FirefoxDriver(options);*/
        return new FirefoxDriver();

    }
}