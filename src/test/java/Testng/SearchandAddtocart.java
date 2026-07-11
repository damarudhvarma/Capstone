package Testng;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import prestapages.SearchAndAddToCart;

public class SearchandAddtocart {

    WebDriver driver;

    SearchAndAddToCart page;

    @BeforeTest
    public void setup() {

    	 System.out.println(">>> Initializing WebDriver instance...");
	        driver = new ChromeDriver();

	        driver.manage().window().maximize();

	        driver.get("https://demo.prestashop.com/#/en/front");

        page = new SearchAndAddToCart(driver);
        

        System.out.println("User is on Home Page");
    }

    @Test(priority = 1)
    public void searchProductTest() throws Exception {

        page.clickSearch();

        System.out.println("Product Searched Successfully");
        
    }

    @Test(priority = 2)
    public void addToCartTest() throws Exception {
    	Thread.sleep(2000);
        JavascriptExecutor js3=(JavascriptExecutor)driver;
        js3.executeScript("window.scrollBy(0,200)");

    	

        page.clickAddtocart();

        System.out.println("Product Added To Cart Successfully");
    }

    @AfterTest
    public void tearDown() {

        if (driver != null) {

            driver.quit();
        }
    }
}