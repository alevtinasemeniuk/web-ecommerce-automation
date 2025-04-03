package pages.base;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
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






}

