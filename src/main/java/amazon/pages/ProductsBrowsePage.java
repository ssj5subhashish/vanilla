package amazon.pages;

import amazon.utils.CommonUtils;
import org.apache.log4j.Logger;
import org.testng.TestException;

public class ProductsBrowsePage extends CommonUtils {

    final static Logger logger = Logger.getLogger(ProductsBrowsePage.class);

    public static void verifyOnProductsBrowsePage(){
        String url = getCurrentURL();
        logger.info("PRODUCTS_BROWSE_PAGE: Verifying that we are on PRODUCTS_BROWSE_PAGE.");
        if (!url.contains("browse")){
            throw new TestException("ERROR: Not on PRODUCTS_BROWSE_PAGE! URL: " + url);
        }
    }
}
