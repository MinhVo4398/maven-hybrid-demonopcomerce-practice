package pageObjects.usernopcommerce;

import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.BasePage;
import pageUIs.AddressPageUI;

public class UserAddressPageObject extends BasePage {
    WebDriver driver;
    WebDriverWait explicitWait;
    boolean isPageReady;


    public UserAddressPageObject(WebDriver driver) {
        this.driver = driver;

    }

    public UserAddressPageObject(WebDriver driver, boolean isPageReady) {
        this.driver = driver;
        this.isPageReady = isPageReady;

    }


    public UserAddressPageObject(WebDriver driver, WebDriverWait explicitWait) {
        this.driver = driver;
        this.explicitWait = explicitWait;
    }


    public void clickToAddNewButton() {
        waitForElementClickable(driver, AddressPageUI.ADD_NEW_BUTTON);
        clickToElement(driver, AddressPageUI.ADD_NEW_BUTTON);
    }

    public void inputToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, AddressPageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, AddressPageUI.FIRST_NAME_TEXTBOX, firstName);

    }

    public void inputToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, AddressPageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, AddressPageUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void inputToEmailTextbox(String email) {
        waitForElementVisible(driver, AddressPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, AddressPageUI.EMAIL_TEXTBOX, email);
    }

    public void inputToCompanyTextbox(String companyName) {
        waitForElementVisible(driver, AddressPageUI.COMPANY_TEXTBOX);
        sendKeyToElement(driver, AddressPageUI.COMPANY_TEXTBOX, companyName);
    }

    public void selectCountryDropdown(String textItem) {
        selectItemInDefaultDropdown(driver, AddressPageUI.COUNTRY_DROPDOWN, textItem);
    }

    public void selectStateDropdown(String textItem) {
        selectItemInDefaultDropdown(driver, AddressPageUI.STATE_DROPDOWN, textItem);
    }

    public void inputToCityTextbox(String cityName) {
        waitForElementVisible(driver, AddressPageUI.CITY_TEXTBOX);
        sendKeyToElement(driver, AddressPageUI.CITY_TEXTBOX, cityName);
    }

    public void inputToAddress1Textbox(String address1) {
        waitForElementVisible(driver, AddressPageUI.ADDRESS1_TEXTBOX);
        sendKeyToElement(driver, AddressPageUI.ADDRESS1_TEXTBOX, address1);
    }

    public void inputToAddress2Textbox(String address2) {
        waitForElementVisible(driver, AddressPageUI.ADDRESS2_TEXTBOX);
        sendKeyToElement(driver, AddressPageUI.ADDRESS2_TEXTBOX, address2);
    }

    public void inputToZipTextbox(String zip) {
        waitForElementVisible(driver, AddressPageUI.ZIP_TEXTBOX);
        sendKeyToElement(driver, AddressPageUI.ZIP_TEXTBOX, zip);
    }

    public void inputToPhoneNumber(String phoneNumber) {
        waitForElementVisible(driver, AddressPageUI.PHONE_NUMBER_TEXTBOX);
        sendKeyToElement(driver, AddressPageUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
    }

    public void inputToFaxNumber(String faxNumber) {
        waitForElementVisible(driver, AddressPageUI.FAX_NUMBER);
        sendKeyToElement(driver, AddressPageUI.FAX_NUMBER, faxNumber);
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, AddressPageUI.SAVE_BUTTON);
        clickToElement(driver, AddressPageUI.SAVE_BUTTON);
    }

    public String isNameDisplayed() {
        waitForElementVisible(driver, AddressPageUI.ADDRESS_NAME);
        return getElementText(driver, AddressPageUI.ADDRESS_NAME);
    }

    public String isEmailDisplayed() {
        waitForElementVisible(driver, AddressPageUI.ADDRESS_EMAIL);
        return getElementText(driver, AddressPageUI.ADDRESS_EMAIL);
    }

    public String isPhoneNumberDisplayed() {
        waitForElementVisible(driver, AddressPageUI.ADDRESS_PHONE_NUMBER);

        return getElementText(driver, AddressPageUI.ADDRESS_PHONE_NUMBER);
    }

    public String isFaxNumberDisplayed() {
        waitForElementVisible(driver, AddressPageUI.ADDRESS_FAX);
        return getElementText(driver, AddressPageUI.ADDRESS_FAX);
    }

    public String isCompanyDisplayed() {
        waitForElementVisible(driver, AddressPageUI.ADDRESS_COMPANY);
        return getElementText(driver, AddressPageUI.ADDRESS_COMPANY);
    }

    public String isStreet1Displayed() {
        waitForElementVisible(driver, AddressPageUI.ADDRESS1);
        return getElementText(driver, AddressPageUI.ADDRESS1);
    }

    public String isStreet2Displayed() {
        waitForElementVisible(driver, AddressPageUI.ADDRESS2);
        return getElementText(driver, AddressPageUI.ADDRESS2);
    }

    public String isZipCodeDisplayed() {
        waitForElementVisible(driver, AddressPageUI.ADRESS_ZIP);
        return getElementText(driver, AddressPageUI.ADRESS_ZIP);
    }

    public String isCountryDisplayed() {
        waitForElementVisible(driver, AddressPageUI.ADDRESS_COUNTRY);
        return getElementText(driver, AddressPageUI.ADDRESS_COUNTRY);
    }

    public UserHomePageObject clickLogOutLink() {
        waitForElementClickable(driver, AddressPageUI.LOGOUT_LINK);
        clickToElement(driver, AddressPageUI.LOGOUT_LINK);
        return PageGeneratorManager.getUserHomePage(driver);


    }

    public UserHomePageObject clickToComputerProductLinkAndDeskTopLink() {
        // hover
        waitForElementClickable(driver, AddressPageUI.COMPUTER_LINK);
        hoverMouseToElement(driver, AddressPageUI.COMPUTER_LINK);
        //click
        waitForElementVisible(driver, AddressPageUI.DESKTOP_LINK);
        clickToElement(driver, AddressPageUI.DESKTOP_LINK);
        return PageGeneratorManager.getUserHomePage(driver);

    }

}