package utils;

import models.User;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.base.BasePage;
import runner.utils.Config;

public class TestUtils {

    public static void registerUserAndLogout(WebDriver driver, User user){
        new HomePage(driver)
                .clickLoginMenu()
                .enterUserNameToSignUp(user.getFullName())
                .enterEmailToSignUp(user.getEmail())
                .clickSignupButton()
                .fillInUserInfo(user)
                .selectSignUpCheckbox()
                .selectReceiveCheckbox()
                .fillInAddressInfo(user)
                .clickCreateAccountButton()
                .clickContinueButton()
                .clickLogout();
    }

    public static void loginUser(WebDriver driver, User user) {
        new HomePage(driver)
                .clickLoginMenu()
                .enterEmailToLogIn(user.getEmail())
                .enterPasswordToLogIn(user.getPassword())
                .clickLogin();
    }

    public static void logoutFrom(BasePage basePage) {
        basePage.clickLogout();
    }

    public static void goToHomepage(BasePage basePage) {
        basePage.clickLogoToGoHome();
    }


}


