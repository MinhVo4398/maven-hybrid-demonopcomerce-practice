package pageObjects.usernopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.BasePage;

public class UserAddressPageObject extends BasePage {
    WebDriver driver;
    WebDriverWait explicitWait;
    boolean isPageReady;


    public UserAddressPageObject(WebDriver driver) {
        this.driver = driver;

    }

    public UserAddressPageObject(WebDriver driver, boolean isPageReady) {
        this.driver = driver;
        this.isPageReady = isPageReady;

    }


    public UserAddressPageObject(WebDriver driver, WebDriverWait explicitWait) {
        this.driver = driver;
        this.explicitWait = explicitWait;
    }


}