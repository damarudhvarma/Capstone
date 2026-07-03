package Capstone_project.Capstone_project;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFeaturedProducts {
	static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
    	driver = new ChromeDriver();
    	driver.get("https://demo.prestashop.com");

        driver.manage().window().maximize();

        driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(5));
    	FeaturedProductsPOM fs= new FeaturedProductsPOM(driver);
    	fs.allFeatures();
    	fs.selectCategory();
    	fs.sortBy();
    	
    	
    }
}
