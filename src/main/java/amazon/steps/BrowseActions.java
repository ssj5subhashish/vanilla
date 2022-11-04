package amazon.steps;

import amazon.pages.HomePage;
import amazon.pages.ProductsBrowsePage;

public class BrowseActions {

    public void navigateToTelevisionProducts(){
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
        homePage.clickOnHamburgerMenu();
        homePage.scrollAndClickTVAndAppliances();
        homePage.clickOnTelevisionsSubMenu();
    }

    public void browseProducts(){
        ProductsBrowsePage productsBrowsePage = new ProductsBrowsePage();
        productsBrowsePage.verifyOnProductsBrowsePage();
    }


}
