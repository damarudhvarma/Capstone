package prestapages;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestFeaturedProducts {
	static WebDriver driver;
	 
    public static void main(String[] args) throws InterruptedException {
    	String email = "fcuhf@gmail.com";
    	driver = new ChromeDriver();
    	driver.get("https://demo.prestashop.com/#/en/front");
 
        driver.manage().window().maximize();
 
        /*driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(5));
        //checkoutandshipping ch=new checkoutandshipping(driver);*/
        FeaturedProductsPOM fs= new FeaturedProductsPOM(driver);
        AuthPOM pr=new AuthPOM(driver);
		pr.signup();
		 
        pr.signup_firstname("John");
 
        pr.signup_lastname("Doe");
 
        pr.signup_email(email);
 
        pr.signup_password("12342abcdteam");
 
        Thread.sleep(2000);
 
        //js=(JavascriptExecutor)driver;
 
        //js.executeScript("window.scrollTo(0, 400);");
 
        pr.signup_checkbox();
//
        pr.signup_create();
 
           pr.signout();


 
       pr.signin(email,"12342abcdteam");
        Thread.sleep(2000);
        
        
        //ch.selectallproducts();
        
        
        
    	//FeaturedProductsPOM fs= new FeaturedProductsPOM(driver);
    	   new WebDriverWait(driver, Duration.ofSeconds(15))
           .until(webDriver -> ((JavascriptExecutor) webDriver)
           .executeScript("return document.readyState").equals("complete"));
    	   //Thread.sleep(3000);
    	//fs.allFeatures();
         Thread.sleep(2000);
    	fs.selectallproducts();
    	fs.selectCategory();
    	fs.sortBy();
    	new WebDriverWait(driver, Duration.ofSeconds(15))
        .until(webDriver -> ((JavascriptExecutor) webDriver)
        .executeScript("return document.readyState").equals("complete"));
    	fs.selectprod();
    	fs.quantity();
    	
    	/*checkoutandshipping ch=new checkoutandshipping(driver);
    	new WebDriverWait(driver, Duration.ofSeconds(15))
        .until(webDriver -> ((JavascriptExecutor) webDriver)
        .executeScript("return document.readyState").equals("complete"));
    	ch.shippingNames("ram","charan");
        JavascriptExecutor js4=(JavascriptExecutor)driver;
        js4.executeScript("window.scrollBy(0,500)");
       ch.addAddress("hyd1");
       JavascriptExecutor js5=(JavascriptExecutor)driver;
       js5.executeScript("window.scrollBy(0,500)");
       ch.addingCity("54444","amalapuram");
       ch.clickOnContinue();
       ch.clickContinueToPayment();
       Thread.sleep(2000);
       ch.selectPaymentMode("cod");
       ch.confirmPayment();*/

    }
}
