package com.usernopcommerce.login;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.usernopcommerce.UserHomePageObject;
import pageObjects.usernopcommerce.UserLoginPageObject;
import pageObjects.usernopcommerce.UserRegisterPageObject;
import utilities.DataHelper;

public class LoginTest extends BaseTest {
    WebDriver driver;
    private String invalidEmail;
    DataHelper dataHelper;
    UserHomePageObject homePage;
    UserLoginPageObject loginPage;
    UserRegisterPageObject registerPage;
    String firstName, lastName, existingEmail, validPassword, emailAddress, notFoundEmail, invalidPassword;

    @Parameters({"envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
    @BeforeClass
    public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber, @Optional("Windows") String osName, @Optional("10") String osVersion) {

        driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
        System.out.println("Driver at Login: " + driver.toString());
        dataHelper = DataHelper.getDataHelper();
        firstName = dataHelper.getFirstName();
        lastName = dataHelper.getLastName();
        emailAddress = dataHelper.getEmailAddress();
        validPassword = dataHelper.getPassword();
        invalidPassword = "654321";
        notFoundEmail = "afc" + generateFakeNumber() + "@mail.com";
        invalidEmail = "afc@afc.com@.vn";

        homePage = PageGeneratorManager.getUserHomePage(driver);

        registerPage = homePage.openRegisterPage();
        registerPage.inputToFirstNameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAddress);
        registerPage.inputToPasswordTextbox(validPassword);
        registerPage.inputToConfirmPasswordTextbox(validPassword);
        registerPage.clickToRegisterButton();

        // homePage = registerPage.clickToLogoutLink();
        homePage = registerPage.clickContinueButton();
    }

    @Test
    public void TC_01_Login_With_Emtpy_Data() {
        System.out.println("HomePage : Step 01 Click login Page");
        loginPage = homePage.openLoginPage();

        System.out.println("LoginPage: Step 02 Click login button");
        loginPage.clickToLoginButton();

        System.out.println("LoginPage: Step 03 Verify Please enter your email");
        verifyEquals(loginPage.getErrorMessageAtEmailTextBox(), "Please enter your email");

    }

    @Test
    public void TC_02_Login_Invalid_Email() {
        loginPage = homePage.openLoginPage();
        loginPage.inputToEmailTextbox(invalidEmail);
        loginPage.clickToLoginButton();
        verifyEquals(loginPage.getErrorMessageAtEmailTextBox(), "Wrong email");
    }

    @Test
    public void TC_03_Login_Email_Not_Found() {
        loginPage = homePage.openLoginPage();
        loginPage.inputToEmailTextbox(notFoundEmail);
        loginPage.clickToLoginButton();
        verifyEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
    }

    @Test
    public void TC_04_Login_Existing_Email_Empty_Pasword() {
        loginPage = homePage.openLoginPage();
        loginPage.inputToEmailTextbox(emailAddress);
        loginPage.inputToPasswordTextbox("");
        loginPage.clickToLoginButton();
        verifyEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

    @Test
    public void TC_05_Login_Existing_Email_Incorrect_Password() {
        loginPage = homePage.openLoginPage();
        loginPage.inputToEmailTextbox(emailAddress);
        loginPage.inputToPasswordTextbox(invalidPassword);
        loginPage.clickToLoginButton();
        verifyEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

    @Test
    public void TC_06_Login_Valid_Email_Password() {
        loginPage = homePage.openLoginPage();
        loginPage.inputToEmailTextbox(emailAddress);
        loginPage.inputToPasswordTextbox(validPassword);
        homePage = loginPage.clickToLoginButton();
        verifyTrue(homePage.isMyAccountLinkDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
