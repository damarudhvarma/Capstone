package StepDef;

import org.openqa.selenium.JavascriptExecutor;
import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import prestapages.MultipleProductsAdding;

public class MultipleProductsToCart {
	MultipleProductsAdding page;
	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;

@Given("user is on home page")
	public void user_is_on_home_page() throws InterruptedException {
	driver = BaseClass.getDriver();
	page = new MultipleProductsAdding(driver);
		Thread.sleep(1000);
        page.clickSearch();
       Thread.sleep(2000);
        JavascriptExecutor js3=(JavascriptExecutor)driver;
        js3.executeScript("window.scrollBy(0,200)");
        page.clickAddtocart();
        
	}


     @When("User searches product and add to cart")
      public void user_searches_product_and_add_to_cart() throws InterruptedException {

		
        Thread.sleep(1000);
        page.clickSearchTshirt();
        JavascriptExecutor js4=(JavascriptExecutor)driver;
        js4.executeScript("window.scrollBy(0,200)");
        page.clickAddtocart();
	    
	}
     
     
	@Then("two products  should be present in the cart")
	public void two_products_should_be_present_in_the_cart() throws InterruptedException {
	Thread.sleep(2000);
     System.out.println("two products are added tpo cart");
	    
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
