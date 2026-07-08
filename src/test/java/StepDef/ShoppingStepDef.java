package StepDef;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import prestapages.FeaturedProductsPOM;
import prestapages.checkoutandshipping;
import prestapages.orderinfo;
import prestapages.prestaloginandsignup1;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ShoppingStepDef {
	static  WebDriver driver;

	 JavascriptExecutor js;
	 prestaloginandsignup1 pr;
	 FeaturedProductsPOM fs;
	 checkoutandshipping c;
	 orderinfo or;

    @Given("User Signups")
    public void user_signups() throws InterruptedException {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        pr = new prestaloginandsignup1(driver);

	pr.signup();
 pr.signup_firstname("John");
 pr.signup_lastname("Doe");
 pr.signup_email("abc@example.com");
 pr.signup_password("12342abcdteam");
 Thread.sleep(2000);
 pr.signup_checkbox();
 pr.signup_create();
 pr.signout();


 pr.signin("abc@example.com","12342abcdteam");
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
}

@And("user clicks on All featured products")
public void user_clicks_on_all_featured_products() throws InterruptedException {
	
	c= new checkoutandshipping(driver);
	System.out.println("in checkout");
	
    c.selectallproducts();
}

    @And("search for the product")
    public void search_for_the_product() throws InterruptedException {
        pr.clickSearch();
        Thread.sleep(1000);
        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        js3.executeScript("window.scrollBy(0,200)");
    }

    @And("lands on product page and add to cart")
    public void lands_on_product_page_and_add_to_cart() throws InterruptedException {
        pr.clickAddtocart();
    }

    @And("procced to checkout")
    public void procced_to_checkout() throws InterruptedException {
        Thread.sleep(1000);
        pr.clickProceed();
        pr.clickProceed();
    }

    @And("User enters shipping names {string} and {string}")
    public void user_enters_shipping_names_and(String string, String string2) throws InterruptedException {
        Thread.sleep(2000);

        pr.shippingNames(string, string2);
        JavascriptExecutor js4 = (JavascriptExecutor) driver;
        js4.executeScript("window.scrollBy(0,500)");
    }

    @And("User adds address {string}")
    public void user_adds_address(String string) {
        pr.addAddress(string);
        JavascriptExecutor js5 = (JavascriptExecutor) driver;
        js5.executeScript("window.scrollBy(0,500)");
    }

    @And("User enters postcode {string} and {string}")
    public void user_enters_postcode(String string, String string2) throws InterruptedException {
        pr.addingCity(string, string2);
    }

    @And("User clicks Continue Address")
    public void user_clicks_continue_address() throws InterruptedException {
        pr.clickOnContinue();
    }

    @And("User clicks Continue To Payment")
    public void user_clicks_continue_to_payment() {
        pr.clickContinueToPayment();
    }

    @And("User selects payment mode {string}")
    public void user_selects_payment_mode(String string) throws InterruptedException {
        Thread.sleep(2000);
        pr.selectPaymentMode(string);
    }

    @And("User confirms the order")
    public void user_confirms_the_order() {
        pr.confirmPayment();
    }

@Then("Order should be placed successfully")
public void order_should_be_placed_successfully() throws IOException, InterruptedException {
	Thread.sleep(3000);
	File src =
		        ((TakesScreenshot) driver)
		        .getScreenshotAs(OutputType.FILE);

		    Files.copy(src, new File("target/confirm-order"+System.currentTimeMillis()+".png"));

   System.out.println("Sucessfully Placed the order");
   
}

// users order details 


@Given("user goes to my orders section")
public void user_goes_to_my_orders_section() throws InterruptedException {
	or=new orderinfo(driver);
	Thread.sleep(3000);
	or.navigateToOrders();
	
}

@And("clicks on order details")
public void clicks_on_order_details() throws InterruptedException {

	or.selectOrderForDetails();
}

@Then("check with order detials")
public void check_with_order_detials() {
or.getOrderDetails();
}

}