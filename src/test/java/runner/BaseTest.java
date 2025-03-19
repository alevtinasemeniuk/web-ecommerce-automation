package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class BaseTest {
    private WebDriver driver;
    private WebDriverWait wait5;

    @BeforeMethod
    public void setUp() {
        // Использование WebDriverManager для автоматической загрузки драйвера
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        String ciRun = System.getenv("CI_RUN");
        String chromeOptions = System.getenv("CHROME_OPTIONS");

        if (ciRun != null && ciRun.equals("true") && chromeOptions != null) {
            options.addArguments(chromeOptions.split(" "));
        } else {
            options.addArguments("--window-size=1920x1080");
        }

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://automationexercise.com/");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait5() {
        if (wait5 == null) {
            wait5 = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        }
        return wait5;
    }
}
