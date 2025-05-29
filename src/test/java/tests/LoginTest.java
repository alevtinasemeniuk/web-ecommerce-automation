package tests;

import io.qameta.allure.Description;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import runner.BaseTest;
import utils.TestUtils;
import utils.UserGenerator;

public class LoginTest extends BaseTest {

    @Test
    @Description("User can log in with valid email and password")
    public void testLogIn() {
        User user = UserGenerator.generateRandomUser();
        TestUtils.registerUserAndLogout(driver, user);

        String userIsLoggedInText = new LoginPage(driver)
                .enterEmailToLogIn(user.getEmail())
                .enterPasswordToLogIn(user.getPassword())
                .clickLoginButton()
                .getUserNameFromLoggedInMarker();

        Assert.assertEquals(userIsLoggedInText, user.getFullName());
    }

    @Test
    @Description("User cannot log in with empty fields")
    public void testLoginWithEmptyFields() {
        User user = UserGenerator.generateRandomUser();
        TestUtils.registerUserAndLogout(driver, user);

        String currentURL = new LoginPage(driver)
                .clickLoginButton()
                .getCurrentURL();

        Assert.assertEquals(currentURL, "https://automationexercise.com/login");
    }

    @Test
    @Description("User can successfully log out")
    public void testLogOut() {
        User user = UserGenerator.generateRandomUser();
        TestUtils.registerUserAndLogout(driver, user);
        TestUtils.loginUser(driver, user);

        String loginAreaTitle = new AccountPage(driver)
                .clickLogoutButton()
                .getLoginAreaTitle();

        String currentURL = new AccountPage(driver).getCurrentURL();

        Assert.assertEquals(loginAreaTitle, "Login to your account");
        Assert.assertEquals(currentURL, "https://automationexercise.com/login");
    }
}
