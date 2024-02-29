package com.usernopcommerce.myaccount;

import com.usernopcommerce.register.Register_Success_Global_Test;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.usernopcommerce.*;
import utilities.DataHelper;

public class MyAccountTest extends BaseTest {
    WebDriver driver;
    private String firstName, lastName, emailAddress, updatedEmail, day, month, year, compayName, password, confirmPassword,
            addressFirstName, addressLastName, addressEmail, addressCompany, addressCountry, addressState, addressCity, address1, address2,
            addressZip, addressPhoneNumber, addressFaxNumber;

    DataHelper dataHelper;
    UserHomePageObject homePage;
    UserRegisterPageObject registerPage;
    UserLoginPageObject loginPage;
    UserCustomerInforPageObject customerInforPage;
    UserAddressPageObject addressPage;
    UserMyProductReviewPageObject myProductReviewPage;

    @Parameters({"envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
    @BeforeClass
    public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber, @Optional("Windows") String osName, @Optional("10") String osVersion) {
        dataHelper = DataHelper.getDataHelper();
        day = "11";
        month = "June";
        year = "1979";
        firstName = dataHelper.getFirstName();
        lastName = dataHelper.getLastName();
        compayName = dataHelper.getCompanyName();
        confirmPassword = dataHelper.getPassword();
        // Precondition - Register success

        addressFirstName = dataHelper.getFirstName();
        addressLastName = dataHelper.getLastName();

        addressEmail = dataHelper.getEmailAddress();
        addressCompany = dataHelper.getCompanyName();
        addressCountry = "Australia";
        addressState = "Other";
        addressCity = dataHelper.getCityName();
        address1 = dataHelper.getAddress();
        address2 = dataHelper.getAddress();
        addressZip = dataHelper.getZipCode();
        addressPhoneNumber = dataHelper.getPhoneNumber();
        addressFaxNumber = dataHelper.getPhoneNumber();


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
    public void TC_01_Update_Customer_Infor() {
        updatedEmail = "afc" + generateFakeNumber() + "@mail.vn";
        customerInforPage = homePage.openMyAccountPage();
        customerInforPage.checkToFemaleGenderRadio();
        customerInforPage.inputToFirstNameTextbox("Automation");
        customerInforPage.inputToLastNameTextbox("FC");
        customerInforPage.selectDayDropdown("9");
        customerInforPage.selectMonthDropdown("August");
        customerInforPage.selectYearDropdown("1991");
        customerInforPage.inputToEmailAddress(updatedEmail);
        customerInforPage.inputToCompanyNameTextbox(compayName);
        customerInforPage.clickToSaveButton();

        // Verify update thanh cong
        Assert.assertEquals(customerInforPage.isFemaleRadioButtonUpdate("value"), "F");
        Assert.assertEquals(customerInforPage.isFirstNameTextboxUpdate("value"), "Automation");
        Assert.assertEquals(customerInforPage.isLastNameTextboxUpdate("value"), "FC");
        Assert.assertEquals(customerInforPage.isDayDropDownValueUpdate("9"), "9");
        Assert.assertEquals(customerInforPage.isMonthDropdownValueUpdate("August"), "August");
        Assert.assertEquals(customerInforPage.isYearDropdownValueUpdate("1991"), "1991");
        Assert.assertEquals(customerInforPage.isEmailAddressUpdate("value"), updatedEmail);
        Assert.assertEquals(customerInforPage.isCompanyNameTextboxUpdate("value"), compayName);
    }

    @Test
    public void TC_02_Add_Address() {
        addressPage = customerInforPage.openAddressPage(driver);
        addressPage.clickToAddNewButton();
        addressPage.inputToFirstNameTextbox(addressFirstName);
        addressPage.inputToLastNameTextbox(addressLastName);
        addressPage.inputToEmailTextbox(addressEmail);
        addressPage.inputToCompanyTextbox(addressCompany);
        addressPage.selectCountryDropdown(addressCountry);
        addressPage.selectStateDropdown(addressState);
        addressPage.inputToCityTextbox(addressCity);
        addressPage.inputToAddress1Textbox(address1);
        addressPage.inputToAddress2Textbox(address2);
        addressPage.inputToZipTextbox(addressZip);
        addressPage.inputToPhoneNumber(addressPhoneNumber);
        addressPage.inputToFaxNumber(addressFaxNumber);

        addressPage.clickToSaveButton();

        Assert.assertEquals(addressPage.isNameDisplayed(), addressFirstName + " " + addressLastName);
        Assert.assertEquals(addressPage.isPhoneNumberDisplayed(), "Phone number: " + addressPhoneNumber);
        Assert.assertEquals(addressPage.isEmailDisplayed(), "Email: " + addressEmail);
        Assert.assertEquals(addressPage.isFaxNumberDisplayed(), "Fax number: " + addressFaxNumber);
        Assert.assertEquals(addressPage.isZipCodeDisplayed(), addressCity + ", " + addressZip);
        Assert.assertEquals(addressPage.isCompanyDisplayed(), addressCompany);
        Assert.assertEquals(addressPage.isStreet1Displayed(), address1);
        Assert.assertEquals(addressPage.isStreet2Displayed(), address2);
        Assert.assertEquals(addressPage.isCountryDisplayed(), addressCountry);
    }

    @Test
    public void TC_03_My_Product_Review() {
        //Address hover vào computer -> click desktop => homePage
        homePage = addressPage.clickToComputerProductLinkAndDeskTopLink();
        // Click To Product : your old computer
        homePage.clickToComputerProduct();

        // click to add to review link
        homePage.clickToAddYourReviewLink();

        //SendKey vao review title and review text
        homePage.inputToReviewTitle("Review Title");
        homePage.inputToReviewText("Review Text AVC");

        // Click to Submit Review button
        homePage.clickToSubmitReviewButton();

        customerInforPage = homePage.openMyAccountPage(); // customerInfor

        myProductReviewPage = customerInforPage.openMyProductReviewPage(driver);
        // Verify
        Assert.assertEquals(myProductReviewPage.isReviewTitleDisplayed(), "Review Title");
        Assert.assertEquals(myProductReviewPage.isReviewTextDisplayed(), "Review Text AVC");
        sleepInSecond(5);
    }

    @AfterClass
    public void AfterClass() {
        // closeBrowserAndDriver("local");
    }
}