package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.DeleteAccountPage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[href='/logout']")
    private WebElement logoutButton;

    @FindBy(css = "[src='/static/images/home/logo.png']")
    private WebElement logo;

    @FindBy(css = "[href='/delete_account']")
    private WebElement deleteAccountButton;

    @FindBy(xpath = "//a[contains(text(), 'Logged in as')]")
    private WebElement userLoggedInIndicator;

    public void clickDeleteAccountButton() {
        click(deleteAccountButton);
    }

    public void clickLogoToGoHome() {
        click(logo);
    }

    public void clickLogout() {
        click(logoutButton);
    }

    protected void selectFromDropdownByValue(WebElement dropdown, String value) {
        logger.info("Selecting value '{}' from dropdown: {}", value, dropdown);
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    protected void selectFromDropdownByVisibleText(WebElement dropdown, String text) {
        logger.info("Selecting visible text '{}' from dropdown: {}", text, dropdown);
        new Select(dropdown).selectByVisibleText(text);
    }

    protected void selectFromDropdownByIndex(WebElement dropdown, int index) {
        logger.info("Selecting index '{}' from dropdown: {}", index, dropdown);
        new Select(dropdown).selectByIndex(index);
    }

    protected void click(WebElement element) {
        logger.info("Clicking on element: {}", element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void type(WebElement element, String text) {
        logger.info("Typing into element: {} | Text: '{}'", element, text);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    public boolean userIsLoggedIn() {
        return !driver.findElements(By.xpath("//a[contains(text(), 'Logged in as')]")).isEmpty();
    }

    protected DeleteAccountPage clickDeleteAccount() {
        click(deleteAccountButton);
        return new DeleteAccountPage(driver);
    }

    protected HomePage clickLogo() {
        click(logo);
        return new HomePage(driver);
    }

    protected LoginPage clickLogoutButton() {
        click(logoutButton);
        return new LoginPage(driver);
    }

    protected String getText(WebElement element) {
        logger.info("Getting text from element: {}", element);
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    protected boolean isDisplayed(WebElement element) {
        try {
            boolean visible = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
            logger.info("Element is visible: {}", element);
            return visible;
        } catch (TimeoutException e) {
            logger.warn("Element is NOT visible within timeout: {}", element);
            return false;
        }
    }

}

