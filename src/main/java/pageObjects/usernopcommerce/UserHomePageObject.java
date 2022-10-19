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
        return PageGeneratorManager.getUserLoginPage(driver);

    }


    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
    }


    public UserCustomerInforPageObject openMyAccountPage() {
        waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
        return PageGeneratorManager.getUserCustomerInforPage(driver);

    }


    public void clickToComputerProduct() {
        waitForElementClickable(driver, HomePageUI.OWN_COMPUTER_PRODUCT_LINK);
        clickToElement(driver, HomePageUI.OWN_COMPUTER_PRODUCT_LINK);
    }

    public void clickToAddYourReviewLink() {
        waitForElementClickable(driver, HomePageUI.ADD_YOUR_REVIEW_LINK);
        clickToElement(driver, HomePageUI.ADD_YOUR_REVIEW_LINK);
    }

    public void inputToReviewTitle(String textValue) {
        waitForElementVisible(driver, HomePageUI.REVIEW_TITLE);
        sendKeyToElement(driver, HomePageUI.REVIEW_TITLE, textValue);
    }

    public void inputToReviewText(String textValue) {
        waitForElementVisible(driver, HomePageUI.REVIEW_TEXT);
        sendKeyToElement(driver, HomePageUI.REVIEW_TEXT, textValue);
    }

    public void clickToSubmitReviewButton() {
        waitForElementClickable(driver, HomePageUI.SUBMIT_REVIEW_BUTTON);
        clickToElement(driver, HomePageUI.SUBMIT_REVIEW_BUTTON);
    }

    public UserSearchPageObject clickToSearchLink() {
        waitForElementClickable(driver, HomePageUI.SEARCH_LINK);
        clickToElement(driver, HomePageUI.SEARCH_LINK);
        return PageGeneratorManager.getUserSearchPage(driver);
    }
}

