package StepDef;
 
import java.time.Duration;
 
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Attachment;
import prestapages.AuthPOM;
import prestapages.FeaturedProductsPOM;
import io.qameta.allure.Attachment;
import prestapages.checkoutandshipping;
 
public class Featuredprodsteps {
	static  WebDriver driver;
	 JavascriptExecutor js;
	 AuthPOM au;
	 FeaturedProductsPOM fs;
	 checkoutandshipping ch;

	@Given("user is logged into the PrestaShop application")
	public void user_is_logged_into_the_presta_shop_application() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		 driver = new ChromeDriver();
 
 
	     driver.manage().window().maximize();
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
		fs.selectprod();
		new WebDriverWait(driver, Duration.ofSeconds(15))
        .until(webDriver -> ((JavascriptExecutor) webDriver)
        .executeScript("return document.readyState").equals("complete"));
	}
 
	@When("user adds the product to the cart")
	public void user_adds_the_product_to_the_cart() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		new WebDriverWait(driver, Duration.ofSeconds(15))
        .until(webDriver -> ((JavascriptExecutor) webDriver)
        .executeScript("return document.readyState").equals("complete"));
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
	}


@io.cucumber.java.AfterStep
public void captureScreenshotAfterEveryStep(io.cucumber.java.Scenario scenario) {
    if (driver != null) {
        try {
            // Cast driver instance to capture raw screenshot bytes
            org.openqa.selenium.TakesScreenshot ts = (org.openqa.selenium.TakesScreenshot) driver;
            byte[] screenshotBytes = ts.getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
            
            // Determine a clean label based on step status
            String statusLabel = scenario.isFailed() ? "Failed_Step_View" : "Passed_Step_View";
            
            // Attach the screenshot directly underneath the current step row
            scenario.attach(screenshotBytes, "image/png", statusLabel);
            
        } catch (Exception e) {
            System.out.println("Failed to capture step screenshot: " + e.getMessage());
        }
    }
}
 
@Attachment("Step Screenshot View")
public byte[] allureSaveScreenshot(byte[] screenshot) {
    return screenshot;
}
 
 

}