package pageObjects.usernopcommerce;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.HomePageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserHomePageObject extends BasePage {
    // Biến global;
    private WebDriver driver;

    //constructor
    public UserHomePageObject(WebDriver driver) {
        //  Biến local
        this.driver = driver;
    }


    public UserRegisterPageObject openRegisterPage() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
        return PageGeneratorManager.getUserRegisterPage(driver);

    }


    public UserLoginPageObject openLoginPage() {
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
        return PageGeneratorManager.getUserLoginPage(driver);

    }


    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
    }


    public UserCustomerInforPageObject openMyAccountPage() {
        waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
        return PageGeneratorManager.getUserCustomerInforPage(driver);

    }


    public void clickToComputerProduct() {
        waitForElementClickable(driver, HomePageUI.OWN_COMPUTER_PRODUCT_LINK);
        clickToElement(driver, HomePageUI.OWN_COMPUTER_PRODUCT_LINK);
    }

    public void clickToAddYourReviewLink() {
        waitForElementClickable(driver, HomePageUI.ADD_YOUR_REVIEW_LINK);
        clickToElement(driver, HomePageUI.ADD_YOUR_REVIEW_LINK);
    }

    public void inputToReviewTitle(String textValue) {
        waitForElementVisible(driver, HomePageUI.REVIEW_TITLE);
        sendKeyToElement(driver, HomePageUI.REVIEW_TITLE, textValue);
    }

    public void inputToReviewText(String textValue) {
        waitForElementVisible(driver, HomePageUI.REVIEW_TEXT);
        sendKeyToElement(driver, HomePageUI.REVIEW_TEXT, textValue);
    }

    public void clickToSubmitReviewButton() {
        waitForElementClickable(driver, HomePageUI.SUBMIT_REVIEW_BUTTON);
        clickToElement(driver, HomePageUI.SUBMIT_REVIEW_BUTTON);
    }

    public UserSearchPageObject clickToSearchLink() {
        waitForElementClickable(driver, HomePageUI.SEARCH_LINK);
        clickToElement(driver, HomePageUI.SEARCH_LINK);
        return PageGeneratorManager.getUserSearchPage(driver);
    }

    public void clickToNotebookLink() {
        // Hover Computer link
        waitForElementClickable(driver, HomePageUI.COMPUTERS_LINK);
        clickToElement(driver, HomePageUI.COMPUTERS_LINK);

        // click Notebook link
        waitForElementClickable(driver, HomePageUI.NOTEBOOK_LINK);
        clickToElement(driver, HomePageUI.NOTEBOOK_LINK);
    }

    public void selectSortDropdown(String textItem) {
        waitForElementVisible(driver, HomePageUI.SORT_DROPDOWN);
        selectItemInDefaultDropdown(driver, HomePageUI.SORT_DROPDOWN, textItem);
    }


    public boolean isDataSortedAscending() {
        // Khai báo 1 Array List
        ArrayList<String> arrayList = new ArrayList<>();

        // Tìm tắt cả các Element
        List<WebElement> elementList = getListWebElement(driver, HomePageUI.LIST_ITEM);
        for (WebElement element : elementList) {
            arrayList.add(element.getText());
        }
        System.out.println("---------Dữ liêu trên UI:------");
        for (String name : arrayList) {
            System.out.println(name);

        }

        // Copy qua 1 array list mới để SORT trong Code
        ArrayList<String> sortedList = new ArrayList<>();
        for (String chid : arrayList) {
            sortedList.add(chid);
        }

        // Thực hiện Sort
        Collections.sort(sortedList);
        System.out.println("------Dữ liệu sau khi sort ASC--------");
        for (String name : sortedList) {
            System.out.println(name);

        }
        return sortedList.equals(arrayList);

    }
    public boolean isDataSortedDesending() {
        // Khai báo 1 Array List
        ArrayList<String> arrayList = new ArrayList<>();

        // Tìm tắt cả các Element
        List<WebElement> elementList = getListWebElement(driver, HomePageUI.LIST_ITEM);
        for (WebElement element : elementList) {
            arrayList.add(element.getText());
        }
        System.out.println("---------Dữ liêu trên UI:------");
        for (String name : arrayList) {
            System.out.println(name);

        }

        // Copy qua 1 array list mới để SORT trong Code
        ArrayList<String> sortedList = new ArrayList<>();
        for (String chid : arrayList) {
            sortedList.add(chid);
        }

        // Thực hiện Sort ASC
        Collections.sort(sortedList);
        //Revrerse Data để sort DESC
        Collections.reverse(sortedList);

        System.out.println("------Dữ liệu sau khi  DESC--------");
        for (String name : sortedList) {
            System.out.println(name);

        }
        return sortedList.equals(arrayList);

    }


    public void isPriceSortLowToHigh() {
        ArrayList<Float> productList = new ArrayList<>();

        // Tim tat cac cac element
        List<WebElement> elementList = getListWebElement(driver, HomePageUI.PRICE_ITEM);
        for (WebElement element : elementList) {

            Float fElement = Float.parseFloat(element.getText().replace("$", "").replace(",", "").trim());
            productList.add(fElement);
        }

        System.out.println("---------Dữ liệu trên UI ----------");
        for (Float number : productList) {
            System.out.println(number);
        }

        // Copy qua 1 ArrayList khác
        ArrayList<Float> sortedList = new ArrayList<>();
        for (Float chid : productList) {
            sortedList.add(chid);
        }


        Collections.sort(sortedList);
        System.out.println("---------Dữ liệu đã sort theo ASC ----------");
        for (Float number : sortedList) {
            System.out.println(number);
        }

        // Verify 2 array
        sortedList.equals(productList);

    }

    public void isPriceSortHighToLow() {
        ArrayList<Float> productList = new ArrayList<>();

        // Tim tat cac cac element
        List<WebElement> elementList = getListWebElement(driver, HomePageUI.PRICE_ITEM);
        for (WebElement element : elementList) {

            Float fElement = Float.parseFloat(element.getText().replace("$", "").replace(",", "").trim());
            productList.add(fElement);
        }

        System.out.println("---------Dữ liệu trên UI ----------");
        for (Float number : productList) {
            System.out.println(number);
        }

        // Copy qua 1 ArrayList khác
        ArrayList<Float> sortedList = new ArrayList<>();
        for (Float chid : productList) {
            sortedList.add(chid);
        }


        Collections.sort(sortedList);
        Collections.reverse(sortedList);
        System.out.println("---------Dữ liệu đã sort theo DESC ----------");
        for (Float number : sortedList) {
            System.out.println(number);
        }

        // Verify 2 array
        sortedList.equals(productList);

    }

    public void selectDisplayPerPageDropdown(String textItem) {
        waitForElementVisible(driver, HomePageUI.DISPLAY_PER_PAGE_DROPDOWN);
        selectItemInDefaultDropdown(driver, HomePageUI.DISPLAY_PER_PAGE_DROPDOWN, textItem);
    }

    public void clickToNextPageIcon() {
        waitForElementClickable(driver, HomePageUI.NEXT_PAGE_ICON);
        clickToElement(driver, HomePageUI.NEXT_PAGE_ICON);

    }

    public boolean isNextPageIconDisplayed() {
        waitForElementVisible(driver, HomePageUI.NEXT_PAGE_ICON);
        return isElementDisplayed(driver, HomePageUI.NEXT_PAGE_ICON);
    }
    public boolean isPreviousPageIconDisplayed() {
        waitForElementVisible(driver, HomePageUI.PREVIOUS_PAGE_ICON);
        return isElementDisplayed(driver, HomePageUI.PREVIOUS_PAGE_ICON);
    }

    public int isProductDisplay() {

        return getElementSize(driver, HomePageUI.PROUCTS);
    }

    public boolean isPagingUnDisplayed() {
        return isElementUndisplayed(driver, HomePageUI.PAGING);
    }

    public void clickAddToWishListButton() {
        waitForElementClickable(driver, HomePageUI.WISHLIST_BUTTON);
        clickToElement(driver, HomePageUI.WISHLIST_BUTTON);
    }

    public void clickAddToWishListButtonInProduct() {
        waitForElementClickable(driver, HomePageUI.WISHLIST_BUTTON_IN_PRODUCT);
        clickToElement(driver, HomePageUI.WISHLIST_BUTTON_IN_PRODUCT);
    }

    public String isNotificationMessageDisplayed() {
        waitForElementVisible(driver, HomePageUI.NOTIFICATION_MESSAGE);
        return getElementText(driver, HomePageUI.NOTIFICATION_MESSAGE);
    }

    public UserWhishlistPageObject clickToWhishListLink() {
        waitForElementClickable(driver, HomePageUI.WHISH_LIST_LINK);
        clickToElement(driver, HomePageUI.WHISH_LIST_LINK);
        return PageGeneratorManager.getUserWishListPage(driver);
    }

    public void clickToMacbookProductLink() {
        waitForElementClickable(driver, HomePageUI.MACBOOK_PRODUCT);
        clickToElement(driver, HomePageUI.MACBOOK_PRODUCT);
    }
}

