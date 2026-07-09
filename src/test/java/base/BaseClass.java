package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class BaseClass {
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static WebDriver initializeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        tlDriver.set(driver);
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            tlDriver.remove();
        }
    }
}
