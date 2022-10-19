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


    public void inputToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, CustomerInforPageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, CustomerInforPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void inputToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, CustomerInforPageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, CustomerInforPageUI.LAST_NAME_TEXTBOX, lastName);

    }

    public void selectDayDropdown(String dateValue) {
        selectItemInDefaultDropdown(driver, CustomerInforPageUI.DAY_DROPDOWN, dateValue);
    }

    public void selectMonthDropdown(String monthValue) {
        selectItemInDefaultDropdown(driver, CustomerInforPageUI.MONTH_DROPDOWN, monthValue);
    }

    public void selectYearDropdown(String yearValue) {
        selectItemInDefaultDropdown(driver, CustomerInforPageUI.YEAR_DROPDOWN, yearValue);
    }

    public void inputToEmailAddress(String emailAddress) {
        waitForElementVisible(driver, CustomerInforPageUI.EMAIL_ADDRESS);
        sendKeyToElement(driver, CustomerInforPageUI.EMAIL_ADDRESS, emailAddress);
    }

    public void inputToCompanyNameTextbox(String companyName) {
        waitForElementVisible(driver, CustomerInforPageUI.COMPANY_TEXTBOX);
        sendKeyToElement(driver, CustomerInforPageUI.COMPANY_TEXTBOX, companyName);
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, CustomerInforPageUI.SAVE_BUTTON);
        clickToElement(driver, CustomerInforPageUI.SAVE_BUTTON);
    }

    public void checkToFemaleGenderRadio() {
        waitForElementClickable(driver, CustomerInforPageUI.FEMALE_RADIO_BUTTON);
        checkToDefaultCheckboxRadio(driver, CustomerInforPageUI.FEMALE_RADIO_BUTTON);
    }

    public void isGenderRadioButtonUpdate() {

    }

    public String isFirstNameTextboxUpdate(String attributeName) {
        waitForElementVisible(driver, CustomerInforPageUI.FIRST_NAME_TEXTBOX);
        return getElementAttribute(driver, CustomerInforPageUI.FIRST_NAME_TEXTBOX, attributeName);
    }

    public String isLastNameTextboxUpdate(String attributeName) {
        waitForElementVisible(driver, CustomerInforPageUI.LAST_NAME_TEXTBOX);
        return getElementAttribute(driver, CustomerInforPageUI.LAST_NAME_TEXTBOX, attributeName);
    }

    public String isDayDropDownValueUpdate(String textItem) {
        waitForElementVisible(driver, CustomerInforPageUI.DAY_DROPDOWN);
        return getSelectedItemDefaultDropdown(driver, CustomerInforPageUI.DAY_DROPDOWN, textItem);

    }

    public String isMonthDropdownValueUpdate(String textItem) {
        waitForElementVisible(driver, CustomerInforPageUI.MONTH_DROPDOWN);
        return getSelectedItemDefaultDropdown(driver, CustomerInforPageUI.MONTH_DROPDOWN, textItem);
    }

    public String isYearDropdownValueUpdate(String textItem) {
        waitForElementVisible(driver, CustomerInforPageUI.YEAR_DROPDOWN);
        return getSelectedItemDefaultDropdown(driver, CustomerInforPageUI.YEAR_DROPDOWN, textItem);
    }

    public String isEmailAddressUpdate(String attributeValue) {
        waitForElementVisible(driver, CustomerInforPageUI.EMAIL_ADDRESS);
        return getElementAttribute(driver, CustomerInforPageUI.EMAIL_ADDRESS, attributeValue);
    }

    public String isCompanyNameTextboxUpdate(String attributeValue) {
        waitForElementVisible(driver, CustomerInforPageUI.COMPANY_TEXTBOX);
        return getElementAttribute(driver, CustomerInforPageUI.COMPANY_TEXTBOX, attributeValue);
    }

    public String isFemaleRadioButtonUpdate(String attributeValue) {
        waitForElementVisible(driver, CustomerInforPageUI.FEMALE_RADIO_BUTTON);
        return getElementAttribute(driver, CustomerInforPageUI.FEMALE_RADIO_BUTTON, attributeValue);
    }
}