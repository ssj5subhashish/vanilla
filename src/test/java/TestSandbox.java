import amazon.config.EnvFactory;
import amazon.steps.BrowseActions;
import com.typesafe.config.Config;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static amazon.utils.CommonUtils.closeAndQuitDriver;
import static amazon.utils.CommonUtils.navigateToURL;

public class TestSandbox {

    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");

    @BeforeEach
    public void setUp(){
        navigateToURL(HOME_PAGE_URL);
    }

    @Test
    void test_assignment(){
        BrowseActions.navigateToTelevisionProducts();
        BrowseActions.browseProducts();
        BrowseActions.productDetails();
    }

    @AfterEach
    public void tearDown(){
        closeAndQuitDriver();
    }
}
