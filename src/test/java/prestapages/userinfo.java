package prestapages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class userinfo {
	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;
	public userinfo(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		js=(JavascriptExecutor)driver;
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("framelive"));

		
	}
	
	@FindBy(xpath="//a[normalize-space()='Orders']") WebElement orders;
	@FindBy(xpath="//button[@id='userMenuButton']")WebElement usermenu;
	@FindBy(xpath="//a[@data-link-action='view-order-details']")WebElement orderdetails;
	@FindBy(xpath="//section//h2[@id='order_status_heading']")WebElement orderstatus;
	public void trackorders() throws InterruptedException {
		Thread.sleep(1000);
		 wait.until(ExpectedConditions.elementToBeClickable(usermenu));
			usermenu.click();
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.elementToBeClickable(orders));
			orders.click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(orderdetails));
			 wait.until(ExpectedConditions.elementToBeClickable(orderdetails));
			 orderdetails.click();
			
		
	}

}
