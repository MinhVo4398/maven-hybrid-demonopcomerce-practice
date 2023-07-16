package commons;

import factoryEnvironment.*;
import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import reportConfig.allureConfig.VerificationFailures;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;

    public WebDriver getDriverInstance() {
        return this.driver;
    }

    // Hàm này custom cho các browser, Env , Cloud
    protected WebDriver getBrowserDriver(String envName, String serverName, String browserName, String ipAddress, String portNumber, String osName, String osVersion) {
        switch (envName) {
            case "local":
                driver = new LocalFactory(browserName).createDriver();
                break;

            case "grid":
                driver = new GridFactory(browserName, ipAddress, portNumber).createDriver();
                break;

            case "browserStack":
                driver = new BrowserStackFactory(browserName, osName, osVersion).createDriver();
                break;

            case "saucelab":
                driver = new SauceLabFactory(browserName, osName).createDriver();
                break;

            case "crossBrowser":
                driver = new CrossBrowserFactory(browserName, osName).createDriver();
                break;

            case "lambda":
                driver = new LambdaFactory(browserName, osName).createDriver();
                break;


            default:
                driver = new LocalFactory(browserName).createDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(getEnvironmentUrl(serverName));
        return driver;
    }

    public String getEnvironmentUrl(String serverName) {
        String envUrl = null;
        EnvironmentList environment = EnvironmentList.valueOf(serverName.toUpperCase());
        switch (environment) {
            case DEV:
                envUrl = "https://demo.nopcommerce.com/";
                break;
            case TESTING:
                envUrl = "https://testing.nopcommerce.com";
                break;
            case STAGING:
                envUrl = "https://staging.nopcommerce.com";
                break;
            case PRE_PRODUCTION:
                envUrl = "https://pre-prod.nopcommerce.com";
                break;

            case PROD:
                envUrl = "https://prod.nopcommerce.com";
                break;

            default:
                envUrl = null;
                break;

        }
        return envUrl;
    }

    protected int generateFakeNumber() {

        Random rd = new Random();
        return rd.nextInt(99999);

    }

    protected boolean verifyTrue(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertTrue(condition);
            //  log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            pass = false;
            //   log.info(" -------------------------- FAILED -------------------------- ");
            // Add lỗi vào ReportNG
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }


    protected boolean verifyFalse(boolean condition) {
        boolean pass = true;
        try {

            Assert.assertFalse(condition);
            // log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            pass = false;
            // log.info(" -------------------------- FAILED -------------------------- ");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }


    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            //   log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            pass = false;
            // log.info(" -------------------------- FAILED -------------------------- ");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
           return pass;
    }
    protected void closeBrowserAndDriver(String envName) {
        // Trên cloud thì k có cmd dc
        if (envName.equals("local") || envName.equals("grid")) {
            String cmd = "";
            try {
                String osName = System.getProperty("os.name").toLowerCase();
                /* log.info("OS name = " + osName);*/

                String driverInstanceName = driver.toString().toLowerCase();
                /*  log.info("Driver instance name = " + driverInstanceName);*/

                if (driverInstanceName.contains("chrome")) {
                    if (osName.contains("window")) {
                        cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
                    } else {
                        cmd = "pkill chromedriver";
                    }
                } else if (driverInstanceName.contains("internetexplorer")) {
                    if (osName.contains("window")) {
                        cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
                    }
                } else if (driverInstanceName.contains("firefox")) {
                    if (osName.contains("windows")) {
                        cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
                    } else {
                        cmd = "pkill geckodriver";
                    }
                } else if (driverInstanceName.contains("edge")) {
                    if (osName.contains("window")) {
                        cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
                    } else {
                        cmd = "pkill msedgedriver";
                    }
                } else if (driverInstanceName.contains("opera")) {
                    if (osName.contains("window")) {
                        cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
                    } else {
                        cmd = "pkill operadriver";
                    }
                } else if (driverInstanceName.contains("safari")) {
                    if (osName.contains("mac")) {
                        cmd = "pkill safaridriver";
                    }
                }

                if (driver != null) {
                    driver.manage().deleteAllCookies();
                    driver.quit();

                }
            } catch (Exception e) {
                /*log.info(e.getMessage());*/
                e.printStackTrace();
            } finally {
                try {
                    Process process = Runtime.getRuntime().exec(cmd);
                    process.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    protected String getCurrentDate() {
        DateTime nowUTC = new DateTime();
        int day = nowUTC.getDayOfMonth();
        if (day < 10) {
            String dayValue = "0" + day;
            return dayValue;
        }
        return String.valueOf(day);
    }

    protected String getCurrentMonth() {
        DateTime now = new DateTime();
        int month = now.getMonthOfYear();
        if (month < 10) {
            String monthValue = "0" + month;
            return monthValue;
        }
        return String.valueOf(month);
    }

    protected String getCurrentYear() {
        DateTime now = new DateTime();
        return String.valueOf(now.getYear());
    }

    protected String getCurrentDay() {
        return getCurrentDate() + "/" + getCurrentMonth() + "/" + getCurrentYear();
    }

    public void sleepInSecond(long time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAllFileInFolder() {
        try {
            String pathFolderDownload = GlobalConstants.PROJECT_PATH + "/allure-json";
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();

            for (int i = 0; i < listOfFiles.length; ++i) {
                if (listOfFiles[i].isFile()) {
                    System.out.println(listOfFiles[i].getName());
                    (new File(listOfFiles[i].toString())).delete();
                }
            }
        } catch (Exception var5) {
            System.out.print(var5.getMessage());
        }

    }

    @BeforeSuite
    public void initBeforeSuite() {
        this.deleteAllFileInFolder();
    }


}


