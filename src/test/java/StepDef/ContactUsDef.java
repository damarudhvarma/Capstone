package StepDef;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.qameta.allure.Attachment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import prestapages.ContactUs;

public class ContactUsDef {
	
	ContactUs page;
	WebDriver driver;
	private static final Logger logger = LogManager.getLogger(ContactUs.class);

    @Given("User is on Contact Us page")
    public void user_is_on_contact_us_page() {

        driver = new ChromeDriver();

        page = new ContactUs(driver);

        page.clickContactus();
    }


	@When("User enters contact email")
	public void user_enters_contact_email() throws InterruptedException {
	    page.contactEmail();
	    logger.info("email entered..");
	}

	@When("User enters issue message")
	public void user_enters_issue_message() {
	    page.contactissue();
	    logger.info("issues entered..");
	}

	@When("User clicks Send your message button")
	public void user_clicks_send_your_message_button() throws InterruptedException {
	    page.clickcontactsend();
	}

	@Then("Contact Us form should be submitted successfully")
	public void contact_us_form_should_be_submitted_successfully() {
	    System.out.println("Contact Us form submitted successfully");
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
