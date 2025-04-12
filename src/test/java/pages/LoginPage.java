package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElement signUpButton;

    @FindBy(css = "input[data-qa='signup-name']")
    private WebElement nameFieldSignUp;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElement emailFieldSignUp;

    @FindBy(css = "[data-qa='login-email']")
    private WebElement emailFieldLogIn;

    @FindBy(css = "[data-qa='login-password']")
    private WebElement passwordFieldLogIn;

    @FindBy(css = "[data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[text()='Email Address already exist!']")
    private WebElement errorMessageUserExists;


    public boolean isOnLoginPage() {
        return isDisplayed(signUpButton);
    }

    public LoginPage enterUserNameToSignUp(String name) {
        type(nameFieldSignUp, name);
        return this;
    }

    public LoginPage enterEmailToSignUp(String email) {
        type(emailFieldSignUp, email);
        return this;
    }


    public CreateAccountPage clickSignupButton() {
        click(signUpButton);
        return new CreateAccountPage(driver);
    }

    public LoginPage clickSignupButtonWhenUserExists() {
        click(signUpButton);
        return this;
    }

    public LoginPage enterEmailToLogIn(String email) {
        type(emailFieldLogIn, email);
        return this;
    }

    public LoginPage enterPasswordToLogIn(String password) {
        type(passwordFieldLogIn, password);
        return this;
    }

    public void clickLogin() {
        click(loginButton);
    }

    public HomePage clickLoginButton() {
        click(loginButton);
        return new HomePage(driver);
    }

    public String getErrorMessageUserExists() {
        return getText(errorMessageUserExists);
    }




}
