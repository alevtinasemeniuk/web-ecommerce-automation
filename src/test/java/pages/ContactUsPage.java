package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class ContactUsPage extends BasePage {

    @FindBy(xpath = "//h2[contains(text(), 'Contact')]")
    WebElement contactUsTitle;

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public String getContactUsTitle() {
        return contactUsTitle.getText();
    }

}
