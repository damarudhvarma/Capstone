package Testng;

	import java.time.Duration;

import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

import base.BaseClass;
import prestapages.prestaloginandsignup1;

public class Signuptestng {
	
	

	    WebDriver driver;
	    prestaloginandsignup1 pr;
	    WebDriverWait wait;

	    @BeforeTest
	    public void setup() {


	    	    System.out.println(">>> Initializing WebDriver instance...");
	    	        driver = new ChromeDriver();

	    	        driver.manage().window().maximize();

	    	        driver.get("https://demo.prestashop.com/#/en/front");

	    	     

	    	        pr = new prestaloginandsignup1(driver);
	    	    }
	    	    
	    	
	    	
	  

	    @DataProvider(name = "signupData")
	    public Object[][] signupData() {

	        return new Object[][] {

	            {"Damarudh","Varma","damarudh@test.com","Test@1234$"},
	            {"abc","Def","abd@test.com","Test@12$"}

	        };
	    }
	    @Test(priority = 1, dataProvider = "signupData")
	    public void signupTest(String fname,
	                           String lname,
	                           String email,
	                           String password) throws Exception {

	        pr.signup();

	        pr.signup_firstname(fname);

	        pr.signup_lastname(lname);

	        pr.signup_email(email);

	        pr.signup_password(password);

	        pr.signup_checkbox();

	        pr.signup_create();

	        System.out.println("Account Created Successfully");

	        pr.signout();
	    }
	    

	    

	    @AfterTest
	    public void tearDown() {

	        if(driver != null) {
	            driver.quit();
	        }
	    }
	}


