package userinterface;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ElementsAppearance extends BaseTests {

    @Test
    public void testHeadlineTitleAndLogo(){
        assertTrue(homePage.checkHeadlineAppearance(),"headline is not displayed");
        assertTrue(homePage.getHeadlineTitle().contains("PRODUCT STORE"),"typo in headline title");
        assertTrue(homePage.getHeadlineLogoSrc().contains("bm.png"),"logo image in not correct");

    }


    @Test
    public void testCategoriesBox(){
        assertEquals(homePage.getProductsCategoriesTitle(),"CATEGORIES","error in categories title");
        String[] categories = {"Phones","Laptops","Monitors"};
        assertEquals(homePage.getProductsCategories(),categories,"error in categories");

    }


}
