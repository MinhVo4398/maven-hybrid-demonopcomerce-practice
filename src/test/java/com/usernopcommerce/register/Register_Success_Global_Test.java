package com.usernopcommerce.register;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.usernopcommerce.UserHomePageObject;
import pageObjects.usernopcommerce.UserRegisterPageObject;
import utilities.DataHelper;

public class Register_Success_Global_Test extends BaseTest {

    private WebDriver driver;
    private String firstName, lastName;
    public static String PASSWORD, EMAIL_ADDRESS;


    public DataHelper dataHelper;

    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;


    @Parameters({"envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
    @BeforeTest
    public void beforeTest(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber, @Optional("Windows") String osName, @Optional("10") String osVersion) {

        driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
        dataHelper = DataHelper.getDataHelper();

        homePage = PageGeneratorManager.getUserHomePage(driver);
        registerPage = homePage.openRegisterPage();

        firstName = "Automation";
        lastName = "FC";
        EMAIL_ADDRESS = "afc" + generateFakeNumber() + "@mail.vn";
        PASSWORD = "123456";

        registerPage.inputToFirstNameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox(EMAIL_ADDRESS);

        registerPage.inputToPasswordTextbox(PASSWORD);

        registerPage.inputToConfirmPasswordTextbox(PASSWORD);

        registerPage.clickToRegisterButton();
        //homePage = registerPage.clickToLogoutLink();
        homePage = registerPage.clickContinueButton();
        driver.quit();
    }


}
