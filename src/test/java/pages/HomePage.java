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

    @FindBy(xpath = "//a[@href='/contact_us']")
    private WebElement contactUsMenu;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage clickProducts(){
        productsMenu.click();
        return new ProductsPage(getDriver());
    }

    public CartPage clickCart(){
        cartMenu.click();
        return new CartPage(getDriver());
    }

    public LoginPage clickLogin(){
        loginMenu.click();
        return new LoginPage(getDriver());
    }

    public void clickVideoTutorials() {
        videoMenu.click();
    }

    public ContactUsPage clickContactUs(){
        contactUsMenu.click();
        return new ContactUsPage(getDriver());
    }

}
