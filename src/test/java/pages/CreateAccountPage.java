package pages;

import models.Month;
import models.User;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.base.BasePage;

public class CreateAccountPage extends BasePage {
    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_gender1")
    private WebElement mrTitleRadioButton;

    @FindBy(id = "id_gender2")
    private WebElement mrsTitleRadioButton;

    @FindBy(css ="input[data-qa='password']")
    private WebElement passwordField;

    @FindBy(css = "select[data-qa='days']")
    private WebElement dayDropdown;

    @FindBy(css = "select[data-qa='months']")
    private WebElement monthDropdown;

    @FindBy(css = "select[data-qa='years']")
    private WebElement yearDropdown;

    @FindBy(css = "input[data-qa='first_name']")
    private WebElement firstNameField;

    @FindBy(css = "input[data-qa='last_name']")
    private WebElement lastNameField;

    @FindBy(css = "input[data-qa='company']")
    private WebElement companyField;

    @FindBy(css = "input[data-qa='address']")
    private WebElement addressField;

    @FindBy(css = "input[data-qa='address2']")
    private WebElement address2Field;

    @FindBy(css = "select[data-qa='country']")
    private WebElement countryDropdown;

    @FindBy(css = "input[data-qa='state']")
    private WebElement stateField;

    @FindBy(css = "input[data-qa='city']")
    private WebElement cityField;

    @FindBy(css = "input[data-qa='zipcode']")
    private WebElement zipCodeField;

    @FindBy(css = "input[data-qa='mobile_number']")
    private WebElement mobileNumberField;

    @FindBy(css = "button[data-qa='create-account']")
    private WebElement createAccountButton;

    @FindBy(id = "newsletter")
    private WebElement signUpCheckbox;

    @FindBy(id = "optin")
    private WebElement receiveCheckbox;

    public CreateAccountPage clickTitleRadioButton(String title) {
        if ("Mr.".equalsIgnoreCase(title)) {
            click(mrTitleRadioButton);
        } else if ("Mrs.".equalsIgnoreCase(title)) {
            click(mrsTitleRadioButton);
        }
        return this;
    }

    public CreateAccountPage enterPassword(String password) {
        type(passwordField, password);
        return this;
    }

    public CreateAccountPage enterFirstNameToAddressInfo(String firstName) {
        type(firstNameField, firstName);
        return this;
    }

    public CreateAccountPage enterLastNameToAddressInfo(String lastName) {
        type(lastNameField, lastName);
        return this;
    }

    public CreateAccountPage enterCompanyToAddressInfo(String companyName) {
        type(companyField, companyName);
        return this;
    }

    public CreateAccountPage enterAddress(String address) {
        type(addressField, address);
        return this;
    }

    public CreateAccountPage enterAddress2(String address2) {
        type(address2Field, address2);
        return this;
    }

    public CreateAccountPage selectDay(int day) {
        selectFromDropdownByValue(dayDropdown, String.valueOf(day));
        return this;
    }

    public CreateAccountPage selectMonth(Month month) {
        selectFromDropdownByValue(monthDropdown, month.getValue());
        return this;
    }

    public CreateAccountPage selectYear(int year) {
        selectFromDropdownByValue(yearDropdown, String.valueOf(year));
        return this;
    }

    public CreateAccountPage selectCountry(String country) {
        Select select = new Select(countryDropdown);
        select.selectByValue(country);
        return this;
    }

    public AccountPage clickCreateAccountButton() {
        click(createAccountButton);
        return new AccountPage(driver);
    }

    public CreateAccountPage enterState(String state) {
        type(stateField, state);
        return this;
    }

    public CreateAccountPage enterCity(String city) {
        type(cityField, city);
        return this;
    }

    public CreateAccountPage enterZipCode(String zipCode) {
        type(zipCodeField, zipCode);
        return this;
    }

    public CreateAccountPage enterMobileNumber(String mobileNumber) {
        type(mobileNumberField, mobileNumber);
        return this;
    }

    public boolean isOnCreateAccountPage() {
        return isDisplayed(createAccountButton);
    }

    public CreateAccountPage fillInUserInfo(User user) {
        clickTitleRadioButton(user.getTitle())
                .enterPassword(user.getPassword())
                .selectDay(user.getDay())
                .selectMonth(user.getMonth())
                .selectYear(user.getYear());
        return this;
    }

    public CreateAccountPage fillInAddressInfo(User user) {
        enterFirstNameToAddressInfo(user.getAddress().getFirstName())
                .enterLastNameToAddressInfo(user.getAddress().getLastName())
                .enterCompanyToAddressInfo(user.getAddress().getCompany())
                .enterAddress(user.getAddress().getAddress())
                .enterAddress2(user.getAddress().getAddress2())
                .selectCountry(user.getAddress().getCountry())
                .enterState(user.getAddress().getState())
                .enterCity(user.getAddress().getCity())
                .enterZipCode(user.getAddress().getZipCode())
                .enterMobileNumber(user.getAddress().getMobileNumber());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createAccountButton);
        return this;
    }

    public CreateAccountPage selectSignUpCheckbox() {
        click(signUpCheckbox);
        return new CreateAccountPage(driver);
    }

    public CreateAccountPage selectReceiveCheckbox() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", receiveCheckbox);
        click(receiveCheckbox);
        return new CreateAccountPage(driver);
    }
}
