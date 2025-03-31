package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[@data-qa='account-created']")
    private WebElement accountCreatedTitle;

    public boolean isAccountCreated() {
        return isDisplayed(accountCreatedTitle);
    }
}
