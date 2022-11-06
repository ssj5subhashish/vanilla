package amazon.pages;

import amazon.utils.CommonUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.TestException;

public class ProductsBrowsePage extends CommonUtils {

    final static Logger logger = Logger.getLogger(ProductsBrowsePage.class);

    private static final By SAMSUNG_FILTER = By.xpath("//span[@class='a-size-base a-color-base'][contains(text(),'Samsung')]");
    private static final By SAMSUNG_FILTER_SELECTED = By.xpath("//span[@class='a-size-base a-color-base a-text-bold'][contains(text(),'Samsung')]");
    private static final By SORT_BY_DROPDOWN_LABEL = By.xpath("//span[@class='a-dropdown-label']");
    private static final By SORT_BY_DROPDOWN_PROMPT = By.xpath("//span[@class='a-dropdown-prompt']");
    private static final By SORT_BY_OPTION = By.xpath("//a[@id='s-result-sort-select_2']");
    private static final String SORT_BY_VALUE = "Price: High to Low";
    private static final By SECOND_HIGHEST_PRICED_ITEM = By.xpath("//div[@data-component-type = 's-search-result' and @data-index = '2']");

    public static void verifyOnProductsBrowsePage(){
        String url = getCurrentURL();
        logger.info("Verifying that we are on the Products Browse Page");
        if (!url.contains("browse")){
            throw new TestException("ERROR: Not on PRODUCTS_BROWSE_PAGE! URL: " + url);
        }
    }

    public static void scrollAndClickSamsungBrandFilter(){
        logger.info("Scrolling down and clicking on the Brand filter - Samsung");
        waitForElementToBeVisible(SAMSUNG_FILTER);
        scrollToThenClick(SAMSUNG_FILTER);
        waitForElementToBeVisible(SAMSUNG_FILTER_SELECTED);
    }

    public static void clickOnSortByDropdownContainer(){
        logger.info("Clicking on the Sort By Dropdown container");
        waitForElementToBeVisible(SORT_BY_DROPDOWN_LABEL);
        click(SORT_BY_DROPDOWN_LABEL);
    }

    public static void selectDropdownOptionPriceHighToLow(){
        waitForElementToBeVisible(SORT_BY_OPTION);
        logger.info("Selecting the Sort By Price: High to Low");
        click(SORT_BY_OPTION);
        waitForElementToBeVisible(SORT_BY_DROPDOWN_PROMPT);
        WebElement dropdownPrompt = getElement(SORT_BY_DROPDOWN_PROMPT);
        if (dropdownPrompt.getText().contains(SORT_BY_VALUE)){
            logger.info("Sort By Price: High to Low is selected");
        }
        else {
            throw new TestException("ERROR: Sort By Price: High to Low is not selected");
        }
    }

    public static void clickOnTheSecondHighestPricedItem(){
        waitForElementToBeClickable(SECOND_HIGHEST_PRICED_ITEM);
        logger.info("Clicking on the Second Highest Priced Television from the Results");
        click(SECOND_HIGHEST_PRICED_ITEM,10);
        logger.info("Navigating to the Product detail window of the Second Highest Priced Television");
        switchToWindowOpened();
        logger.info("Navigated to the Product detail window of the Second Highest Priced Television");
    }
}
