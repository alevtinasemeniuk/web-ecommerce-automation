package tests;

import io.qameta.allure.Description;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import runner.BaseTest;
import pages.HomePage;
import utils.DataGenerator;
import utils.TestUtils;
import utils.UserGenerator;

public class RegistrationTest extends BaseTest {
    private User user;

    @AfterMethod(alwaysRun = true)
    private void deleteUser() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLogoToGoHome();

        if (user != null && homePage.userIsLoggedIn()) {
            homePage.clickDeleteAccountButton();
        }
    }

    @Test
    @Description("Redirect to Create Account Page after signup click")
    public void testRedirectToCreateAccountPage() {
        boolean result = new HomePage(driver).
                clickLoginMenu()
                .enterUserNameToSignUp(DataGenerator.generateUserFullName())
                .enterEmailToSignUp(DataGenerator.generateUserEmail())
                .clickSignupButton()
                .isOnCreateAccountPage();

        Assert.assertTrue(result, "User is not on the Create Account Page");
    }

    @Test
    @Description("User can register with valid data")
    public void testRegisterWithValidData() {
        user = UserGenerator.generateRandomUser();

        boolean result = new HomePage(driver)
                .clickLoginMenu()
                .enterUserNameToSignUp(user.getFullName())
                .enterEmailToSignUp(user.getEmail())
                .clickSignupButton()
                .fillInUserInfo(user)
                .selectSignUpCheckbox()
                .selectReceiveCheckbox()
                .fillInAddressInfo(user)
                .clickCreateAccountButton()
                .isAccountCreated();

        Assert.assertTrue(result, "Expected to be on the Account Page after signup step");
    }

    @Test
    @Description("User can't register with existing email")
    public void testRegisterWithExistingEmail() {
        user = UserGenerator.generateRandomUser();

        TestUtils.registerUserAndLogout(driver, user);

        String errorMessage = new LoginPage(driver)
                .enterUserNameToSignUp(user.getFullName())
                .enterEmailToSignUp(user.getEmail())
                .clickSignupButtonWhenUserExists()
                .getErrorMessageUserExists();

        Assert.assertEquals(errorMessage, "Email Address already exist!");
    }


}
