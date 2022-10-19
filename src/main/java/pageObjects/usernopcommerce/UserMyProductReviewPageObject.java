package pageObjects.usernopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.MyProductReviewPageUI;


public class UserMyProductReviewPageObject extends BasePage {
    WebDriver driver;

    public UserMyProductReviewPageObject(WebDriver driver) {
        this.driver = driver;

    }


    public String isReviewTitleDisplayed() {
        waitForElementVisible(driver, MyProductReviewPageUI.REVIEW_TITLE);
        return getElementText(driver, MyProductReviewPageUI.REVIEW_TITLE);
    }

    public String isReviewTextDisplayed() {
        waitForElementVisible(driver, MyProductReviewPageUI.REVIEW_TEXT);
        return getElementText(driver, MyProductReviewPageUI.REVIEW_TEXT);
    }
}