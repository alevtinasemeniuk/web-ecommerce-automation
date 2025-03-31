package pages;

import models.Month;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.base.BasePage;
import runner.utils.Config;

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






}
