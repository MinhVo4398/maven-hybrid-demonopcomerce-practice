package pageObjects.usernopcommerce;

import commons.BasePage;
import commons.PageGeneratorManager;

import pageUIs.LoginPageUI;


import org.openqa.selenium.WebDriver;

public class UserLoginPageObject extends BasePage {
    private WebDriver driver;

    public UserLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public UserHomePageObject clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getUserHomePage(driver);
    }


    public void inputToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
    }


    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public String getErrorMessageAtEmailTextBox() {
        waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
        return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);

    }

    public String getErrorMessageUnsuccessfull() {
        waitForElementVisible(driver, LoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
        return getElementText(driver, LoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
    }


    public UserHomePageObject loginAsUser(String emailAddress, String password) {

        inputToEmailTextbox(emailAddress);
        inputToPasswordTextbox(password);
        return clickToLoginButton();
    }


    public String getPracticeNameTextboxValue() {
        waitForElementVisible(driver, LoginPageUI.STREET_ADDRESS_TEXTBOX);
        return getElementValueByJSXpath(driver, LoginPageUI.STREET_ADDRESS_TEXTBOX);
    }
}