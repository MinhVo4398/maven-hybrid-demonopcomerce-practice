package com.usernopcommerce.register;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.usernopcommerce.UserHomePageObject;
import pageObjects.usernopcommerce.UserRegisterPageObject;
import reportConfig.ExtentTestManager;
import utilities.DataHelper;

import java.lang.reflect.Method;

public class Register extends BaseTest {

    private WebDriver driver;
    private String firstName, lastName, validPassword, emailAddress, invalidEmail, invalidPassword;
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
        invalidEmail = "121222";
        invalidPassword = "123";
    }

    @Test
    public void TC_01_Register_With_Empty_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register to system with valid Email and Password");
        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to 'Register' page ");
        registerPage = homePage.openRegisterPage();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Click to Register button ");
        registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Verify inline error message ");
        Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");


    }

    @Test
    public void TC_02_Register_With_Invalid_Email(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register to system with valid Email and Password");
        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to 'Register' page ");
        registerPage = homePage.openRegisterPage();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Input invalid email with value invalidEmail ");
        registerPage.inputToEmailTextbox(invalidEmail);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Click to Register button ");
        registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Verify Wrong email error message is displayed ");
        Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
    }

    @Test
    public void TC_03_Register_With_Password_Less_Than_6_Characters(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register to system with Password less than 6 characters");
        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to 'Register' page ");
        registerPage = homePage.openRegisterPage();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Input invalid password with value  invalidPassword");
        registerPage.inputToPasswordTextbox(invalidPassword);


        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Click to Register button ");
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");
    }

    @Test
    public void TC_04_Register_With() {

    }

    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver("local");

    }

}
