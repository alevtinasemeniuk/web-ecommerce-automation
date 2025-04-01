package tests;

import io.qameta.allure.Description;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;
import pages.HomePage;
import utils.DataGenerator;
import utils.UserGenerator;

import java.util.Random;

public class RegistrationTest extends BaseTest {

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
        User testUser = UserGenerator.generateRandomUser();

        boolean result = new HomePage(driver)
                .clickLogin()
                .enterUserName(testUser.getFullNameName())
                .enterEmail(testUser.getEmail())
                .clickSignupButton()
                .clickTitleRadioButton(testUser.getTitle())
                .enterPassword(testUser.getPassword())
                .selectDay(testUser.getDay())
                .selectMonth(testUser.getMonth())
                .selectYear(testUser.getYear())
                .enterFirstNameToAddressInfo(testUser.getAddress().getFirstName())
                .enterLastNameToAddressInfo(testUser.getAddress().getLastName())
                .enterCompanyToAddressInfo((testUser.getAddress().getCompany()))
                .enterAddress(testUser.getAddress().getAddress())
                .enterAddress2(testUser.getAddress().getAddress2())
                .selectCountry(testUser.getAddress().getCountry())
                .enterState(testUser.getAddress().getState())
                .enterCity(testUser.getAddress().getCity())
                .enterZipCode(testUser.getAddress().getZipCode())
                .enterMobileNumber(testUser.getAddress().getMobileNumber())
                .clickCreateAccountButton()
                .isAccountCreated();

        Assert.assertTrue(result, "The user is not registered!");
    }

}
