package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import runner.BaseTest;

public class CartPage extends BasePage {

    @FindBy(css = "a.btn-default.check_out")
    private WebElement checkoutButton;

    @FindBy(xpath = "//div[@class='breadcrumbs']//li[2]")
    private WebElement cartBreadCrumb;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnCartPage(){
        return isDisplayed(cartBreadCrumb);
    }

}
