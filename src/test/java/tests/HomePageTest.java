package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import runner.BaseTest;

public class HomePageTest extends BaseTest {

    @Test
    public void testClickProductsInMenu(){
        String text = new HomePage(getDriver())
                .clickProducts()
                .getAllCategoriesTitle()
                .toLowerCase();

        Assert.assertEquals(text, "all products");
    }

    @Test
    public void testClickCartInMenu(){
        String cartBreadCrumbText = new HomePage(getDriver())
                .clickCart()
                .getCartBreadCrumb()
                .toLowerCase();

        Assert.assertEquals(cartBreadCrumbText, "shopping cart");
    }

}
