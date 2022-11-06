package amazon.pages;

import amazon.utils.CommonUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static org.testng.AssertJUnit.assertEquals;

public class ProductDetailPage extends CommonUtils {

    final static Logger logger = Logger.getLogger(ProductDetailPage.class);

    private static final By ABOUT_THIS_ITEM_SECTION = By.xpath("//div[@id='feature-bullets']");
    private static final By ABOUT_THIS_ITEM = By.xpath("//h1[@class='a-size-base-plus a-text-bold']");
    private static final String ABOUT_THIS_ITEM_VALUE = "About this item";

    public static void assertAboutThisItemSection(){
        logger.info("Verifying the presence of the About this item section");
        waitForElementToBeVisible(ABOUT_THIS_ITEM_SECTION);
        assertEquals(getElementText(ABOUT_THIS_ITEM),ABOUT_THIS_ITEM_VALUE);
        logger.info("Verified the presence of the About this item section");
    }
}
