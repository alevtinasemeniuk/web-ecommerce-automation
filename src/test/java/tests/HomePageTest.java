package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import runner.BaseTest;

public class HomePageTest extends BaseTest {

    @Test
    public void testClickProductsMenu(){
        String text = new HomePage(getDriver())
                .clickProducts()
                .getAllCategoriesTitle()
                .toLowerCase();

        Assert.assertEquals(text, "all products");
    }

}
