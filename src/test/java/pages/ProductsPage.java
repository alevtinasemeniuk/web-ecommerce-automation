package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//div[@class='features_items']/h2")
    private WebElement allProductsTitle;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getAllCategoriesTitle() {
        return allProductsTitle.getText();
    }


}
