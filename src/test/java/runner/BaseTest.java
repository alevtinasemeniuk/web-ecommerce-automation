package runner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import runner.utils.Config;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.out.println(">>> base.url from config = " + Config.get("base.url"));

        boolean isCi = Boolean.parseBoolean(System.getenv("CI"));
        String browser = Config.get("browser");
        if (browser == null || browser.isBlank()) {
            throw new RuntimeException("Missing 'browser' property in config.properties");
        }

        String optionsString = browser.equalsIgnoreCase("chrome")
                ? (isCi ? Config.get("chrome.options.ci") : Config.get("chrome.options.local"))
                : (isCi ? Config.get("firefox.options.ci") : Config.get("firefox.options.local"));

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
            throw new RuntimeException("Unsupported browser: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get(Config.get("base.url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (result.getStatus() != ITestResult.FAILURE) {
            driver.quit();
        }
    }

    public WebDriverWait wait(int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }
}
