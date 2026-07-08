package prestapages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class orderinfo {
	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;
	public orderinfo(WebDriver driver) {
		this.driver=driver;
		//driver.get("https://demo.prestashop.com/#/en/front");
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		js=(JavascriptExecutor)driver;
		
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("framelive"));

		
	}
	
	@FindBy(xpath="//a[contains(@class,'navbar-brand')]")WebElement mystore;
	@FindBy(xpath="//a[contains(@href,'order-history')]") WebElement orders;
	@FindBy(xpath="//button[@id='userMenuButton']")WebElement usermenu;
	@FindBy(xpath="//a[@data-link-action='view-order-details']")WebElement orderdetails;
	@FindBy(xpath="//section//h2[@id='order_status_heading']")WebElement ordersstatus;
    @FindBy(xpath="//span[@data-ps-label='Date']")WebElement orderDate;
    @FindBy(xpath="//span[@data-ps-label='Status']//span")WebElement orderStatus;

	@FindBy(xpath="//h3[normalize-space()='Addresses']")WebElement ordersaddres;
	@FindBy(xpath="//h3[normalize-space()='Products details']")WebElement proddetail;

    @FindBy(xpath="//a[contains(@class,'order-product__name')]")WebElement productName;
    @FindBy(xpath="//span[@data-ps-label='Quantity']")WebElement quantity;
    @FindBy(xpath="//span[@data-ps-label='Total price']")WebElement totalPrice;

	public void trackorders() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(mystore));
		mystore.click();
		Thread.sleep(2000);
		 wait.until(ExpectedConditions.elementToBeClickable(usermenu));
			usermenu.click();
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.visibilityOf(orders));
			wait.until(ExpectedConditions.elementToBeClickable(orders));
			orders.click();
			Thread.sleep(1000);
			
			// in orders details page
			wait.until(ExpectedConditions.visibilityOf(orderdetails));
			 wait.until(ExpectedConditions.elementToBeClickable(orderdetails));
			 orderdetails.click();
			 Thread.sleep(2000);
			 
			 //order status
			 js.executeScript("window.scrollBy(0, 100);");
			 wait.until(ExpectedConditions.visibilityOf(ordersstatus));
			 js.executeScript("arguments[0].scrollIntoView(true);", ordersstatus);
			 
             wait.until(ExpectedConditions.visibilityOf(orderDate));
             wait.until(ExpectedConditions.visibilityOf(orderStatus));
             System.out.println("Order Date: " + orderDate.getText().trim());
             System.out.println("Order Status: " + orderStatus.getText().trim());

			 
			 js.executeScript("window.scrollBy(0, 100);");
			 
			 
			 //order address
			 js.executeScript("window.scrollBy(0, 100);");
			 wait.until(ExpectedConditions.visibilityOf(ordersaddres));
			 js.executeScript("arguments[0].scrollIntoView(true);", ordersaddres);
			 js.executeScript("window.scrollBy(0, 100);");
			 
			 
			 
			 //order product details
			 js.executeScript("window.scrollBy(0, 100);");
			 wait.until(ExpectedConditions.visibilityOf(proddetail));
			 js.executeScript("arguments[0].scrollIntoView(true);", proddetail);
             wait.until(ExpectedConditions.visibilityOf(productName));
             wait.until(ExpectedConditions.visibilityOf(quantity));
             wait.until(ExpectedConditions.visibilityOf(totalPrice));

             System.out.println("===== PRODUCT DETAILS =====");
             System.out.println("Product Name : " + productName.getText().trim());
             System.out.println("Quantity     : " + quantity.getText().trim());
             System.out.println("Total Price  : " + totalPrice.getText().trim());
             String actualProduct = productName.getText().trim();

              Assert.assertTrue(actualProduct.contains("Hummingbird printed t-shirt"),"Product name is incorrect");


			 js.executeScript("window.scrollBy(0, 100);");
			 
			 
			
			 
	}
	
	public void navigateToOrders() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(mystore));
		mystore.click();
		Thread.sleep(2000);
		 wait.until(ExpectedConditions.elementToBeClickable(usermenu));
			usermenu.click();
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.visibilityOf(orders));
			wait.until(ExpectedConditions.elementToBeClickable(orders));
			orders.click();
			Thread.sleep(1000);
	}
	
	public void selectOrderForDetails() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(orderdetails));
		 wait.until(ExpectedConditions.elementToBeClickable(orderdetails));
		 orderdetails.click();
		 Thread.sleep(2000);
	}
	
	public void getOrderDetails() {
		 //order status
		 js.executeScript("window.scrollBy(0, 100);");
		 wait.until(ExpectedConditions.visibilityOf(ordersstatus));
		 js.executeScript("arguments[0].scrollIntoView(true);", ordersstatus);
		 
        wait.until(ExpectedConditions.visibilityOf(orderDate));
        wait.until(ExpectedConditions.visibilityOf(orderStatus));
        System.out.println("Order Date: " + orderDate.getText().trim());
        System.out.println("Order Status: " + orderStatus.getText().trim());

		 
		 js.executeScript("window.scrollBy(0, 100);");
		 
		 
		 //order address
		 js.executeScript("window.scrollBy(0, 100);");
		 wait.until(ExpectedConditions.visibilityOf(ordersaddres));
		 js.executeScript("arguments[0].scrollIntoView(true);", ordersaddres);
		 js.executeScript("window.scrollBy(0, 100);");
		 
		 
		 
		 //order product details
		 js.executeScript("window.scrollBy(0, 100);");
		 wait.until(ExpectedConditions.visibilityOf(proddetail));
		 js.executeScript("arguments[0].scrollIntoView(true);", proddetail);
        wait.until(ExpectedConditions.visibilityOf(productName));
        wait.until(ExpectedConditions.visibilityOf(quantity));
        wait.until(ExpectedConditions.visibilityOf(totalPrice));

        System.out.println("===== PRODUCT DETAILS =====");
        System.out.println("Product Name : " + productName.getText().trim());
        System.out.println("Quantity     : " + quantity.getText().trim());
        System.out.println("Total Price  : " + totalPrice.getText().trim());
        String actualProduct = productName.getText().trim();

         Assert.assertTrue(actualProduct.contains("Hummingbird printed t-shirt"),"Product name is incorrect");


		 js.executeScript("window.scrollBy(0, 100);");
		 
	}
}