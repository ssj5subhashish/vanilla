package amazon.pages;

import amazon.config.EnvFactory;
import amazon.utils.CommonUtils;
import com.typesafe.config.Config;
import org.testng.TestException;

public class ProductsBrowsePage extends CommonUtils {
    private static Config config = EnvFactory.getInstance().getConfig();

    public ProductsBrowsePage(){
    }

    public void verifyOnProductsBrowsePage(){
        String url = getCurrentURL();
        System.out.println("PRODUCTS_BROWSE_PAGE: Verifying that we are on PRODUCTS_BROWSE_PAGE.");
        if (!url.contains("browse")){
            throw new TestException("ERROR: Not on PRODUCTS_BROWSE_PAGE! URL: " + url);
        }
    }
}
