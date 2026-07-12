package StepDef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Attachment;
import prestapages.ContactUs;
import prestapages.SearchAndAddToCart;

public class SearchAndAddToCartDef {
	SearchAndAddToCart page;
	WebDriver driver;
	@Given("User is on home page to be searched")
	public void user_is_on_home_page_to_be_searched() {

	    driver = new ChromeDriver();
	    page = new SearchAndAddToCart(driver);

	    System.out.println("User is on Home Page");
	}

	        	
	       
	@When("User searches and selects a product")
	public void user_searches_and_selects_a_product() throws InterruptedException {

	    page.clickSearch();
	}

	@Then("the searched Product should be added to shopping cart")
	public void the_searched_product_should_be_added_to_shopping_cart() throws InterruptedException {

	    page.clickAddtocart();

	    System.out.println("Product added to cart successfully");
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
