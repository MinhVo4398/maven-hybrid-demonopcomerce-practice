package com.usernopcommerce.search;

import com.usernopcommerce.register.Register_Success_Global;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.usernopcommerce.UserHomePageObject;
import pageObjects.usernopcommerce.UserLoginPageObject;
import pageObjects.usernopcommerce.UserSearchPageObject;

public class SearchFunction extends BaseTest {
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
    public void TC_01_Search_With_Empty_Data() {
        searchPage = homePage.clickToSearchLink();
        searchPage.clickToSearchButton();
        Assert.assertEquals(searchPage.isErrorMessageDisplayed(), "Search term minimum length is 3 characters");

    }

    @Test
    public void TC_02_Searchh_With_Data_Not_Exist() {

        searchPage = homePage.clickToSearchLink();
        searchPage.inputToSerachTextbox("Macbook Pro 2050");
        searchPage.clickToSearchButton();
        Assert.assertEquals(searchPage.getNoResultMessageDisplayed(), "No products were found that matched your criteria.");

    }

    @Test
    public void TC_03_Search_With_Relative_Product_Name() {

        searchPage = homePage.clickToSearchLink();
        searchPage.inputToSerachTextbox("Lenovo");
        searchPage.clickToSearchButton();
        // Check lai
        // Assert.assertEquals(searchPage.getNumberProduct(),2);
        Assert.assertTrue(searchPage.isProductDisplayed());


    }

    @Test
    public void TC_04_Search_With_Absolute_Product_Name() {

        searchPage = homePage.clickToSearchLink();
        searchPage.inputToSerachTextbox("Thinkpad X1 Carbon");
        searchPage.clickToSearchButton();
        Assert.assertTrue(searchPage.isProductDisplayed());
    }

    @Test

    public void TC_05_Advance_Search_With_Parent_Categories() {
        searchPage = homePage.clickToSearchLink();
        searchPage.inputToSerachTextbox("Apple Macbook Pro");
        searchPage.checkToAdvanceSearch();
        searchPage.selectCategory("Computers");
        searchPage.clickToSearchButton();
        Assert.assertEquals(searchPage.getNoResultMessageDisplayed(), "No products were found that matched your criteria.");
    }

    @Test
    public void TC_06_Advance_Search_With_Sub_Categories() {
        searchPage = homePage.clickToSearchLink();
        searchPage.inputToSerachTextbox("Apple Macbook Pro");
        searchPage.checkToAdvanceSearch();
        searchPage.selectCategory("Computers");
        searchPage.checkToSubCategory();
        searchPage.clickToSearchButton();
        Assert.assertTrue(searchPage.isMacbookProductDisplayed());

    }

    @Test
    public void TC_07_Search_With_Incorrect_Manufacturer() {
        searchPage = homePage.clickToSearchLink();
        searchPage.inputToSerachTextbox("Apple Macbook Pro");
        searchPage.checkToAdvanceSearch();
        searchPage.selectCategory("Computers");
        searchPage.checkToSubCategory();
        searchPage.selectManufacturer("HP");
        searchPage.clickToSearchButton();
        Assert.assertEquals(searchPage.getNoResultMessageDisplayed(), "No products were found that matched your criteria.");
    }

    @Test
    public void TC_08_Search_With_Correct_Manufacturer() {
        searchPage = homePage.clickToSearchLink();
        searchPage.inputToSerachTextbox("Apple Macbook Pro");
        searchPage.checkToAdvanceSearch();
        searchPage.selectCategory("Computers");
        searchPage.checkToSubCategory();
        searchPage.selectManufacturer("Apple");
        searchPage.clickToSearchButton();
        Assert.assertTrue(searchPage.isMacbookProductDisplayed());
    }

    @AfterClass
    public void AfterClass() {
        closeBrowserAndDriver("local");
    }

}