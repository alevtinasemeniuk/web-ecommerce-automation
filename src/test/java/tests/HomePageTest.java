package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import runner.BaseTest;

public class HomePageTest extends BaseTest {

    @Test
    @Description("Check that the PLP opens after clicking Products in the menu")
    public void testClickProductsInMenu(){
        String text = new HomePage(getDriver())
                .clickProducts()
                .getAllCategoriesTitle()
                .toLowerCase();

        Assert.assertEquals(text, "all products");
    }

    @Test
    @Description("Check that the Cart page openes after clicking Cart in the menu")
    public void testClickCartInMenu(){
        String cartBreadCrumbText = new HomePage(getDriver())
                .clickCart()
                .getCartBreadCrumb()
                .toLowerCase();

        Assert.assertEquals(cartBreadCrumbText, "shopping cart");
    }

    @Test
    @Description("Check that the Sign Up button appears after clicking Signup/Login in the menu")
    public void testClickLoginMenu() {
        WebElement signUpButtton = new HomePage(getDriver())
                .clickLogin()
                .getSignUpButton();
        Assert.assertTrue(signUpButtton.isDisplayed(), "Sign Up button is not visible after clicking Login");
    }

    @Test
    @Description("Check that the Contuct Us page openes after ckicking Contact us in the menu")
    public void testClickContactUsMenu() {
        String contactUsTitle = new HomePage(getDriver())
                .clickContactUs()
                .getContactUsTitle()
                .toLowerCase();

        Assert.assertEquals(contactUsTitle, "contact us");
    }

    @Test
    @Description("Check that the YouTube page openes after clicking Video Tutorials in the menu")
    public void testClickVideoTutorialsMenu() {
        new HomePage(getDriver())
                .clickVideoTutorials();
        Assert.assertEquals(
                getDriver().findElement(By.xpath("//span[text()='AutomationExercise']")).getText(),
                "AutomationExercise");
    }
}
