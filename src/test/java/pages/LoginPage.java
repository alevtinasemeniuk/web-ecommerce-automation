package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class LoginPage extends BasePage {

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElement signUpButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnLoginPage() {
        return signUpButton.isDisplayed();
    }
}
