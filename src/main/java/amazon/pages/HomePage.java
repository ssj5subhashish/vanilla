package amazon.pages;

import amazon.config.EnvFactory;
import amazon.utils.CommonUtils;
import com.typesafe.config.Config;
import org.openqa.selenium.By;

public class HomePage extends CommonUtils {
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private final By HAMBURGER_MENU = By.id("nav-hamburger-menu");
    private final By TV_APPLIANCES_ELECTRONICS_MAIN_MENU = By.xpath("//div[contains(text(),'TV, Appliances, Electronics')]");
    private final By TELEVISIONS_SUB_MENU = By.xpath("//a[contains(text(),'Televisions')]");

    public HomePage(){
    }

    public void navigateToHomePage() {
        System.out.println("Navigating to Amazon.com: " + HOME_PAGE_URL);
        navigateToURL(HOME_PAGE_URL);
    }

    public void clickOnHamburgerMenu(){
        System.out.println("Clicking on Hamburger Menu");
        waitForElementToBeVisible(HAMBURGER_MENU);
        click(HAMBURGER_MENU);
    }

    public void scrollAndClickTVAndAppliances(){
        System.out.println("Scrolling down and clicking on TV, Appliances, Electronics");
        waitForElementToBeVisible(TV_APPLIANCES_ELECTRONICS_MAIN_MENU);
        scrollToThenClick(TV_APPLIANCES_ELECTRONICS_MAIN_MENU);
    }

    public void clickOnTelevisionsSubMenu(){
        System.out.println("Clicking on Televisions sub menu");
        waitForElementToBeVisible(TELEVISIONS_SUB_MENU);
        click(TELEVISIONS_SUB_MENU);
    }

}
