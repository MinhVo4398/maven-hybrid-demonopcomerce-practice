package factoryBrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


public class EdgeDriverManager implements BrowserFactory {

    @Override
    public WebDriver getBrowserDriver() {

        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        // Gọi options vì sau này cần setting gì
        return new EdgeDriver(options);

    }
}
