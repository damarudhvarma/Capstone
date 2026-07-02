package StepDef;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Capstone_project.Capstone_project.prestaloginandsignup1;
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
	driver = new ChromeDriver();

    driver.manage().window().maximize();
    pr=new prestaloginandsignup1(driver);
   
  
}

@When("User clicks on Sign In")
public void user_clicks_on_sign_in() throws InterruptedException {
	 pr.signup();
}



@And("User enters first name {string}")
public void user_enters_first_name(String string) {
	pr.signup_firstname(string);
}

@And("User enters last name {string}")
public void user_enters_last_name(String string) {
	pr.signup_lastname(string);
}

@And("User enters email {string}")
public void user_enters_email(String string) throws InterruptedException {
	 pr.signup_email(string);
}

@And("User enters password {string}")
public void user_enters_password(String string) throws InterruptedException {
    pr.signup_password(string);
}

@And("User accepts checkboxes")
public void user_accepts_checkboxes() throws InterruptedException {
	 pr.signup_checkbox();
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


}
