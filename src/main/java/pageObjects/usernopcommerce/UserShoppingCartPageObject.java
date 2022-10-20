package pageObjects.usernopcommerce;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.ShoppingCartPageUI;

public class UserShoppingCartPageObject extends BasePage {
    WebDriver driver;

    public UserShoppingCartPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public String isNumberOfProductDisplayedOnCart() {
        waitForElementVisible(driver, ShoppingCartPageUI.NUMBER_PRODUCT_OF_CART);
        return getElementText(driver, ShoppingCartPageUI.NUMBER_PRODUCT_OF_CART).replace("(", "").replace(")", "");
    }

    public String isNumberOfProductDisplayedWishlist() {
        waitForElementVisible(driver, ShoppingCartPageUI.NUMBER_OF_WISHLIST_LINK);
        return getElementText(driver, ShoppingCartPageUI.NUMBER_OF_WISHLIST_LINK).replace("(", "").replace(")", "");
    }


}
