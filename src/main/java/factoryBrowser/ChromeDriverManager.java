package factoryBrowser;

import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;
import java.util.HashMap;

public class ChromeDriverManager implements BrowserFactory {

    @Override
    public WebDriver getBrowserDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-geolocation");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        // this code to fix issue crash on github action
        if("TRUE".equalsIgnoreCase(System.getenv("CHROME_HEADLESS"))) {
            options.addArguments("headless");
        }

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", GlobalConstants.DOWNLOAD_FILE_PATH);
        options.setExperimentalOption("prefs", chromePrefs);

        System.setProperty("webdriver.chrome.args", "--disabled-logging");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        return new ChromeDriver(options);
    }
}