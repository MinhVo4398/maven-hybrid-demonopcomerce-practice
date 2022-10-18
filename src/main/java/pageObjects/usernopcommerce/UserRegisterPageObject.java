package pageObjects.usernopcommerce;

import commons.BasePage;
import commons.PageGeneratorManager;

import pageUIs.RegisterPageUI;

import org.openqa.selenium.WebDriver;

public class UserRegisterPageObject extends BasePage {
    private WebDriver driver;

    //constructor
    public UserRegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void clickToRegisterButton() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);


    }

    public String getErrorMessageAtFirstnameTextbox() {
        waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
    }

    public String getErrorMessageAtLastnameTextbox() {
        waitForElementVisible(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
    }

    public String getErrorMessageAtEmailTextbox() {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
    }

    public String getErrorMessageAtPasswordTextbox() {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
    }

    public String getErrorMessageAtConfirmPasswordTextbox() {
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
    }


    public void inputToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void inputToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
    }


    public void inputToEmailTextbox(String emailAddres) {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddres);
    }


    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
    }


    public void inputToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
    }


    public String getRegisterSuccessMessage() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }


    public UserHomePageObject clickToLogoutLink() {
        waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
        clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
        //2 return new HomePageObject(driver);
        return PageGeneratorManager.getUserHomePage(driver);
    }

    public String getErrorExistingEmailMessage() {
        waitForElementClickable(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
    }


}
