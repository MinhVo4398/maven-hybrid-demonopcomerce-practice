package pageUIs;

public class SearchPageUI {
    public static final String SEARCH_BUTTON = "xpath=//div[@class='search-input']//button[text()='Search']";
    public static final String ERROR_MESSAGE = "xpath=//div[@class='warning']";
    public static final String NO_RESULT_MESSAGE = "xpath=//div[@class='no-result']";
    public static final String SEARCH_TEXTBOX = "xpath=//input[@class='search-text']";
    public static final String LENOVO_PRODUCT = "xpath=//a[contains(text(),'Lenovo')]";
    public static final String APPLE_PRODUCT = "xpath=//h2[@class='product-title']/a[contains(text(),'Apple')]";
    public static final String ADVANCE_SEARCH_CHECKBOX = "xpath=//label[text()='Advanced search']/parent::div/input";
    public static final String CATEGORY_DROPDOWN = "xpath=//label[text()='Category:']/parent::div/select";
    public static final String SEARCH_SUB_CATEGORIES_CHECKBOX = "xpath=//label[text()='Automatically search sub categories']/parent::div/input";
    public static final String MANUFACTURER_DROPDOWN = "xpath=//label[text()='Manufacturer:']/parent::div/select";
}
