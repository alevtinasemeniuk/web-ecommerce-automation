package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class LoginPage extends BasePage {

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElement signUpButton;

    @FindBy(css = "input[data-qa='signup-name']")
    private WebElement nameField;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElement emailField;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnLoginPage() {
        return isDisplayed(signUpButton);
    }


}
