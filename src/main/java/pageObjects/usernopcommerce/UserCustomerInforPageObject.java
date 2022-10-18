package pageObjects.usernopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.CustomerInforPageUI;


public class UserCustomerInforPageObject extends BasePage {
    // Biến global;
    private WebDriver driver;

    //constructor
    public UserCustomerInforPageObject(WebDriver driver) {
        //  Biến local
        this.driver = driver;
    }


    public boolean isCustomerInforPageDisplayed() {

        waitForElementVisible(driver, CustomerInforPageUI.CUSTOMER_INFO_HEADER);
        return isElementDisplayed(driver, CustomerInforPageUI.CUSTOMER_INFO_HEADER);


    }


}