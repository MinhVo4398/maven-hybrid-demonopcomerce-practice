package commons;

import org.openqa.selenium.*;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class BasePage {

    public static BasePage getBaseObject() {
        return new BasePage();
    }

    public void openPageUrl(WebDriver driver, String pageUrl) {
        driver.get(pageUrl);
    }

    public String getPageTitle(WebDriver driver) {
        return  driver.getTitle();
    }

    public String getPageUrl (WebDriver driver) {
       return driver.getCurrentUrl();
    }

    public String getPageSource (WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage (WebDriver driver) {
        driver.navigate().refresh();
    }

    // Cookies
    public  void setCookies(WebDriver driver, Set<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
        sleepInSecond(3);

    }

    public  Set<Cookie> getAllCookies(WebDriver driver)  {
        return driver.manage().getCookies();

    }


    public void sleepInSecond(long time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Alert
    public Alert waitForAlertPresent(WebDriver driver) {
        WebDriverWait explicaitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        return explicaitWait.until(ExpectedConditions.alertIsPresent());
    }


    public void accepptAlert(WebDriver driver) {
        waitForAlertPresent(driver).accept();

    }

    public void cancelAlert(WebDriver driver) {
        waitForAlertPresent(driver).dismiss();
    }

    public void getAlertText(WebDriver driver) {
        waitForAlertPresent(driver).getText();
    }

    public void sendKeyToAlert(WebDriver driver, String textValue) {
        waitForAlertPresent(driver).sendKeys(textValue);
    }

    // Handle Window/ Tab
    public void switchToWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();

        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
        driver.findElement(By.xpath(""));
    }

    // Handle locator


    public By getByLocator(String locatorType) {
        By by = null;

        if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {

            by = By.id(locatorType.substring(3));
        } else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=") || locatorType.startsWith("Class=")) {

            by = By.className(locatorType.substring(6));
        } else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=") || locatorType.startsWith("Name=")) {

            by = By.name(locatorType.substring(5));
        } else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
            by = By.cssSelector(locatorType.substring(4));
        } else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPath=")) {

            by = By.xpath(locatorType.substring(6));

        } else {
            throw new RuntimeException("Locator type is not supported!");
        }

        return by;
    }

    public String getDynamicXpath(String locatorType, String... dynamicValues) {
        if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPath=")) {

            locatorType = String.format(locatorType, (Object) dynamicValues);


        }
        return locatorType;
    }

    public WebElement getWebElement(WebDriver driver, String locatorType) {
        return driver.findElement(getByLocator(locatorType));
    }

    public List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
        return driver.findElements(getByLocator(locatorType));
    }

    public void clickToElement(WebDriver driver, String locatorType) {
        getWebElement(driver, locatorType).click();
    }

    public void clickToElement(WebDriver driver, String locatorType, String... dynamicValue) {
        locatorType = getDynamicXpath(locatorType, dynamicValue);
        getWebElement(driver, locatorType).click();
    }


    public void sendKeyToElement(WebDriver driver, String locatorType, String textValue) {
        // clear truoc khi sendKey
        WebElement element = getWebElement(driver, locatorType);
        element.clear();
        element.sendKeys();

    }

    public void sendKeyToElement(WebDriver driver, String locatorType, String textValue, String... dynamicValue) {
        WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValue));
        element.clear();
        element.sendKeys(textValue);
    }

    // Ham kho - clear value by Delete Key
    public void clearValueInElementByDeleteKey(WebDriver driver, String locatorType) {
        WebElement element = getWebElement(driver, locatorType);

        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    // Dropdown
    public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem) {
        Select select = new Select(getWebElement(driver, locatorType));
        select.selectByVisibleText(textItem);
    }

    public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem, String... dynamicValue) {
        Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)));
        select.selectByVisibleText(textItem);
    }

    public String getSelectedItemDefaultDropdown(WebDriver driver, String locatorType, String textItem) {
        Select select = new Select(getWebElement(driver, locatorType));
        return select.getFirstSelectedOption().getText();
    }

    public boolean isDropDownMultiple(WebDriver driver, String locatorType, String textItem) {
        Select select = new Select(getWebElement(driver, locatorType));
        return select.isMultiple();

    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String childXpath,
                                           String expectedItem) {
        getWebElement(driver, parentXpath).click();
        sleepInSecond(1);

        WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);

        List<WebElement> allItems = explicitWait
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSecond(1);

                item.click();
                sleepInSecond(1);
                break;
            }
        }


    }


}
