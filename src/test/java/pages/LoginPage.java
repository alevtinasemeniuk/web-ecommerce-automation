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
    private WebElement nameField;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElement emailField;



    public boolean isOnLoginPage() {
        return isDisplayed(signUpButton);
    }

    public LoginPage enterUserName(String name) {
        type(nameField, name);
        return this;
    }

    public LoginPage enterEmail(String email) {
        type(emailField, email);
        return this;
    }

    public CreateAccountPage clickSignupButton() {
        click(signUpButton);
        return new CreateAccountPage(driver);
    }


}
