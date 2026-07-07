package prestapages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	
	 WebDriver driver;
	 JavascriptExecutor js;
	   WebDriverWait wait;
	 public CheckoutPage(WebDriver driver) {
	        this.driver = driver;
	        try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	js=(JavascriptExecutor)driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Initialize explicit wait
	        PageFactory.initElements(driver, this);
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("framelive"));
	        driver.manage().window().maximize();
	        js.executeScript("window.scrollBy(0,700)");

	    }
	  // Added for explicit wait tracking

public void waitForPageLoad() throws InterruptedException {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    wait.until(webDriver ->
        ((JavascriptExecutor) driver)
            .executeScript("return document.readyState")
            .equals("complete"));
    Thread.sleep(1000);
}

	    @FindBy(xpath="//h2[text()='Custom Text Block']")WebElement customtextbox;
	    @FindBy(xpath="//span[text()='Hide']") WebElement hide;
	    @FindBy(xpath = "(//a[@class='product-miniature__title' and normalize-space()='Hummingbird printed t-shirt'])[1]") WebElement product;
	    @FindBy(xpath="//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div[2]/div[2]/button") WebElement add_to_cart;
	    @FindBy(xpath="//a[text()=\"Proceed to checkout\"]") WebElement proceed_checkout;
	    @FindBy(xpath="//div[@class='modal-header']//p//i") WebElement add_to_cart_modal;
	    @FindBy(xpath ="//a[text()='Proceed to checkout']") WebElement Checkout;
	    @FindBy(xpath="//a[contains(@href,'newAddress=delivery')]") WebElement AddNewAddress;
	    @FindBy(id ="field-firstname") WebElement firstname;
	    @FindBy(xpath="//input[@id='field-lastname']")WebElement lastname;
	    @FindBy(xpath="//input[@id='field-email']") WebElement email;
	    @FindBy(id="field-address1")WebElement address;
	    @FindBy(id="field-id_state") WebElement state;
	    @FindBy(id="field-postcode")WebElement postcode;
	    @FindBy(id="field-city")WebElement city;
	    @FindBy(xpath="//div/input[@name=\"psgdpr\"]")WebElement checkbtn1;
		@FindBy(name="customer_privacy")WebElement checkbtn2;
	    @FindBy(id="field-id_country")WebElement country;
	    @FindBy(name="confirm-addresses")WebElement continueaddressbutton;
	    @FindBy(name="confirmDeliveryOption") WebElement Continuetopayment;

@FindBy(xpath="//a[contains(@href,'cart?action=show')]")
WebElement cart;

	    @FindBy(xpath="//*[@id=\"customer-form\"]/footer/button") WebElement continueOnPersonalInfo;
	    
	   public void clickHide() throws InterruptedException {
		   Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(hide));
			hide.click();
		}
		public void selectProduct() throws InterruptedException {
			Thread.sleep(4000);
			//js.executeScript("window.scrollBy(0,200);");
			 js.executeScript("arguments[0].scrollIntoView(true);",customtextbox);
			//js.executeScript("window.scrollBy(0,100);");
			Thread.sleep(3000);
			 js.executeScript("arguments[0].scrollIntoView(true);", product);
			//wait.until(ExpectedConditions.visibilityOfAllElements(product));

/*WebElement ele =
        wait.until(ExpectedConditions.visibilityOf(product));

js.executeScript(
        "arguments[0].scrollIntoView({block:'center'});",
        ele);

System.out.println(
        "X=" + ele.getLocation().getX() +
        " Y=" + ele.getLocation().getY());

Thread.sleep(2000);

ele.click();*/

		     //js.executeScript("arguments[0].scrollIntoView(true);", product);
		     System.out.println("Clicking Product");
		     wait.until(ExpectedConditions.elementToBeClickable(product));
		     product.click();
		    waitForPageLoad();
		    Thread.sleep(2000);
		    js.executeScript("window.scrollBy(0,200)");
		    js.executeScript("arguments[0].scrollIntoView(true);", add_to_cart);
		    Thread.sleep(1000);
		    wait.until(ExpectedConditions.elementToBeClickable(add_to_cart)).click();
		    waitForPageLoad();
		    Thread.sleep(4000);
		    wait.until(ExpectedConditions.visibilityOf(add_to_cart_modal));
		    Thread.sleep(5000);
		    System.out.println("cart modal");
		    wait.until(ExpectedConditions.elementToBeClickable(Checkout)).click();
		    System.out.println("checkout clicked in modal");
		    Thread.sleep(2000);
	    	waitForPageLoad();
	        wait.until(ExpectedConditions.elementToBeClickable(Checkout));
	        Checkout.click();
	        
	        Thread.sleep(2000);
	        wait.until(ExpectedConditions.elementToBeClickable(continueOnPersonalInfo));
	        continueOnPersonalInfo.click();
	        
		}

	    public void clickCheckout() throws InterruptedException {
	    	Thread.sleep(2000);
	    	waitForPageLoad();
	        wait.until(ExpectedConditions.elementToBeClickable(Checkout));
	        Checkout.click();
	    }
	    
	    public void fillingShippingDetails(String homeaddress,  String pincode,String homecity) throws InterruptedException {
	    	
	    	Thread.sleep(3000);
	    	waitForPageLoad();
	    	 js.executeScript("window.scrollBy(0,100)");
	    	wait.until(ExpectedConditions.elementToBeClickable(address));
	    	address.clear();
	    	address.click();
	    	address.sendKeys(homeaddress);
	    	wait.until(ExpectedConditions.elementToBeClickable(city));
	    	city.clear();
	    	city.click();
	    	city.sendKeys(homecity);
	    	new Select(state).selectByVisibleText("California");
	    	postcode.clear();
	    	postcode.click();
	    	postcode.sendKeys(pincode);
	    	new Select(country).selectByVisibleText("United States");	    	
	    }
	    	
	    
	    
	    public void addAddress(String homeaddress,  String pincode,String homecity) {
	    	
	    	wait.until(ExpectedConditions.elementToBeClickable(address));
	    	address.clear();
	    	address.click();
	    	address.sendKeys(homeaddress);
	    	wait.until(ExpectedConditions.elementToBeClickable(city));
	    	city.clear();
	    	city.click();
	    	city.sendKeys(homecity);
	    	new Select(state).selectByVisibleText("California");
	    	postcode.clear();
	    	postcode.click();
	    	postcode.sendKeys(pincode);
	    	new Select(country).selectByVisibleText("United States");	    	
	    }
	    public void addingNewAddress() throws InterruptedException {
	    	AddNewAddress.click();
	    	Thread.sleep(2000);
	    	
	    	
	    }
	    public void clickOnContinue() {
	    	continueaddressbutton.click();
	    }
	    public void clickContinueToPayment() {
	    	Continuetopayment.click();
	    }
	    
	    
	   
	   
	  


}
