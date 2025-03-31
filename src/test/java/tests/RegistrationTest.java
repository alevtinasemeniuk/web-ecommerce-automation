package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;
import pages.HomePage;
import utils.DataGenerator;

import java.util.Random;

public class RegistrationTest extends BaseTest {

    @Test
    @Description("Verify that user is redirected to the Create Account Page")
    public void testRedirectToCreateAccountPage() {
        boolean result = new HomePage(driver).
                clickLogin()
                .enterUserName(DataGenerator.generateUserNickName())
                .enterEmail(DataGenerator.generateUserEmail())
                .clickSignupButton()
                .isOnCreateAccountPage();

        Assert.assertTrue(result, "User is not on the Create Account Page");
    }

}
