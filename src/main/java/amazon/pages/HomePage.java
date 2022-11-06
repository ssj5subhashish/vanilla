package amazon.pages;

import amazon.utils.CommonUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class HomePage extends CommonUtils {

    final static Logger logger = Logger.getLogger(HomePage.class);

    private static final By HAMBURGER_MENU = By.id("nav-hamburger-menu");
    private static final By TV_APPLIANCES_ELECTRONICS_MAIN_MENU = By.xpath("//div[contains(text(),'TV, Appliances, Electronics')]");
    private static final By TELEVISIONS_SUB_MENU = By.xpath("//a[contains(text(),'Televisions')]");

    public static void clickOnHamburgerMenu(){
       logger.info("Clicking on Hamburger Menu");
        waitForElementToBeVisible(HAMBURGER_MENU);
        click(HAMBURGER_MENU);
    }

    public static void scrollAndClickTVAndAppliances(){
        logger.info("Scrolling down and clicking on TV, Appliances, Electronics");
        waitForElementToBeVisible(TV_APPLIANCES_ELECTRONICS_MAIN_MENU);
        scrollToThenClick(TV_APPLIANCES_ELECTRONICS_MAIN_MENU);
    }

    public static void clickOnTelevisionsSubMenu(){
        logger.info("Clicking on Televisions sub menu");
        waitForElementToBeVisible(TELEVISIONS_SUB_MENU);
        click(TELEVISIONS_SUB_MENU);
    }

}
