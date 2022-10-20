package pageObjects.usernopcommerce;

import commons.BasePage;

import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.WhishlistPageUI;

public class UserWhishlistPageObject extends BasePage {
    WebDriver driver;

    public UserWhishlistPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductNameDisplayed() {
        waitForElementVisible(driver, WhishlistPageUI.PRODUCT_NAME);
        return isElementDisplayed(driver, WhishlistPageUI.PRODUCT_NAME);
    }

    public void checkToAddtoCartCheckbox() {
        waitForElementVisible(driver, WhishlistPageUI.ADD_TO_CART_CHECKBOX);
        checkToDefaultCheckboxRadio(driver, WhishlistPageUI.ADD_TO_CART_CHECKBOX);

    }

    public UserShoppingCartPageObject clickAddToCartButton() {
        waitForElementClickable(driver, WhishlistPageUI.ADD_TO_CART_BUTTON);
        clickToElement(driver, WhishlistPageUI.ADD_TO_CART_BUTTON);
        return PageGeneratorManager.getUserShoppingCart(driver);
    }

    public void checkToRemoveButton() {
        waitForElementVisible(driver, WhishlistPageUI.REMOVE_BUTTON);
        checkToDefaultCheckboxRadio(driver, WhishlistPageUI.REMOVE_BUTTON);
    }

    public String getMessageAtWishlisgPage() {
        waitForElementVisible(driver, WhishlistPageUI.EMPTY_MESSAGE);
        return getElementText(driver, WhishlistPageUI.EMPTY_MESSAGE);
    }
}
