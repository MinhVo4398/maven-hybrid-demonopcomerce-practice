package pageObjects.usernopcommerce;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class UserHomePageObject extends BasePage {
    // Biến global;
    private WebDriver driver;

    //constructor
    public UserHomePageObject(WebDriver driver) {
        //  Biến local
        this.driver = driver;
    }


    public UserRegisterPageObject openRegisterPage() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);


        return PageGeneratorManager.getUserRegisterPage(driver);

    }


    public UserLoginPageObject openLoginPage() {
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
        //2    return  new LoginPageObject(driver);
        return PageGeneratorManager.getUserLoginPage(driver);

    }


    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
    }


    public UserCustomerInforPageObject openMyAccountPage() {
        waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
        return PageGeneratorManager.getUserCustomerInforPage(driver);

    }
}

