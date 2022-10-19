package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.adminnopcommerce.AdminLoginPageObject;
import pageObjects.usernopcommerce.*;


public class PageGeneratorManager {
    public static UserHomePageObject getUserHomePage(WebDriver driver) {
        return new UserHomePageObject(driver);
    }

    public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
        return new UserLoginPageObject(driver);
    }

    public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
        return new UserRegisterPageObject(driver);
    }

    public static UserCustomerInforPageObject getUserCustomerInforPage(WebDriver driver) {
        return new UserCustomerInforPageObject(driver);
    }

    public static UserAddressPageObject getUserAddressPage(WebDriver driver) {
        return new UserAddressPageObject(driver);
    }

    public static UserMyProductReviewPageObject getUserMyProductReviewPage(WebDriver driver) {
        return new UserMyProductReviewPageObject(driver);
    }


    public static UserRewardPointPageObject getUserRewardPointPage(WebDriver driver) {
        return new UserRewardPointPageObject(driver);
    }

    public static UserSearchPageObject getUserSearchPage(WebDriver driver) {
        return new UserSearchPageObject(driver);
    }

}
