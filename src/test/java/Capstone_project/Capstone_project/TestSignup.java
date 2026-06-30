package Capstone_project.Capstone_project;

import org.openqa.selenium.WebDriver;

public class TestSignup {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	
		// TODO Auto-generated method stub
		AuthPOM ob = new AuthPOM(driver);
		ob.signup();        
		ob.signup_firstname("damarudh");
        ob.signup_lastname("varma");
        ob.signup_email("varma@example.com");
        ob.signup_password("Varma@12342$");
        Thread.sleep(2000);
        
        ob.signup_checkbox();
        ob.signup_create();
		

	}

}
