package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class HomePage extends BasePage {

    @FindBy(xpath = "//ul[contains(@class, 'nav')]//a[@href='/']")
    private WebElement homeMenu;

    @FindBy(xpath = "//ul[contains(@class, 'nav')]//a[@href='/products']")
    private WebElement productsMenu;

    @FindBy(xpath = "//div[@class='col-sm-8']//a[@href='/view_cart']")
    private WebElement cartMenu;

    @FindBy(xpath = "//div[@class='col-sm-8']//a[@href='/login']")
    private WebElement loginMenu;

    @FindBy(xpath = "//a[contains(@href, 'youtube')]")
    private WebElement videoMenu;

    @FindBy(xpath = "--//a[@href='/contact_us']")
    private WebElement contactUsMenu;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage clickProducts(){
        click(productsMenu);
        return new ProductsPage(driver);
    }

    public CartPage clickCart(){
        click(cartMenu);
        return new CartPage(driver);
    }

    public LoginPage clickLogin(){
        click(loginMenu);
        return new LoginPage(driver);
    }

    public void clickVideoTutorials() {
        click(videoMenu);
    }

    public ContactUsPage clickContactUs(){
        click(contactUsMenu);
        return new ContactUsPage(driver);
    }

}
