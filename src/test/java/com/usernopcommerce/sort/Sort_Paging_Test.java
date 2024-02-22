package com.usernopcommerce.sort;

import com.usernopcommerce.register.Register_Success_Global_Test;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.usernopcommerce.UserHomePageObject;
import pageObjects.usernopcommerce.UserLoginPageObject;
import pageObjects.usernopcommerce.UserSearchPageObject;

public class Sort_Paging_Test extends BaseTest {
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
        emailAddress = Register_Success_Global_Test.EMAIL_ADDRESS;
        password = Register_Success_Global_Test.EMAIL_ADDRESS;
        loginPage = homePage.openLoginPage();

        loginPage.inputToEmailTextbox(Register_Success_Global_Test.EMAIL_ADDRESS);

        loginPage.inputToPasswordTextbox(Register_Success_Global_Test.PASSWORD);

        homePage = loginPage.clickToLoginButton();
    }

    @Test
    public void TC_01_Sort_With_Name_A_To_Z() {
        homePage.clickToNotebookLink();
        homePage.selectSortDropdown("Name: A to Z");
        homePage.sleepInSecond(3);

        // Verify sort A-Z
        homePage.isDataSortedAscending();
    }

    @Test
    public void TC_02_Sort_With_Name_Z_To_A() {
        homePage.clickToNotebookLink();
        homePage.selectSortDropdown("Name: Z to A");
        homePage.sleepInSecond(3);
        // Verify sort Z-A
        homePage.isDataSortedDesending();

    }

    @Test
    public void TC_03_Sort_With_Price_Low_High() {
        homePage.clickToNotebookLink();
        homePage.selectSortDropdown("Price: Low to High");
        homePage.sleepInSecond(3);
        // Verify
        homePage.isPriceSortLowToHigh();
    }

    @Test
    public void TC_04_Sort_With_Price_High_To_Low() {
        homePage.clickToNotebookLink();
        homePage.selectSortDropdown("Price: High to Low");
        homePage.sleepInSecond(3);
        // Verify Sort
        homePage.isPriceSortHighToLow();
    }
    @Test
    public void TC_05_Display_With_3_Product_Per_Page() {
        homePage.clickToNotebookLink();
        homePage.selectDisplayPerPageDropdown("3");
        homePage.sleepInSecond(5);
        // Verify 3 product
        Assert.assertEquals(homePage.isProductDisplay(), 3);
        // Verify next icon at Page 1
        Assert.assertTrue(homePage.isNextPageIconDisplayed());
        homePage.clickToNextPageIcon();
        // Verify previous icon at Page 2
        Assert.assertTrue(homePage.isPreviousPageIconDisplayed());
    }

    @Test
    public void TC_06_Display_With_6_Product_Per_Page() {
        homePage.clickToNotebookLink();
        // Verify 6 product
        Assert.assertEquals(homePage.isProductDisplay(), 6);
        // Verify ko xuất hiện paging
        Assert.assertTrue(homePage.isPagingUnDisplayed());
    }
    @Test
    public void TC_07_Display_With_9_Product_Per_Page() {
        homePage.clickToNotebookLink();
        homePage.selectDisplayPerPageDropdown("9");
        // Verify 6 product
        Assert.assertEquals(homePage.isProductDisplay(), 6);

        // Verify ko xuất hiện paging
        Assert.assertTrue(homePage.isPagingUnDisplayed());
    }

    @AfterClass
    public void AfterClass() {
        closeBrowserAndDriver("local");
    }
}
