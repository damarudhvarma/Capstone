package Capstone_project.Capstone_project;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class prestarunpages1 {

	static WebDriver driver;

	static JavascriptExecutor js;
 
	public static void main(String[] args) throws InterruptedException {

		// TODO Auto-generated method stub

		 driver = new ChromeDriver();

	        driver.manage().window().maximize();

		prestaloginandsignup1 pr=new prestaloginandsignup1(driver);

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
//    
//       // pr.clickHide();
        Thread.sleep(2000);
        
        pr.selectallproducts();
        pr.clickSearch();
        Thread.sleep(1000);
        JavascriptExecutor js3=(JavascriptExecutor)driver;
        js3.executeScript("window.scrollBy(0,200)");
        pr.clickAddtocart();
        Thread.sleep(1000);
        pr.clickProceed();
        pr.clickProceed();
        Thread.sleep(2000);
        
         pr.shippingNames("ram","charan");
         JavascriptExecutor js4=(JavascriptExecutor)driver;
         js4.executeScript("window.scrollBy(0,500)");
       
        pr.addAddress("hyd1");
        JavascriptExecutor js5=(JavascriptExecutor)driver;
        js5.executeScript("window.scrollBy(0,500)");
        pr.addingCity("54444","amalapuram");
        pr.clickOnContinue();
        pr.clickContinueToPayment();
        Thread.sleep(2000);
        pr.selectPaymentMode("cod");
        pr.confirmPayment();
        
        
        

	}
 
}

 