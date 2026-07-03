package prestapages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class checkoutandshipping {
	
	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;
	
	
	public checkoutandshipping(WebDriver driver) {
		//driver=new ChromeDriver();
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		js=(JavascriptExecutor)driver;
		//driver.get("https://demo.prestashop.com/#/en/front");
		//driver.manage().window().maximize();
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("framelive"));

	}
	
	@FindBy(name="firstname")WebElement firstname;
	@FindBy(name="lastname")WebElement lastname;
	@FindBy(xpath="//span[text()='Hide']") WebElement hide;
	@FindBy(xpath="//*[@id=\"content\"]/section[3]/div/div[2]/a") WebElement allproducts;
	@FindBy(xpath="//input[@name='s']") WebElement search;
	@FindBy(xpath="/p[text()=\"The best is yet to come' Framed poster\"]") WebElement frame;
	@FindBy(xpath="//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div[2]/div[2]/button") WebElement add_to_cart;
    @FindBy(xpath="//a[text()=\"Proceed to checkout\"]") WebElement proceed_checkout;
    @FindBy(xpath = "//article[@data-id-product=3]") WebElement product;
   // @FindBy(xpath="(//button[contains(normalize-space(.), 'Add to cart')])[1]") WebElement add_to_cart;
   // @FindBy(xpath="//a[text()=\"Proceed to checkout\"]") WebElement proceed_checkout;
    @FindBy(xpath ="//a[text()='Proceed to checkout']") WebElement Checkout;
    @FindBy(xpath="//a[contains(@href,'newAddress=delivery')]") WebElement AddNewAddress;
   // @FindBy(id ="firstname") WebElement firstname;
   // @FindBy(id="lastname")WebElement lastname;
    @FindBy(id="field-address1")WebElement address;
    @FindBy(id="field-id_state") WebElement state;
    @FindBy(id="field-postcode")WebElement postcode;
    @FindBy(id="field-city")WebElement city;
    @FindBy(id="field-id_country")WebElement country;
    @FindBy(name="confirm-addresses")WebElement continueaddressbutton;
    @FindBy(xpath="//button[@name='confirmDeliveryOption']") WebElement Continuetopayment;
    @FindBy(id="payment-option-1") WebElement Bank;
	@FindBy(id="payment-option-2") WebElement COD;
	@FindBy(id="payment-option-3") WebElement Check;
	@FindBy(xpath="//input[@type='checkbox' and @name='conditions_to_approve[terms-and-conditions]']") WebElement Termsandconditions;
    @FindBy(xpath = "//button[@type='submit' and contains(text(),'Place Order')]") WebElement orderbutton;
 
    //@FindBy(css="button[name='confirm-addresses']") WebElement continueAddressBtn;
 
    public void clickHide() {
		wait.until(ExpectedConditions.visibilityOf(hide));
		hide.click();
	}
	public void selectallproducts() throws InterruptedException {
		//wait.until(ExpectedConditions.visibilityOf(allproducts));
		//js.executeScript("arguments[0].scrollIntoView(true);", allproducts);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfAllElements(allproducts));
	     js.executeScript("arguments[0].scrollIntoView(true);",allproducts);
	    wait.until(ExpectedConditions.elementToBeClickable(allproducts)).click();
	    //waitForPageLoad();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(webDriver ->
	        ((JavascriptExecutor) driver)
	            .executeScript("return document.readyState")
	            .equals("complete"));
	    Thread.sleep(2000);
//	    js.executeScript("window.scrollBy(0,200)");
//	    js.executeScript("arguments[0].scrollIntoView(true);", add_to_cart);
//	    Thread.sleep(1000);
//	    wait.until(ExpectedConditions.elementToBeClickable()).click();
//	    waitForPageLoad();
//	    Thread.sleep(3000);
//	    wait.until(ExpectedConditions.elementToBeClickable(Checkout)).click();
//		allproducts.click();
	}
	public void clickSearch() throws InterruptedException {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfAllElements(search));
		 wait.until(ExpectedConditions.elementToBeClickable(search)).click();
		 search.sendKeys("frame");
		 Thread.sleep(4000);
          wait.until(ExpectedConditions.elementToBeClickable(
          By.xpath("//p[contains(text(),'The best is yet to come')]")
          )).click();
		Thread.sleep(2000);
	}
	public void clickAddtocart() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(add_to_cart)).click();
	}
	public void clickProceed() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(proceed_checkout)).click();

	}
//	  public void clickCheckout() {
//	        wait.until(ExpectedConditions.elementToBeClickable(Checkout));
//	        Checkout.click();
//	    }
	public void shippingNames(String fname,String lname)
	{
	    wait.until(ExpectedConditions.visibilityOf(firstname));
 
	    js.executeScript(
	        "arguments[0].scrollIntoView({block:'center'});",
	        firstname);
 
	    wait.until(ExpectedConditions.elementToBeClickable(firstname));
 
	    firstname.clear();
	    firstname.sendKeys(fname);
 
	    lastname.clear();
	    lastname.sendKeys(lname);
	}
 
       public void addAddress(String homeaddress) {
    	   js.executeScript("window.scrollBy(0,1000)");
          wait.until(ExpectedConditions.visibilityOf(address));
 
         js.executeScript("arguments[0].scrollIntoView({block:'center'});", address);
              address.clear();
              address.sendKeys(homeaddress);
         }
 
	    	public void addingCity(String pincode,String homecity) throws InterruptedException {
	    		js.executeScript("window.scrollBy(0,1000)");
              wait.until(ExpectedConditions.visibilityOf(postcode));
               js.executeScript(
                 "arguments[0].scrollIntoView({block:'center'});",
                 postcode);
               postcode.clear();
               postcode.sendKeys(pincode);
               js.executeScript(
            		    "arguments[0].scrollIntoView({block:'center'});",
            		    city);
 
            		wait.until(ExpectedConditions.elementToBeClickable(city));
 
            		city.clear();
            		city.sendKeys(homecity);
 
		    	//js.executeScript("window.scrollBy(0,500)");
		    	//new Select(state).selectByVisibleText("California");
		    	Thread.sleep(2000);
		    	new Select(country).selectByVisibleText("United States");	
		    	//js.executeScript("window.scrollBy(0,500)");
		    	//state.click();
 
                wait.until(ExpectedConditions.presenceOfElementLocated(
                 By.id("field-id_state")));
 
                WebElement stateDropdown =
                driver.findElement(By.id("field-id_state"));
 
                new Select(stateDropdown).selectByVisibleText("California");
 
		    	Thread.sleep(2000);
	    	}

	    public void addingNewAddress() throws InterruptedException {
	    	AddNewAddress.click();
	    	Thread.sleep(2000);

	    }
	    public void clickOnContinue() throws InterruptedException {
 
	        Thread.sleep(2000);
 
	        wait.until(ExpectedConditions.visibilityOf(continueaddressbutton));
 
	        js.executeScript(
	                "arguments[0].scrollIntoView({block:'center'});",
	                continueaddressbutton);
 
	        wait.until(ExpectedConditions.elementToBeClickable(
	                continueaddressbutton));
 
	        js.executeScript(
	                "arguments[0].click();",
	                continueaddressbutton);
	    }
 
	    
 
	    public void clickContinueToPayment() {
 
	        WebDriverWait wait =
	                new WebDriverWait(driver, Duration.ofSeconds(20));
 
	        WebElement button = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//button[@name='confirmDeliveryOption']")));
 
	        ((JavascriptExecutor) driver)
	                .executeScript(
	                        "arguments[0].scrollIntoView({block:'center'});",
	                        button);
 
	        ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].click();", button);
	    }
	    public void selectPaymentMode(String mode) {
			if(mode.equalsIgnoreCase("bank")) {
			Bank.click();
			}
			else if(mode.equalsIgnoreCase("cod")) {
				COD.click();
			}else if(mode.equalsIgnoreCase("check")) {
				Check.click();
			}
			else {
				System.out.println("Invalid payment mode");
			}
		}
	    public void confirmPayment() {
 
	        wait.until(ExpectedConditions.visibilityOf(Termsandconditions));
 
	        js.executeScript(
	                "arguments[0].scrollIntoView({block:'center'});",
	                Termsandconditions);
 
	        js.executeScript("arguments[0].click();", Termsandconditions);
 
	        wait.until(ExpectedConditions.elementToBeClickable(orderbutton));
 
	        js.executeScript(
	                "arguments[0].scrollIntoView({block:'center'});",
	                orderbutton);
 
	        js.executeScript("arguments[0].click();", orderbutton);
	    }

}
