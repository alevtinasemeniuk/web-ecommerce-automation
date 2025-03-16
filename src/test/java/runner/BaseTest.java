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
    protected WebDriver driver;
    private WebDriverWait wait5;

    @BeforeMethod
    public void setUp() {
        // Использование WebDriverManager для автоматической загрузки драйвера
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // Проверяем, если мы находимся в CI/CD (например, на GitHub Actions)
        String ciEnv = System.getenv("CI");
        if (ciEnv != null && ciEnv.equals("true")) {
            // В CI включаем headless режим
            options.addArguments("--headless", "--disable-gpu", "--no-sandbox", "--disable-dev-shm-usage", "--window-size=1920x1080");
        } else {
            // На локальной машине используем обычный браузер
            // options.addArguments("--headless"); // Оставляем без этой опции для локальной работы
        }

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
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
