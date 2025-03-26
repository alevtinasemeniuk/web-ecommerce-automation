package runner;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import runner.utils.Config;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class BaseTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        boolean isCi = Boolean.parseBoolean(System.getenv("CI"));
        String browser = Config.get("browser");

        String optionsString = browser.equalsIgnoreCase("chrome") ?
                (isCi ? Config.get("chrome.options.ci") : Config.get("chrome.options.local")) :
                (isCi ? Config.get("firefox.options.ci") : Config.get("firefox.options.local"));

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments(optionsString.split("\\s+"));
            driver = new ChromeDriver(chromeOptions);
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments(optionsString.split("\\s+"));
            driver = new FirefoxDriver(firefoxOptions);
        }
        else {
            throw new RuntimeException("Property 'browser' is missing in config.properties");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get(Config.get("base.url"));
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

    public WebDriverWait wait(int seconds) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(seconds));
    }
}
