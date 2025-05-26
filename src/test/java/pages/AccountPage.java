package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[@data-qa='account-created']")
    private WebElement accountCreatedTitle;

    @FindBy(css = "[data-qa='continue-button']")
    private WebElement continueButton;

    @FindBy(xpath = "//a[contains(text(), 'Logged in as')]/b")
    private WebElement userLoggedInMarker;



    public boolean isAccountCreated() {
        return isDisplayed(accountCreatedTitle);
    }

    public HomePage clickContinueButton() {
        click(continueButton);
        return new HomePage(driver);
    }

    public String getUserNameFromLoggedInMarker() {
        return getText(userLoggedInMarker);
    }



}
