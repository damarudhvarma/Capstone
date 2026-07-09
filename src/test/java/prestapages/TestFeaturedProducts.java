package prestapages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestFeaturedProducts {
	static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
    	driver = new ChromeDriver();
    	driver.get("https://demo.prestashop.com");

        driver.manage().window().maximize();

        driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
        SortProducts fs= new SortProducts(driver);
    	   new WebDriverWait(driver, Duration.ofSeconds(15))
           .until(webDriver -> ((JavascriptExecutor) webDriver)
           .executeScript("return document.readyState").equals("complete"));
    	fs.allFeatures();
    	fs.selectCategory();
    	fs.sortBy();
    	
    	
    }
}
