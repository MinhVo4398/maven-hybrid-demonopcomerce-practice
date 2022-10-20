package com.usernopcommerce.whishlist;

import com.usernopcommerce.register.Register_Success_Global;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.usernopcommerce.*;

public class Wishlist_Compare_RecentView extends BaseTest {
    WebDriver driver;
    UserHomePageObject homePage;
    UserLoginPageObject loginPage;
    UserSearchPageObject searchPage;
    UserWhishlistPageObject wishListPage;
    UserShoppingCartPageObject shoppingCartPage;
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
    public void TC_01_Add_To_Wishlist() {
        homePage.clickToNotebookLink();
        homePage.clickToMacbookProductLink();
        // Click Add To wishlist
        homePage.clickAddToWishListButtonInProduct();

        // Verify message
        Assert.assertEquals(homePage.isNotificationMessageDisplayed(), "The product has been added to your wishlist");

        wishListPage = homePage.clickToWhishListLink();

        // Verify Product dc add vao thanh cong
        wishListPage.isProductNameDisplayed();

    }

    @Test
    public void TC_02_Add_Product_To_Cart_From_Wishlist() {
        wishListPage.checkToAddtoCartCheckbox();
        shoppingCartPage = wishListPage.clickAddToCartButton();
        Assert.assertEquals(shoppingCartPage.isNumberOfProductDisplayedOnCart(), "2");
        Assert.assertEquals(shoppingCartPage.isNumberOfProductDisplayedWishlist(), "0");

    }

    @AfterClass
    public void AfterClass() {
        // closeBrowserAndDriver("local");
    }
}
