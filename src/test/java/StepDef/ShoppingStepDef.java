package StepDef;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import prestapages.prestaloginandsignup1;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ShoppingStepDef {
	 WebDriver driver;

	 JavascriptExecutor js;
	 prestaloginandsignup1 pr;

@Given("User Signups")
public void user_signups() throws InterruptedException {
	 driver = new ChromeDriver();

     driver.manage().window().maximize();
pr=new prestaloginandsignup1(driver);

	pr.signup();
 pr.signup_firstname("John");
 pr.signup_lastname("Doe");
 pr.signup_email("johndoeacdef@example.com");
 pr.signup_password("12342abcdteam");
 Thread.sleep(2000);
 pr.signup_checkbox();
 pr.signup_create();
}

@And("user clicks on All featured products")
public void user_clicks_on_all_featured_products() throws InterruptedException {
	Thread.sleep(3000);
 Thread.sleep(2000);
 new WebDriverWait(driver, Duration.ofSeconds(15))
 .until(webDriver -> ((JavascriptExecutor) webDriver)
 .executeScript("return document.readyState").equals("complete"));
	Thread.sleep(2000);
    
    pr.selectallproducts();
}

@And("search for the product")
public void search_for_the_product() throws InterruptedException {
	 pr.clickSearch();
	 Thread.sleep(1000);
     JavascriptExecutor js3=(JavascriptExecutor)driver;
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
    
    pr.shippingNames(string,string2);
    JavascriptExecutor js4=(JavascriptExecutor)driver;
    js4.executeScript("window.scrollBy(0,500)");
}

@And("User adds address {string}")
public void user_adds_address(String string) {
    pr.addAddress(string);
    JavascriptExecutor js5=(JavascriptExecutor)driver;
    js5.executeScript("window.scrollBy(0,500)");
}

@And("User enters postcode {string} and {string}")
public void user_enters_postcode(String string,String string2) throws InterruptedException {
	pr.addingCity(string,string2);
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
public void order_should_be_placed_successfully() {
   System.out.println("Sucessfully Placed the order");
}


}
