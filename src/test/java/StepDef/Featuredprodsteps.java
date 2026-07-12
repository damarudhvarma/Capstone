package StepDef;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import prestapages.AuthPOM;
import prestapages.FeaturedProductsPOM;
import prestapages.checkoutandshipping;

public class Featuredprodsteps {
	static  WebDriver driver;
	 JavascriptExecutor js;
	 AuthPOM au;
	 FeaturedProductsPOM fs;
	 checkoutandshipping ch;
	 
	 
	
	 
	 @Given("user is logged into the PrestaShop application")
	 public void user_is_logged_into_the_presta_shop_application() throws InterruptedException {

	     driver = new ChromeDriver();
	     driver.manage().window().maximize();
	     Thread.sleep(2000);

	     au = new AuthPOM(driver);

	     au.signup();
	     au.signup_firstname("John");
	     au.signup_lastname("Doe");
	     au.signup_email("abcd@example.com");
	     au.signup_password("12342abcdteam");
	     au.signup_checkbox();
	     au.signup_create();
	 }

	 @When("user navigates to featured products")
	 public void user_navigates_to_featured_products() throws InterruptedException {

	     fs = new FeaturedProductsPOM(driver);
	     fs.allFeatures();
	 }

	 @When("user selects and customizes a product")
	 public void user_selects_and_customizes_a_product() throws InterruptedException {

	     fs.selectCategory();
	     fs.sortBy();
	     fs.selectprod();
	 }

	 @When("user adds the product to the cart")
	 public void user_adds_the_product_to_the_cart() throws InterruptedException {

	     fs.quantity();
	 }

	 @When("user proceeds through checkout and shipping")
	 public void user_proceeds_through_checkout_and_shipping() throws InterruptedException {

	     ch = new checkoutandshipping(driver);

	     ch.shippingNames("ram", "charan");
	     ch.addAddress("hyd1");
	     ch.addingCity("54444", "amalapuram");
	     ch.clickOnContinue();
	     ch.clickContinueToPayment();
	     Thread.sleep(2000);
	     ch.selectPaymentMode("cod");
	 }

	 @Then("checkout page should be displayed successfully")
	 public void checkout_page_should_be_displayed_successfully() {

	     ch.confirmPayment();
	 }
	 
	/*@Given("user is logged into the PrestaShop application")
	public void user_is_logged_into_the_presta_shop_application() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		 driver = new ChromeDriver();


	     driver.manage().window().maximize();
	     Thread.sleep(1000);
	     new WebDriverWait(driver, Duration.ofSeconds(15))
	        .until(webDriver -> ((JavascriptExecutor) webDriver)
	        .executeScript("return document.readyState").equals("complete"));
		au=new AuthPOM(driver); 
		au.signup();
		 au.signup_firstname("John");
		 au.signup_lastname("Doe");
		 au.signup_email("abc@example.com");
		 au.signup_password("12342abcdteam");
		 Thread.sleep(2000);
		 au.signup_checkbox();
		 au.signup_create();
	   
	}

	@When("user navigates to featured products")
	public void user_navigates_to_featured_products() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		fs=new FeaturedProductsPOM(driver);
		fs.allFeatures();  
	}

	@When("user selects and customizes a product")
	public void user_selects_and_customizes_a_product() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		fs.selectCategory();
		fs.sortBy();
		new WebDriverWait(driver, Duration.ofSeconds(15))
        .until(webDriver -> ((JavascriptExecutor) webDriver)
        .executeScript("return document.readyState").equals("complete"));
		
		fs.selectprod();
		
	    
	}

	@When("user adds the product to the cart")
	public void user_adds_the_product_to_the_cart() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		new WebDriverWait(driver, Duration.ofSeconds(15))
        .until(webDriver -> ((JavascriptExecutor) webDriver)
        .executeScript("return document.readyState").equals("complete"));
		Thread.sleep(2000);
		fs.quantity();
	}

	@When("user proceeds through checkout and shipping")
	public void user_proceeds_through_checkout_and_shipping() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		ch=new checkoutandshipping(driver);
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
	   
	}

	@Then("checkout page should be displayed successfully")
	public void checkout_page_should_be_displayed_successfully() {
	    // Write code here that turns the phrase above into concrete actions
		 ch.confirmPayment();
	    
	}*/
	 
	


}
