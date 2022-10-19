package pageUIs;

public class AddressPageUI {
    public static final String ADD_NEW_BUTTON = "xpath=//button[contains(@class,'add-address-button')]";
    public static final String FIRST_NAME_TEXTBOX = "xpath=//input[@id='Address_FirstName']";
    public static final String LAST_NAME_TEXTBOX = "xpath=//input[@id='Address_LastName']";
    public static final String EMAIL_TEXTBOX = "xpath=//input[@id='Address_Email']";
    public static final String COMPANY_TEXTBOX = "xpath=//input[@id='Address_Company']";
    public static final String COUNTRY_DROPDOWN = "xpath=//select[@id='Address_CountryId']";
    public static final String STATE_DROPDOWN = "xpath=//select[@id='Address_StateProvinceId']";
    public static final String CITY_TEXTBOX = "xpath=//input[@id='Address_City']";
    public static final String ADDRESS1_TEXTBOX = "xpath=//input[@id='Address_Address1']";
    public static final String ADDRESS2_TEXTBOX = "xpath=//input[@id='Address_Address2']";
    public static final String ZIP_TEXTBOX = "xpath=//input[@id='Address_ZipPostalCode']";
    public static final String PHONE_NUMBER_TEXTBOX = "xpath=//input[@id='Address_PhoneNumber']";
    public static final String FAX_NUMBER = "xpath=//input[@id='Address_FaxNumber']";
    public static final String SAVE_BUTTON = "xpath=//button[contains(@class,'save-address-button')]";

    public static final String ADDRESS_NAME = "xpath=//ul[@class='info']/li[@class='name']";
    public static final String ADDRESS_EMAIL = "xpath=//ul[@class='info']/li[@class='email' and contains(text(),'%s')]";
    public static final String ADDRESS_PHONE_NUMBER = "xpath=//ul[@class='info']/li[@class='phone']/label/following-sibling::*";
    public static final String ADDRESS_FAX = "xpath=//ul[@class='info']/li[@class='fax' and contains(text(),' %s')]";
    public static final String ADDRESS_COMPANY = "xpath=//ul[@class='info']/li[@class='company']";
    public static final String ADDRESS1 = "xpath=//ul[@class='info']/li[@class='address1']";
    public static final String ADDRESS2 = "xpath=//ul[@class='info']/li[@class='address2']";
    public static final String ADRESS_ZIP = "//ul[@class='info']/li[@class='city-state-zip' and contains(text(),' 4566000')]";
    public static final String ADDRESS_COUNTRY = "xpath=//ul[@class='info']/li[@class='country']";
    public static final String LOGOUT_LINK = "xpath=//a[@class='ico-logout']";
    public static final String COMPUTER_LINK = "xpath=//div[@class='header-menu']/ul[contains(@class,'notmobile')]/li/a[text()='Computers ']";
    public static final String DESKTOP_LINK = "xpath=//div[@class='header-menu']/ul[contains(@class,'notmobile')]//a[text()='Desktops ']";


}
