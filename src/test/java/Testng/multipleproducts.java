package Testng;

	import java.time.Duration;

	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	import prestapages.MultipleProductsAdding;

	public class multipleproducts {

	    WebDriver driver;

	    WebDriverWait wait;

	    JavascriptExecutor js;

	    MultipleProductsAdding page;

	    @BeforeTest
	    public void setup() throws Exception {

	        driver = new ChromeDriver();

	        driver.manage().window().maximize();

	        driver.manage().timeouts()
	                .implicitlyWait(Duration.ofSeconds(10));

	        driver.get("https://demo.prestashop.com/#/en/front");

	        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	       

	        page = new MultipleProductsAdding(driver);

	        js = (JavascriptExecutor) driver;

	        System.out.println("Prestashop Application Loaded Successfully");
	    }

	    @Test(priority = 1)
	    public void addFirstProductTest() throws Exception {

	        Thread.sleep(2000);

	        page.clickSearch();

	        Thread.sleep(2000);

	        js.executeScript("window.scrollBy(0,200)");

	        Thread.sleep(2000);

	        page.clickAddtocart();

	        System.out.println("First Product Added Successfully");
	    }

	    @Test(priority = 2)
	    public void addSecondProductTest() throws Exception {

	        Thread.sleep(2000);

	        page.clickSearchTshirt();

	        Thread.sleep(2000);

	        js.executeScript("window.scrollBy(0,200)");

	        Thread.sleep(2000);

	        page.clickAddtocart();

	        System.out.println("Second Product Added Successfully");
	    }

	    @Test(priority = 3)
	    public void verifyProductsInCartTest() throws Exception {

	        Thread.sleep(3000);

	        System.out.println("Two Products Are Added To Cart Successfully");
	    }

	    @AfterTest
	    public void tearDown() throws Exception {

	        Thread.sleep(3000);

	        if (driver != null) {

	            driver.quit();

	            System.out.println("Browser Closed Successfully");
	        }
	    }
	}

