package tests;

import io.qameta.allure.Description;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;
import pages.HomePage;
import utils.DataGenerator;
import utils.UserGenerator;

public class RegistrationTest extends BaseTest {
    private User testUser;

    @Test
    @Description("Verify that user is redirected to the Create Account Page")
    public void testRedirectToCreateAccountPage() {
        boolean result = new HomePage(driver).
                clickLogin()
                .enterUserName(DataGenerator.generateUserFullName())
                .enterEmail(DataGenerator.generateUserEmail())
                .clickSignupButton()
                .isOnCreateAccountPage();

        Assert.assertTrue(result, "User is not on the Create Account Page");
    }

    @Test
    @Description("Verify that user can register with valid data")
    public void testRegisterWithValidData() {
        testUser = UserGenerator.generateRandomUser();

        boolean result = new HomePage(driver)
                .clickLogin()
                .enterUserName(testUser.getFullName())
                .enterEmail(testUser.getEmail())
                .clickSignupButton()
                .fillInUserInfo(testUser)
                .selectSignUpCheckbox()
                .selectReceiveCheckbox()
                .fillInAddressInfo(testUser)
                .clickCreateAccountButton()
                .isAccountCreated();

        Assert.assertTrue(result, "Expected to be on the Account Page after signup step");
    }

}
