package amazon.steps;

import amazon.pages.HomePage;
import amazon.pages.ProductsBrowsePage;

public class BrowseActions {

    public static void navigateToTelevisionProducts(){
        HomePage.clickOnHamburgerMenu();
        HomePage.scrollAndClickTVAndAppliances();
        HomePage.clickOnTelevisionsSubMenu();
    }

    public static void browseProducts(){
        ProductsBrowsePage.verifyOnProductsBrowsePage();
    }

}
