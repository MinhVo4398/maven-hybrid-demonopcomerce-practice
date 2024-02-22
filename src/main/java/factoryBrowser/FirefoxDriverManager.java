package factoryBrowser;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FirefoxDriverManager implements BrowserFactory {
    @Override
    public WebDriver getBrowserDriver() {
        return new FirefoxDriver();

    }
}