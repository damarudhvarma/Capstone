package StepDef;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseClass;
import hooks.Hooks;
//import hooks.Hooks;
import prestapages.prestaloginandsignup1;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignupDef {
	WebDriver driver;

	JavascriptExecutor js;
	prestaloginandsignup1 pr;

	@Given("User launches Prestashop application")
	public void user_launches_prestashop_application() {
		pr = new prestaloginandsignup1(BaseClass.getDriver());
		

	}

	@When("User clicks on Sign In")
	public void user_clicks_on_sign_in() throws InterruptedException {
		pr.signup();
	}



@And("User enters first name {string}")
public void user_enters_first_name(String fname) {
	pr.signup_firstname(fname);
}

@And("User enters last name {string}")
public void user_enters_last_name(String lname) {
	pr.signup_lastname(lname);
}

@And("User enters email {string}")
public void user_enters_email(String email) throws InterruptedException {
	 pr.signup_email(email);
}

@And("User accepts checkboxes")
public void user_accepts_checkboxes() throws InterruptedException {
    pr.signup_checkbox();
}

@And("User enters password {string}")
public void user_enters_password(String password) throws InterruptedException {
    pr.signup_password(password);
}

	@And("User clicks on Create Account")
	public void user_clicks_on_create_account() throws InterruptedException {
		pr.signup_create();
//		Thread.sleep(3000);
//		Assert.assertTrue(pr.isHomePageElementPresent(),
//		        "Custom Text Block element is not present on the page");
	}

	@Then("User account should be created successfully")
	public void user_account_should_be_created_successfully() throws InterruptedException {
		Thread.sleep(2000);
		pr.signout();
	}
	
	// Scenario 2 
	
	@Given("User navigates to registration page")
	public void user_navigates_to_registration_page() throws InterruptedException {
		pr = new prestaloginandsignup1(BaseClass.getDriver());
		driver= BaseClass.getDriver();
		new WebDriverWait(driver, Duration.ofSeconds(15))
	    .until(webDriver -> ((JavascriptExecutor) webDriver)
	    .executeScript("return document.readyState").equals("complete"));
		pr.signup();  // Opens Sign In -> Create Account page5}
	}
	 
	@When("User submits registration form without entering mandatory details")
	public void user_submits_registration_form_without_entering_mandatory_details() throws InterruptedException {
		    pr.signup_create(); // Click Create Account directly5}
	}
	 
	@Then("Registration validation message should be displayed")
	public void registration_validation_message_should_be_displayed() {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("registration") ||currentUrl.contains("authentication"),
			"User was redirected unexpectedly");
		System.out.println("Validation successfully triggered.");
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
