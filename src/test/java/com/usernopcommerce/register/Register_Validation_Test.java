package com.usernopcommerce.register;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.usernopcommerce.UserHomePageObject;
import pageObjects.usernopcommerce.UserRegisterPageObject;
import utilities.DataHelper;

import java.lang.reflect.Method;

public class Register_Validation_Test extends BaseTest {

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
        registerPage = homePage.openRegisterPage();

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");

    }

    @Test
    public void TC_02_Register_With_Invalid_Email(Method method) {

        registerPage = homePage.openRegisterPage();


        registerPage.inputToEmailTextbox(invalidEmail);


        registerPage.clickToRegisterButton();


        Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
    }

    @Test
    public void TC_03_Register_With_Password_Less_Than_6_Characters(Method method) {

        registerPage = homePage.openRegisterPage();


        registerPage.inputToPasswordTextbox(invalidPassword);


        registerPage.clickToRegisterButton();


        Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");
    }

    @Test
    public void TC_04_Register_ConfirmPassword_Not_Match_Password(Method method) {

        registerPage = homePage.openRegisterPage();


        registerPage.checkToMaleGenderRadiobutton();


        registerPage.selectDayDropdown("10");
        registerPage.selectMonthDropdown("May");
        registerPage.selectYearDropdown("1970");


        registerPage.inputToEmailTextbox(emailAddress);


        registerPage.inputToPasswordTextbox(validPassword);


        registerPage.inputToConfirmPasswordTextbox(invalidPassword);

        sleepInSecond(2);


        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");


    }

    @Test
    public void TC_05_Register_Success_With_Valid_Infor(Method method) {

        registerPage = homePage.openRegisterPage();


        registerPage.checkToMaleGenderRadiobutton();


        registerPage.inputToFirstNameTextbox(firstName);


        registerPage.inputToLastNameTextbox(lastName);


        registerPage.selectDayDropdown("10");
        registerPage.selectMonthDropdown("May");
        registerPage.selectYearDropdown("1970");


        registerPage.inputToEmailTextbox(emailAddress);


        registerPage.inputToPasswordTextbox(validPassword);


        registerPage.inputToConfirmPasswordTextbox(validPassword);
        sleepInSecond(2);


        registerPage.clickToRegisterButton();


        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
    }

    @Test
    public void TC_06_Register_Success_With_Existing_Email(Method method) {

        registerPage.clickToLogoutLink();
        registerPage = homePage.openRegisterPage();


        registerPage.checkToMaleGenderRadiobutton();


        registerPage.inputToFirstNameTextbox(firstName);


        registerPage.inputToLastNameTextbox(lastName);


        registerPage.selectDayDropdown("10");
        registerPage.selectMonthDropdown("May");
        registerPage.selectYearDropdown("1970");


        registerPage.inputToEmailTextbox(emailAddress);


        registerPage.inputToPasswordTextbox(validPassword);


        registerPage.inputToConfirmPasswordTextbox(validPassword);
        sleepInSecond(2);


        registerPage.clickToRegisterButton();


        Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
    }

    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver("local");

    }

}
