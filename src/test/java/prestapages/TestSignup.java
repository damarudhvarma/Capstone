package prestapages;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TestSignup {
	static WebDriver driver;
	static JavascriptExecutor js;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-save-password-bubble");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("autofill.profile_enabled", false);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);

		 driver = new ChromeDriver();
	        driver.manage().window().maximize();
		AuthPOM pr=new AuthPOM(driver);
		pr.signup();
		 
        pr.signup_firstname("John");
 
        pr.signup_lastname("Doe");
 
        pr.signup_email("johndoeacdef@example.com");
 
        pr.signup_password("12342abcdteam");
 
        Thread.sleep(2000);
 
        //js=(JavascriptExecutor)driver;
 
        //js.executeScript("window.scrollTo(0, 400);");
 
        pr.signup_checkbox();
//
        pr.signup_create();
 
           pr.signout();


 
       pr.signin("johndoeacdef@example.com","12342abcdteam");
        Thread.sleep(2000);
          // pr.checkSignin();
           Thread.sleep(3000);
           JavascriptExecutor js2=(JavascriptExecutor)driver;
           js2.executeScript("window.scrollBy(0,1000)");
           System.out.println("scrolled");
        Thread.sleep(2000);
        new WebDriverWait(driver, Duration.ofSeconds(15))
        .until(webDriver -> ((JavascriptExecutor) webDriver)
        .executeScript("return document.readyState").equals("complete"));
        
        /*CheckoutPage ch=new CheckoutPage(driver);
        ch.waitForPageLoad();
        Thread.sleep(1000);
        ch.selectProduct();
        ch.clickCheckout();*/
        
//    
//       // pr.clickHide();
        
       checkoutandshipping c=new checkoutandshipping(driver);
        Thread.sleep(2000);
        c.selectallproducts();
        c.clickSearch();
        Thread.sleep(1000);
        JavascriptExecutor js3=(JavascriptExecutor)driver;
        js3.executeScript("window.scrollBy(0,200)");
        c.clickAddtocart();
        Thread.sleep(1000);
        c.clickProceed();
        c.clickProceed();
        Thread.sleep(2000);
         c.shippingNames("ram","charan");
         JavascriptExecutor js4=(JavascriptExecutor)driver;
         js4.executeScript("window.scrollBy(0,500)");
        c.addAddress("hyd1");
        JavascriptExecutor js5=(JavascriptExecutor)driver;
        js5.executeScript("window.scrollBy(0,500)");
        c.addingCity("54444","amalapuram");
        c.clickOnContinue();
        c.clickContinueToPayment();
        Thread.sleep(2000);
        c.selectPaymentMode("cod");
        c.confirmPayment();
        
        orderinfo or=new orderinfo(driver);
        or.trackorders();


 
	
     
	}


	

}
