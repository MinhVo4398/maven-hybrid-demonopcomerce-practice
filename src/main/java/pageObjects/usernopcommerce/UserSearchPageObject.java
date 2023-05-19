package pageObjects.usernopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.SearchPageUI;

public class UserSearchPageObject extends BasePage {
    private WebDriver driver;

    public UserSearchPageObject(WebDriver driver) {
        // Gán =
        this.driver = driver;
        System.out.println(this.driver.toString());
    }


    public void clickToSearchButton() {
        waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
        clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
    }

    public String isErrorMessageDisplayed() {
        waitForElementVisible(driver, SearchPageUI.ERROR_MESSAGE);
        return getElementText(driver, SearchPageUI.ERROR_MESSAGE);
    }


    public void inputToSerachTextbox(String textValue) {
        waitForElementVisible(driver, SearchPageUI.SEARCH_TEXTBOX);
        sendKeyToElement(driver, SearchPageUI.SEARCH_TEXTBOX, textValue);
    }

    public String getNoResultMessageDisplayed() {
        waitForElementVisible(driver, SearchPageUI.NO_RESULT_MESSAGE);
        return getElementText(driver, SearchPageUI.NO_RESULT_MESSAGE);

    }


    public boolean isProductDisplayed() {
        waitForElementVisible(driver, SearchPageUI.LENOVO_PRODUCT);
        return isElementDisplayed(driver, SearchPageUI.LENOVO_PRODUCT);

    }

    public void checkToAdvanceSearch() {
        waitForElementVisible(driver, SearchPageUI.ADVANCE_SEARCH_CHECKBOX);
        checkToDefaultCheckboxRadio(driver, SearchPageUI.ADVANCE_SEARCH_CHECKBOX);
    }

    public void selectCategory(String textItem) {
        waitForElementVisible(driver, SearchPageUI.CATEGORY_DROPDOWN);
        selectItemInDefaultDropdown(driver, SearchPageUI.CATEGORY_DROPDOWN, textItem);

    }

    public void checkToSubCategory() {
        waitForElementVisible(driver, SearchPageUI.SEARCH_SUB_CATEGORIES_CHECKBOX);
        checkToDefaultCheckboxRadio(driver, SearchPageUI.SEARCH_SUB_CATEGORIES_CHECKBOX);
    }

    public boolean isMacbookProductDisplayed() {
        waitForElementVisible(driver, SearchPageUI.APPLE_PRODUCT);
        return isElementDisplayed(driver, SearchPageUI.APPLE_PRODUCT);
    }

    public void selectManufacturer(String textItem) {
        waitForElementVisible(driver, SearchPageUI.MANUFACTURER_DROPDOWN);
        selectItemInDefaultDropdown(driver, SearchPageUI.MANUFACTURER_DROPDOWN, textItem);
    }
}