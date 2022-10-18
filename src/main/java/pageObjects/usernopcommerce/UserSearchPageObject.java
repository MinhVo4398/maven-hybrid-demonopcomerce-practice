package pageObjects.usernopcommerce;

import org.openqa.selenium.WebDriver;

public class UserSearchPageObject {
    private WebDriver driver;

    public UserSearchPageObject(WebDriver driver) {
        // Gán =
        this.driver = driver;
        System.out.println(this.driver.toString());
    }

}