package StepDef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Capstone_project.Capstone_project.AuthPOM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class presta_registrationsteps {
	
	WebDriver driver;
	
	AuthPOM au;
	
	@Given("the user navigates to the PrestaShop homepage")
	public void the_user_navigates_to_the_presta_shop_homepage() {
	    // Write code here that turns the phrase above into concrete actions
	   
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://demo.prestashop.com/#/en/front");
	}

	@When("the user navigates to the registration page")
	public void the_user_navigates_to_the_registration_page() throws InterruptedException {
		
	    // Write code here that turns the phrase above into concrete actions
	    
	    au=new AuthPOM(driver);
	    au.signup();
	    
	}

	@When("the user submits valid, unique registration details")
	public void the_user_submits_valid_unique_registration_details() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    
	    au=new AuthPOM(driver);
	    au.signup_firstname("damarudh");
	    au.signup_lastname("varma");
	    au.signup_email("varma@example.com");
	    au.signup_password("Varma@12342$");
	    au.signup_checkbox();
	    
	}

	@Then("a new account should be successfully created")
	public void a_new_account_should_be_successfully_created() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		au=new AuthPOM(driver);
		au.signup_create();
	    
	}

	@When("the user signs out from their account")
	public void the_user_signs_out_from_their_account() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		au=new AuthPOM(driver);
		au.signout();
	    
	}

	@Then("the user should be redirected to the landing page as a guest")
	public void the_user_should_be_redirected_to_the_landing_page_as_a_guest() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		au=new AuthPOM(driver);
		
	   
	}

	@When("the user signs back in with the newly created credentials")
	public void the_user_signs_back_in_with_the_newly_created_credentials() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		au=new AuthPOM(driver);
		au.signin("varma@example.com", "Varma@12342$");
	   
	}

	@Then("the user dashboard should display their account name")
	public void the_user_dashboard_should_display_their_account_name() {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

}
