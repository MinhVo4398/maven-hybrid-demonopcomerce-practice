package pageObjects.usernopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.CompareProductListPageUI;

public class UserCompareProductPageObject extends BasePage {
    WebDriver driver;

    public UserCompareProductPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDigitalStormProductDisplayed() {
        waitForElementVisible(driver, CompareProductListPageUI.DIGITAL_STORM_PRODUCT_NAME);
        return isElementDisplayed(driver, CompareProductListPageUI.DIGITAL_STORM_PRODUCT_NAME);
    }

    public String isDigitalStormProductPriceDisplayed() {
        waitForElementVisible(driver, CompareProductListPageUI.DIGITAL_STORM_PRODUCT_PRICE);
        return getElementText(driver, CompareProductListPageUI.DIGITAL_STORM_PRODUCT_PRICE);

    }

    public boolean isBuildYourProductDisplayed() {
        waitForElementVisible(driver, CompareProductListPageUI.BUILD_YOUR_PRODUCT_NAME);
        return isElementDisplayed(driver, CompareProductListPageUI.BUILD_YOUR_PRODUCT_NAME);
    }

    public String isBuildYourProductPriceDisplayed() {
        waitForElementVisible(driver, CompareProductListPageUI.BUILD_YOUR_PRODUCT_PRICE);
        return getElementText(driver, CompareProductListPageUI.BUILD_YOUR_PRODUCT_PRICE);
    }

    public void clickToClearListButton() {
        waitForElementClickable(driver, CompareProductListPageUI.CLEAR_LIST_BUTTON);
        clickToElement(driver, CompareProductListPageUI.CLEAR_LIST_BUTTON);

    }

    public String getNoItemsCompareProductMessgae() {
        waitForElementVisible(driver, CompareProductListPageUI.NO_ITEMS_COMPARE_MESSAGE);
        return getElementText(driver, CompareProductListPageUI.NO_ITEMS_COMPARE_MESSAGE);

    }
}
