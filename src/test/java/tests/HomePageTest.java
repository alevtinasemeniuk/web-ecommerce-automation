package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import runner.BaseTest;

public class HomePageTest extends BaseTest {

    private HomePage homepage;

    @BeforeMethod
    public void initPage() {
       homepage = new HomePage(getDriver());
    }

    @Test
    @Description("Check that the PLP opens after clicking Products in the menu")
    public void testClickProductsInMenu(){
        boolean result = homepage
                .clickProducts()
                .isOnProductsPage();

        Assert.assertTrue(result, "User is not on Products page");
    }

    @Test
    @Description("Check that the Cart page opens after clicking Cart in the menu")
    public void testClickCartInMenu(){
        boolean result = homepage
                .clickCart()
                .isOnCartPage();

        Assert.assertTrue(result, "User is not on Cart page");
    }

    @Test
    @Description("Check that the Sign Up button appears after clicking Signup/Login in the menu")
    public void testClickLoginMenu() {
        boolean result = homepage
                .clickLogin()
                .isOnLoginPage();
        Assert.assertTrue(result, "User is not on Login page");
    }

    @Test
    @Description("Check that the Contuct Us page opens after ckicking Contact us in the menu")
    public void testClickContactUsMenu() {
        boolean result = homepage
                .clickContactUs()
                .isOnContactUsPage();

        Assert.assertTrue(result, "User is not on Contact Us page");
    }

    @Test
    @Description("Check that the YouTube page opens after clicking Video Tutorials in the menu")
    public void testClickVideoTutorialsMenu() {
        homepage.clickVideoTutorials();

        WebElement youTubeNameChannel = wait(3).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//span[text()='AutomationExercise']")));

        Assert.assertTrue(youTubeNameChannel.isDisplayed(), "User is not on YouTube page");
    }
}
