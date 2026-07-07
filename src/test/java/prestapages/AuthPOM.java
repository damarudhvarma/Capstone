package prestapages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPOM {
	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;
	
	
	public AuthPOM(WebDriver driver) {
		//driver=new ChromeDriver();
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		js=(JavascriptExecutor)driver;
		//driver.get("https://demo.prestashop.com/#/en/front");
		driver.manage().window().maximize();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("framelive"));

	}
	
	@FindBy(xpath="//*[@id='_desktop_ps_customersignin']/div/div/a")WebElement signin;
	@FindBy(xpath="//div/a[@class = \"btn btn-outline-primary\"]")WebElement create_your_account;
	//signup page locators
	@FindBy(id="field-id_gender_1")WebElement gender_Mr;
	@FindBy(id="field-id_gender_2")WebElement gender_Mrs;
	@FindBy(name="firstname")WebElement firstname;
	@FindBy(name="lastname")WebElement lastname;
	@FindBy(xpath="//input[@id='field-email']")WebElement email;
	@FindBy(name="password")WebElement password;
	@FindBy(xpath="//div/input[@name=\"psgdpr\"]")WebElement checkbtn1;
	@FindBy(name="customer_privacy")WebElement checkbtn2;
	@FindBy(xpath="//button[@class='btn btn-primary form-control-submit']")WebElement createaccount;
	@FindBy(xpath="//a[contains(normalize-space(),'Sign out')]")WebElement signout;
	@FindBy(xpath="//button[@id='userMenuButton']")WebElement usermenu;
	//signin page locators 
	@FindBy(xpath="//input[@aria-label='Email']")WebElement login_email;
	@FindBy(xpath="//input[@id='field-password']")WebElement login_password;
	@FindBy(xpath="//button[@id='submit-login']")WebElement login;
	
	
	public void signup() throws InterruptedException {

wait.until(ExpectedConditions.invisibilityOfElementLocated(
        By.id("loadingMessage")));

		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(signin));
		 js.executeScript("arguments[0].click();", signin);
		 Thread.sleep(5000);
		  js.executeScript("arguments[0].scrollIntoView(true);", create_your_account);
		wait.until(ExpectedConditions.elementToBeClickable(create_your_account));
		create_your_account.click();
		wait.until(ExpectedConditions.elementToBeClickable(gender_Mr));
		gender_Mr.click();
		//wait.until(ExpectedConditions.elementToBeClickable(gender_Mrs));
		//gender_Mrs.click();
		}
	public void signup_firstname(String fname) {
		wait.until(ExpectedConditions.visibilityOf(firstname));
	firstname.clear();
	firstname.sendKeys(fname);
	}
	public void signup_lastname(String lname) {
	wait.until(ExpectedConditions.visibilityOf(lastname));
		lastname.clear();
		lastname.sendKeys(lname);
		}
	public void signup_email(String mail) throws InterruptedException {
		Thread.sleep(5000);
		 js.executeScript("arguments[0].scrollIntoView(true);", email);
		wait.until(ExpectedConditions.visibilityOf(email));
			email.clear();
			email.sendKeys(mail);
			}
	public void signup_password(String passwrd) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(password));
			password.clear();
			password.sendKeys(passwrd);
			Thread.sleep(1000);
			js.executeScript("arguments[0].scrollIntoView(true);", checkbtn1);
			}
	public void signup_checkbox() throws InterruptedException {
		Thread.sleep(5000);
		 js.executeScript("arguments[0].scrollIntoView(true);", checkbtn1);
		//wait.until(ExpectedConditions.elementToBeClickable(checkbtn1));
		checkbtn1.click();
		//Thread.sleep(5000);
		js.executeScript("arguments[0].scrollIntoView(true);", checkbtn2);
		//wait.until(ExpectedConditions.elementToBeClickable(checkbtn2));
		checkbtn2.click();
			}
	public void signup_create() throws InterruptedException {
		Thread.sleep(2000);
		 js.executeScript("arguments[0].scrollIntoView(true);", createaccount);
		wait.until(ExpectedConditions.elementToBeClickable(createaccount));
		createaccount.click();
			}
	
	public void signout() throws InterruptedException {
	     wait.until(ExpectedConditions.elementToBeClickable(usermenu));
		usermenu.click();
		Thread.sleep(2000);
		//Select se = new Select(usermenu);
		//se.deSelectByContainsVisibleText("Sign out");
		//se.selectByVisibleText(" Sign out ");
		wait.until(ExpectedConditions.visibilityOf(signout));
		 wait.until(ExpectedConditions.elementToBeClickable(signout));
		 signout.click();
		
		
	}
	public void signin(String logmail,String logpasswrd) throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(signin));
		 js.executeScript("arguments[0].click();", signin);
		wait.until(ExpectedConditions.visibilityOf(login_email));
		login_email.clear();
		login_email.sendKeys(logmail);
		wait.until(ExpectedConditions.visibilityOf(login_password));
		login_password.clear();
		login_password.sendKeys(logpasswrd);
		wait.until(ExpectedConditions.elementToBeClickable(login));
		login.click();
		
		
	}
	
	

 
}
