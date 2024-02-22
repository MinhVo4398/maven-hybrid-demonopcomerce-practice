package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChromeDriverManager implements BrowserFactory {
    @Override
    public WebDriver getBrowserDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=chrome");
        options.addArguments("window-size=1920x1080");
        return new ChromeDriver(options);
    }
}