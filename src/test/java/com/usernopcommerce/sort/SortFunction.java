package com.usernopcommerce.sort;

import com.usernopcommerce.register.Register_Success_Global;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.usernopcommerce.UserHomePageObject;
import pageObjects.usernopcommerce.UserLoginPageObject;
import pageObjects.usernopcommerce.UserSearchPageObject;

public class SortFunction extends BaseTest {
    WebDriver driver;
    UserHomePageObject homePage;
    UserLoginPageObject loginPage;
    UserSearchPageObject searchPage;
    public String emailAddress, password;

    @Parameters({"envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
    @BeforeClass
    public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber, @Optional("Windows") String osName, @Optional("10") String osVersion) {


        driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
        homePage = PageGeneratorManager.getUserHomePage(driver);


        // Login
        emailAddress = Register_Success_Global.EMAIL_ADDRESS;
        password = Register_Success_Global.EMAIL_ADDRESS;
        loginPage = homePage.openLoginPage();

        loginPage.inputToEmailTextbox(Register_Success_Global.EMAIL_ADDRESS);

        loginPage.inputToPasswordTextbox(Register_Success_Global.PASSWORD);


        homePage = loginPage.clickToLoginButton();

    }

    @Test
    public void TC_01_Sort_With_Name_A_To_Z() {

        homePage.clickToNotebookLink();
        homePage.selectSortDropdown("Name: A to Z");
        homePage.sleepInSecond(3);

        // Verify

    }

    @Test
    public void TC_02_Sort_With_Name_Z_To_A() {

        homePage.clickToNotebookLink();
        homePage.selectSortDropdown("Name: Z to A");
        homePage.sleepInSecond(3);

        // Verify

    }

    @Test
    public void TC_03_Sort_With_Price_Low_High() {

        homePage.clickToNotebookLink();
        homePage.selectSortDropdown("Price: Low to High");
        homePage.sleepInSecond(3);

        // Verify

    }

    @Test
    public void TC_03_Sort_With_Price_High_To_Low() {

        homePage.clickToNotebookLink();
        homePage.selectSortDropdown("Price: High to Low");
        homePage.sleepInSecond(3);

        // Verify

    }

    @AfterClass
    public void AfterClass() {
        closeBrowserAndDriver("local");
    }
}
