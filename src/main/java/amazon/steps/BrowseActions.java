package amazon.steps;

import amazon.pages.HomePage;
import amazon.pages.ProductDetailPage;
import amazon.pages.ProductsBrowsePage;

public class BrowseActions {

    public static void navigateToTelevisionProducts(){
        HomePage.clickOnHamburgerMenu();
        HomePage.scrollAndClickTVAndAppliances();
        HomePage.clickOnTelevisionsSubMenu();
    }

    public static void browseProducts(){
        ProductsBrowsePage.verifyOnProductsBrowsePage();
        ProductsBrowsePage.scrollAndClickSamsungBrandFilter();
        ProductsBrowsePage.clickOnSortByDropdownContainer();
        ProductsBrowsePage.selectDropdownOptionPriceHighToLow();
        ProductsBrowsePage.clickOnTheSecondHighestPricedItem();
    }

    public static void productDetails(){
        ProductDetailPage.assertAboutThisItemSection();
    }

}
