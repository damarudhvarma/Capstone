package Testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import prestapages.ContactUs;


public class Contactustestng {
	 WebDriver driver;
	   ContactUs pr;
	    WebDriverWait wait;


          @BeforeTest
        @Parameters({"browser","url"})
       public void setup(String browser ,String url) {

        System.out.println(">>> Initializing WebDriver instance...");


        System.out.println("Browser : " + browser);
         System.out.println("URL : " + url);

          if(browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();

               }
         else if(browser.equalsIgnoreCase("edge")) {

           driver = new EdgeDriver();

         }


          driver.manage().window().maximize();

          driver.get(url);

           pr = new ContactUs(driver);
           }

	    @Test(priority = 1)
	    public void clickContactUsTest() {

	        pr.clickContactus();

	        System.out.println("Clicked Contact Us");
	    }
	    
	    
	    @Test(priority = 2)
	    public void enterEmailTest() throws Exception {

	        Thread.sleep(3000);

	        pr.contactEmail();

	        System.out.println("Email Entered");
	    }
	    
	    
	    @Test(priority = 3)
	    public void enterIssueTest() throws Exception {

	        

	        pr.contactissue();

	        System.out.println("Issue Entered");
	    }
	    @Test(priority = 4)
	    public void sendMessageTest() throws Exception {
	    	
	    

	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        js.executeScript("window.scrollBy(0,500)");

	        Thread.sleep(2000);

	        pr.clickcontactsend();

	        System.out.println("Message Sent Successfully");
	    }
	    
	    
	    
	    
		@AfterTest
	    public void tearDown() {

	        if(driver != null) {
	            driver.quit();
	        }
	    }
	    }
	    
