package com.usernopcommerce.register;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.usernopcommerce.*;
import reportConfig.ExtentTestManager;
import utilities.DataHelper;

import java.lang.reflect.Method;

public class RegisterFunction extends BaseTest {

    private WebDriver driver;
    private String firstName, lastName, validPassword, emailAddress;
    public DataHelper dataHelper;

    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;


    @Parameters({"envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
    @BeforeClass
    public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber, @Optional("Windows") String osName, @Optional("10") String osVersion) {

        driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
        dataHelper = DataHelper.getDataHelper();

        homePage = PageGeneratorManager.getUserHomePage(driver);

        firstName = dataHelper.getFirstName();
        lastName = dataHelper.getLastName();
        emailAddress = dataHelper.getEmailAddress();
        validPassword = dataHelper.getPassword();
    }

    @Test
    public void User_01_Register(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register to system with valid Email and Password");
        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to 'Register' page ");
        registerPage = homePage.openRegisterPage();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Input to Firstname textbox" + firstName);
        registerPage.inputToFirstNameTextbox(firstName);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Enter to Lastname textbox with value is " + lastName);
        registerPage.inputToLastNameTextbox(lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter to Email textbox with value is " + emailAddress);
        registerPage.inputToEmailTextbox(emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter to Password textbox with value is " + validPassword);
        registerPage.inputToPasswordTextbox(validPassword);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Enter to Confirm Password textbox with value is " + validPassword);
        registerPage.inputToConfirmPasswordTextbox(validPassword);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to 'Register' button");
        registerPage.clickToRegisterButton();


        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08: Verify register success message is displayed ");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");


    }

    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver("local");

    }

}
