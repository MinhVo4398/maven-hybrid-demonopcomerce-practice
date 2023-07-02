package com.usernopcommerce.login;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.usernopcommerce.UserHomePageObject;
import pageObjects.usernopcommerce.UserLoginPageObject;
import pageObjects.usernopcommerce.UserRegisterPageObject;
import reportConfig.ExtentTestManager;
import utilities.DataHelper;

import java.lang.reflect.Method;

public class LoginFunction extends BaseTest {
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
        Assert.assertEquals(loginPage.getErrorMessageAtEmailTextBox(), "Please enter your email!");
        //verifyEquals(loginPage.getErrorMessageAtEmailTextBox(), "Please enter your emai!ll");

    }

    @Test
    public void TC_02_Login_Invalid_Email() {
        System.out.println("HomePage : Step 01 Click login Page");
        // Initialize Login Page
        loginPage = homePage.openLoginPage();

        System.out.println("Login Page: Step 02 Input Invalid Email and Corect Password");
        loginPage.inputToEmailTextbox(invalidEmail);

        System.out.println("Login Page Step 03: Click Login button");
        loginPage.clickToLoginButton();

        System.out.println("Login Page: Step 04 Verify wronng email");
        Assert.assertEquals(loginPage.getErrorMessageAtEmailTextBox(), "Wrong email!");
    }

    @Test
    public void TC_03_Login_Email_Not_Found() {
        System.out.println("HomePage : Step 01 Click login Page");
        // Initialize Login Page
        loginPage = homePage.openLoginPage();

        System.out.println("Login Page: Step 02 Input Invalid Email ");
        loginPage.inputToEmailTextbox(notFoundEmail);

        System.out.println("Login Page Step 03: Click Login button");
        loginPage.clickToLoginButton();

        System.out.println("Login Page Step 04:  Verify");
        Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
    }

    @Test
    public void TC_04_Login_Existing_Email_Empty_Pasword() {
        System.out.println("HomePage : Step 01 Click login Page");
        // Initialize Login Page
        loginPage = homePage.openLoginPage();
        System.out.println("Login Page: Step 02 Input Existing Email and No input Password");
        loginPage.inputToEmailTextbox(emailAddress);
        loginPage.inputToPasswordTextbox("");

        System.out.println("Login Page Step 03: Click Login button");
        loginPage.clickToLoginButton();

        System.out.println("Login Page Step 04:  Verify");
        Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

    }

    @Test
    public void TC_05_Login_Existing_Email_Incorrect_Password() {
        System.out.println("HomePage : Step 01 Click login Page");
        loginPage = homePage.openLoginPage();

        System.out.println("Login Page: Step 02 Input Existing Email and No input Password");
        loginPage.inputToEmailTextbox(emailAddress);
        loginPage.inputToPasswordTextbox(invalidPassword);

        System.out.println("Login Page Step 03: Click Login button");
        loginPage.clickToLoginButton();

        System.out.println("Login Page Step 04:  Verify");
        Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

    }

    @Test
    public void TC_06_Login_Valid_Email_Password() {
        System.out.println("HomePage : Step 01 Click login Page");
        loginPage = homePage.openLoginPage();
        System.out.println("Login Page: Step 02 Input Existing Email and No input Password");
        loginPage.inputToEmailTextbox(emailAddress);
        loginPage.inputToPasswordTextbox(validPassword);
        System.out.println("Login Page Step 03: Click Login button");
        homePage = loginPage.clickToLoginButton();

        System.out.println("HomePahe - Step 04: Verify My account link  hiển thị");
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}
