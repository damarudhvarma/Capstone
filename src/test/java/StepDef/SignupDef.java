package StepDef;

import org.openqa.selenium.JavascriptExecutor;
import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
	}

	@Then("User account should be created successfully")
	public void user_account_should_be_created_successfully() throws InterruptedException {
		Thread.sleep(2000);
		pr.signout();
	}

	@Attachment("Step Screenshot View")
	public byte[] allureSaveScreenshot(byte[] screenshot) {
		return screenshot;
	}

}
