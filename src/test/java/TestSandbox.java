import amazon.factories.DriverFactory;
import amazon.steps.BrowseActions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSandbox {

    private WebDriver driver ;

    @BeforeClass
    public void setUp(){
        driver = DriverFactory.getDriver();

    }

    @Tag("smokeTest")
    @DisplayName("This test is for demo purpose only to show that the basic code works." +
            "You have to use the best practices that you normally use to design your tests")
    @Test
    void assertThatHomePageTitleIsCorrect() {
        assertEquals("Amazon.com. Spend less. Smile more.", driver.getTitle());
    }

    @Test
    void test_assignment(){
        BrowseActions browseActions = new BrowseActions();
        browseActions.navigateToTelevisionProducts();
        browseActions.browseProducts();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
